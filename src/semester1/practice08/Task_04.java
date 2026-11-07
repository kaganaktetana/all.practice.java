
package semester1.practice08;

public class Task_04 {

    public static void main(String[] args) {

        CardWallet wallet = new CardWallet(
                "1234567812344589",
                "1234",
                12500.00
        );

        System.out.println(wallet);

        boolean changed = wallet.changePin("1234", "5678");

        System.out.println("PIN змінено: " + changed);

        System.out.println(wallet);
    }
}

class CardWallet {

    private String cardNumber;
    private String pinCode;
    private double balance;

    public CardWallet(String cardNumber, String pinCode, double balance) {

        if (cardNumber.matches("\\d{16}")) {
            this.cardNumber = cardNumber;
        } else {
            this.cardNumber = "0000000000000000";
        }

        this.pinCode = pinCode;
        this.balance = Math.max(0, balance);
    }

    public boolean changePin(String oldPin, String newPin) {

        if (pinCode.equals(oldPin) && newPin.matches("\\d{4}")) {
            pinCode = newPin;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {

        String lastFour = cardNumber.substring(12);

        return String.format(
                "CardWallet{card='**** **** **** %s', balance=%.2f UAH}",
                lastFour, balance
        );
    }
}
