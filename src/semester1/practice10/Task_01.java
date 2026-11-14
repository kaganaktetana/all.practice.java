package  semester1.practice10;

    abstract class PaymentInstrument {
        private final String payerName;

        public PaymentInstrument(String payerName) {
            this.payerName = payerName;
        }

        public String getPayerName() {
            return payerName;
        }

        public abstract double calculateFee(double amount);

        public double processPayment(double amount) {
            return amount + calculateFee(amount);
        }
    }

    class BankCardInstrument extends PaymentInstrument {

        public BankCardInstrument(String payerName) {
            super(payerName);
        }

        @Override
        public double calculateFee(double amount) {
            return amount * 0.015 + 5.0;
        }
    }

    class CryptoTokenInstrument extends PaymentInstrument {
        private final double gasFeeUah;

        public CryptoTokenInstrument(String payerName, double gasFeeUah) {
            super(payerName);
            this.gasFeeUah = gasFeeUah;
        }

        @Override
        public double calculateFee(double amount) {
            return gasFeeUah;
        }
    }

    class IbanDirectInstrument extends PaymentInstrument {

        public IbanDirectInstrument(String payerName) {
            super(payerName);
        }

        @Override
        public double calculateFee(double amount) {
            if (amount <= 50000) {
                return 0.0;
            }
            return amount * 0.005;
        }
    }

    public class Task_01 {

        public static void main(String[] args) {

            PaymentInstrument[] payments = {
                    new BankCardInstrument("Тетяна"),
                    new CryptoTokenInstrument("Олексій", 25.0),
                    new IbanDirectInstrument("Марія")
            };

            double amount = 10000;
            double totalCost = 0;

            for (PaymentInstrument payment : payments) {
                double cost = payment.processPayment(amount);

                System.out.println(
                        payment.getPayerName() + ": " + cost + " грн"
                );

                totalCost += cost;
            }

            System.out.println("Загальні витрати: " + totalCost + " грн");
        }
    }


