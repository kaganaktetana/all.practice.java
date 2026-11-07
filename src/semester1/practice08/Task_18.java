package semester1.practice08;

public class Task_18 {
    public static void main(String[] args) {
        StandardTransfer standard = new StandardTransfer(1000);

        InternationalTransfer international =
                new InternationalTransfer(1000, "US");

        System.out.println(standard);
        System.out.println(international);
    }
}

class StandardTransfer {
    protected double amount;

    public StandardTransfer(double amount) {
        this.amount = amount;
    }

    public double getFee() {
        return amount * 0.01;
    }

    public double getTotalWithFee() {
        return amount + getFee();
    }

    @Override
    public String toString() {
        return "Стандартний переказ: сума = " + amount
                + ", комісія = " + getFee()
                + ", разом = " + getTotalWithFee();
    }
}

class InternationalTransfer extends StandardTransfer {
    private String countryCode;

    public InternationalTransfer(double amount, String countryCode) {
        super(amount);

        this.countryCode = countryCode;
    }

    @Override
    public double getFee() {
        return super.getFee() * 2 + 15.0;
    }

    @Override
    public String toString() {
        return "Міжнародний переказ: країна = " + countryCode
                + ", сума = " + amount
                + ", комісія = " + getFee()
                + ", разом = " + getTotalWithFee();
    }
}