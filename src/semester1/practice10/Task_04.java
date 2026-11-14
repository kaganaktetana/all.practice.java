
package semester1.practice10;

class NotificationSender {
    private final String recipient;

    public NotificationSender(String recipient) {
        this.recipient = recipient;
    }

    protected String getRecipient() {
        return recipient;
    }

    public String send(String message) {
        return "Повідомлення для " + recipient + ": " + message;
    }
}

class EmailSender extends NotificationSender {

    public EmailSender(String recipient) {
        super(recipient);
    }

    @Override
    public String send(String message) {
        return "Email для " + getRecipient()
                + "\nТема: Важливе сповіщення"
                + "\nТекст: " + message;
    }
}

class SmsSender extends NotificationSender {

    public SmsSender(String recipient) {
        super(recipient);
    }

    @Override
    public String send(String message) {

        if (message.length() > 70) {
            message = message.substring(0, 70);
        }

        return "SMS для " + getRecipient() + ": " + message;
    }
}

class TelegramBotSender extends NotificationSender {

    public TelegramBotSender(String recipient) {
        super(recipient);
    }

    @Override
    public String send(String message) {
        return "Telegram для " + getRecipient()
                + ": 🚨 *" + message + "* 🚨";
    }
}

public class Task_04 {

    public static void broadcastAlert(
            NotificationSender[] senders,
            String alertText
    ) {

        for (NotificationSender sender : senders) {
            System.out.println(sender.send(alertText));
            System.out.println();
        }
    }

    public static void main(String[] args) {

        NotificationSender[] senders = {
                new EmailSender("user@gmail.com"),
                new SmsSender("+380991234567"),
                new TelegramBotSender("@user")
        };

        String alertText = "УВАГА! Виявлено небезпеку. "
                + "Будь ласка, дотримуйтеся правил безпеки.";

        broadcastAlert(senders, alertText);
    }
}
