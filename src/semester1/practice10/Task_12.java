
package semester1.practice10;

interface DataValidator {

    boolean isValid(String input);

    default String validateOrDefault(String input, String fallback) {
        if (isValid(input)) {
            return input;
        }

        return fallback;
    }

    static boolean isNotNullOrBlank(String s) {
        return s != null && !s.isBlank();
    }
}

class EmailValidator implements DataValidator {

    @Override
    public boolean isValid(String input) {

        if (!DataValidator.isNotNullOrBlank(input)) {
            return false;
        }

        return input.contains("@")
                && input.contains(".")
                && input.indexOf("@") < input.lastIndexOf(".");
    }
}

class PositiveNumberValidator implements DataValidator {

    @Override
    public boolean isValid(String input) {

        if (!DataValidator.isNotNullOrBlank(input)) {
            return false;
        }

        try {
            return Double.parseDouble(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

abstract class Task_12 {

    public static void main(String[] args) {

        DataValidator emailValidator = new EmailValidator();
        DataValidator numberValidator = new PositiveNumberValidator();

        System.out.println("Перевірка email:");

        System.out.println(emailValidator.isValid("test@gmail.com"));
        System.out.println(emailValidator.isValid("testgmail.com"));

        System.out.println(
                emailValidator.validateOrDefault(
                        "invalidEmail",
                        "default@gmail.com"
                )
        );

        System.out.println();

        System.out.println("Перевірка числа:");

        System.out.println(numberValidator.isValid("25"));
        System.out.println(numberValidator.isValid("-10"));

        System.out.println(
                numberValidator.validateOrDefault(
                        "-5",
                        "100"
                )
        );
    }
}
