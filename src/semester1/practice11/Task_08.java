
package semester1.practice11;

public class Task_08 {

    public static void convertNumberSystems(int number) {

        System.out.println("Десяткова система: " + number);

        System.out.println("Двійкова система: "
                + Integer.toBinaryString(number));

        System.out.println("Вісімкова система: "
                + Integer.toOctalString(number));

        System.out.println("Шістнадцяткова система: "
                + Integer.toHexString(number));
    }

    public static void main(String[] args) {

        convertNumberSystems(42);

        int binary = Integer.parseInt("101010", 2);
        int hexadecimal = Integer.parseInt("FF", 16);

        System.out.println("101010 у десятковій системі: " + binary);
        System.out.println("FF у десятковій системі: " + hexadecimal);
    }
}
