
package semester1.practice12;

import java.util.*;

public class Task_35 {

    static final class EmailMessage {
        private final String id;
        private final String senderDomain;
        private final String subject;
        private final double spamScore;

        public EmailMessage(
                String id,
                String senderDomain,
                String subject,
                double spamScore) {

            this.id = id;
            this.senderDomain = senderDomain;
            this.subject = subject;
            this.spamScore = spamScore;
        }

        public String getId() {
            return id;
        }

        public String getSenderDomain() {
            return senderDomain;
        }

        public String getSubject() {
            return subject;
        }

        public double getSpamScore() {
            return spamScore;
        }

        @Override
        public String toString() {
            return id + " | " + senderDomain
                    + " | " + subject
                    + " | spamScore=" + spamScore;
        }
    }

    public static void main(String[] args) {

        Set<String> blacklistedDomains = new HashSet<>(
                Arrays.asList("spam.com", "fraud.net"));

        List<EmailMessage> inbox = new ArrayList<>();

        inbox.add(new EmailMessage(
                "M-01", "gmail.com", "Привіт", 0.1));

        inbox.add(new EmailMessage(
                "M-02", "spam.com", "Виграш призу", 0.9));

        inbox.add(new EmailMessage(
                "M-03", "company.ua", "Робочий звіт", 0.2));

        inbox.add(new EmailMessage(
                "M-04", "fraud.net", "Підозрілий лист", 0.7));

        inbox.add(new EmailMessage(
                "M-05", "gmail.com", "Реклама", 0.95));

        inbox.add(new EmailMessage(
                "M-01", "gmail.com", "Дублікат", 0.1));

        inbox.add(new EmailMessage(
                "M-06", "outlook.com", "Навчання", 0.3));

        int blockedCount = 0;
        int spamCount = 0;
        int duplicateCount = 0;

        Set<String> seenIds = new HashSet<>();

        Iterator<EmailMessage> it = inbox.iterator();

        System.out.println("=== АНТИСПАМ-ФІЛЬТР ===");

        while (it.hasNext()) {

            EmailMessage email = it.next();

            // Перевірка чорного списку
            if (blacklistedDomains.contains(
                    email.getSenderDomain())) {

                System.out.println("BLACKLIST: " + email);
                it.remove();
                blockedCount++;

                // Перевірка спам-оцінки
            } else if (email.getSpamScore() >= 0.8) {

                System.out.println("SPAM: " + email);
                it.remove();
                spamCount++;

                // Перевірка дублікатів
            } else if (!seenIds.add(email.getId())) {

                System.out.println("DUPLICATE: " + email);
                it.remove();
                duplicateCount++;
            }
        }

        System.out.println("\n=== ДОСТАВЛЕНІ ЛИСТИ ===");

        for (EmailMessage email : inbox) {
            System.out.println(email);
        }

        System.out.println("\n=== ЗВІТ ===");

        System.out.println("Доставлено: " + inbox.size());
        System.out.println("Чорний список: " + blockedCount);
        System.out.println("Спам: " + spamCount);
        System.out.println("Дублікати: " + duplicateCount);
        System.out.println("Всього відфільтровано: "
                + (blockedCount + spamCount + duplicateCount));
    }
}
