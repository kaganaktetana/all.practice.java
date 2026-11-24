package semester1.practice12;

import java.util.*;

public class Task_28 {

    public static void main(String[] args) {

        Set<FinancialAsset> portfolio = new HashSet<>();

        portfolio.add(new GovernmentBond("UA100", 10000, 4.5));
        portfolio.add(new GovernmentBond("UA200", 15000, 6.0));
        portfolio.add(new TechStock("NVDA", 20000, 12.0));
        portfolio.add(new TechStock("AAPL", 12000, 8.0));

        // Дублікат за тикером NVDA
        boolean added = portfolio.add(
                new TechStock("NVDA", 50000, 15.0)
        );

        System.out.println("=== BANK PORTFOLIO ===");

        System.out.println("Дублікат NVDA додано: " + added);

        System.out.println("Активів у портфелі: "
                + portfolio.size());

        // Видалення активів з дохідністю нижче 5%
        Iterator<FinancialAsset> iterator =
                portfolio.iterator();

        while (iterator.hasNext()) {

            FinancialAsset asset = iterator.next();

            if (asset.annualYieldPercent() < 5.0) {

                System.out.println("Видалено актив: "
                        + asset.getTicker());

                iterator.remove();
            }
        }

        // Обчислення прибутку
        double totalProfit = 0;

        System.out.println("\n=== ACTIVE ASSETS ===");

        for (FinancialAsset asset : portfolio) {

            double profit = asset.calculateAnnualProfit();

            totalProfit += profit;

            System.out.printf(
                    Locale.US,
                    "%s | Дохідність: %.2f%% | Прибуток: %.2f грн%n",
                    asset.getTicker(),
                    asset.annualYieldPercent(),
                    profit
            );
        }

        System.out.printf(
                Locale.US,
                "\nЗагальний річний прибуток: %.2f грн%n",
                totalProfit
        );
    }

    // Абстрактний фінансовий актив
    public static abstract class FinancialAsset {

        private final String ticker;
        protected double investedAmount;

        public FinancialAsset(
                String ticker,
                double investedAmount) {

            this.ticker = ticker;
            this.investedAmount = investedAmount;
        }

        public String getTicker() {
            return ticker;
        }

        public abstract double annualYieldPercent();

        public final double calculateAnnualProfit() {
            return investedAmount
                    * annualYieldPercent() / 100.0;
        }

        @Override
        public final boolean equals(Object obj) {

            if (this == obj) return true;

            if (!(obj instanceof FinancialAsset asset)) {
                return false;
            }

            return Objects.equals(ticker, asset.ticker);
        }

        @Override
        public final int hashCode() {
            return Objects.hash(ticker);
        }
    }

    // Державні облігації
    public static class GovernmentBond extends FinancialAsset {

        private final double yield;

        public GovernmentBond(
                String ticker,
                double investedAmount,
                double yield) {

            super(ticker, investedAmount);
            this.yield = yield;
        }

        @Override
        public double annualYieldPercent() {
            return yield;
        }
    }

    // Технологічні акції
    public static class TechStock extends FinancialAsset {

        private final double yield;

        public TechStock(
                String ticker,
                double investedAmount,
                double yield) {

            super(ticker, investedAmount);
            this.yield = yield;
        }

        @Override
        public double annualYieldPercent() {
            return yield;
        }
    }
}
