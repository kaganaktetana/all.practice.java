package semester1.practice08;

public class Task_27 {
    public static void main(String[] args) {

        CashbackPlatinumCard card = new CashbackPlatinumCard(
                "Тетяна",
                10000,
                3000,
                5
        );

        System.out.println("Початковий стан:");
        System.out.println(card);

        System.out.println("\nПокупка на 1000 грн:");
        System.out.println("Оплата успішна: " + card.pay(1000));

        System.out.println("\nПокупка на 4000 грн:");
        System.out.println("Оплата успішна: " + card.pay(4000));

        System.out.println("\nКінцевий стан:");
        System.out.println(card);
    }
}

class PaymentCard {
    private String cardHolder;
    protected double balance;

    public PaymentCard(String cardHolder, double balance) {
        this.cardHolder = cardHolder;
        this.balance = balance;
    }

    public boolean pay(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    @Override
    public String toString() {
        return "Власник: " + cardHolder
                + ", баланс: " + balance + " грн";
    }
}

class DebitCard extends PaymentCard {
    private double dailyLimit;

    public DebitCard(String cardHolder, double balance,
                     double dailyLimit) {
        super(cardHolder, balance);

        this.dailyLimit = dailyLimit;
    }

    @Override
    public boolean pay(double amount) {
        if (amount > dailyLimit) {
            return false;
        }

        return super.pay(amount);
    }

    public double getDailyLimit() {
        return dailyLimit;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", денний ліміт: " + dailyLimit + " грн";
    }
}

class CashbackPlatinumCard extends DebitCard {
    private double cashbackPercent;
    private double accumulatedCashback;

    public CashbackPlatinumCard(String cardHolder, double balance,
                                double dailyLimit,
                                double cashbackPercent) {
        super(cardHolder, balance, dailyLimit);

        this.cashbackPercent = cashbackPercent;
        this.accumulatedCashback = 0;
    }

    @Override
    public boolean pay(double amount) {
        boolean success = super.pay(amount);

        if (success) {
            accumulatedCashback += amount * cashbackPercent / 100.0;
        }

        return success;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", кешбек: " + cashbackPercent + "%"
                + ", накопичений кешбек: "
                + accumulatedCashback + " грн";
    }
}