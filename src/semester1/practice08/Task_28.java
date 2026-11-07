package semester1.practice08;

public class Task_28 {
    public static void main(String[] args) {

        CustomTerminal terminal = new CustomTerminal();

        System.out.println(terminal.getWelcomeBanner());

        String hash = terminal.generateAuthHash("tanya");

        System.out.println("Авторизаційний підпис: " + hash);
    }
}

class SecurityTerminal {

    public final String generateAuthHash(String user) {
        return "AUTH-SHA-" + user.toUpperCase();
    }

    public String getWelcomeBanner() {
        return "Ласкаво просимо до системи безпеки!";
    }
}

class CustomTerminal extends SecurityTerminal {

    @Override
    public String getWelcomeBanner() {
        return "Вітаємо! Ви використовуєте Custom Terminal.";
    }

    /*
     * НЕ МОЖНА перевизначити generateAuthHash()!
     *
     * Метод у SecurityTerminal має модифікатор final.
     * Тому спроба написати:
     *
     * @Override
     * public String generateAuthHash(String user) {
     *     return "Інший підпис";
     * }
     *
     * викличе помилку компіляції.
     */
}