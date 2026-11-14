
package semester1.practice10;

abstract class AbstractFinancialInstrument {
    private final String ticker;
    protected int quantity;

    public AbstractFinancialInstrument(String ticker, int quantity) {
        this.ticker = ticker;
        this.quantity = quantity;
    }

    public String getTicker() {
        return ticker;
    }

    public abstract double getMarketValueUah();
}

interface Tradable {
    boolean buy(int qty);

    boolean sell(int qty);
}

interface DividendPaying {
    double calculateAnnualDividend();
}

class TechGrowthStock extends AbstractFinancialInstrument
        implements Tradable {

    private final double price;

    public TechGrowthStock(String ticker, int quantity, double price) {
        super(ticker, quantity);
        this.price = price;
    }

    @Override
    public double getMarketValueUah() {
        return quantity * price;
    }

    @Override
    public boolean buy(int qty) {
        if (qty <= 0) {
            return false;
        }

        quantity += qty;
        return true;
    }

    @Override
    public boolean sell(int qty) {
        if (qty <= 0 || qty > quantity) {
            return false;
        }

        quantity -= qty;
        return true;
    }
}

class BlueChipStock extends AbstractFinancialInstrument
        implements Tradable, DividendPaying {

    private final double price;
    private final double dividendPerShare;

    public BlueChipStock(String ticker, int quantity,
                         double price, double dividendPerShare) {
        super(ticker, quantity);
        this.price = price;
        this.dividendPerShare = dividendPerShare;
    }

    @Override
    public double getMarketValueUah() {
        return quantity * price;
    }

    @Override
    public boolean buy(int qty) {
        if (qty <= 0) {
            return false;
        }

        quantity += qty;
        return true;
    }

    @Override
    public boolean sell(int qty) {
        if (qty <= 0 || qty > quantity) {
            return false;
        }

        quantity -= qty;
        return true;
    }

    @Override
    public double calculateAnnualDividend() {
        return quantity * dividendPerShare;
    }
}

class FixedTermDeposit extends AbstractFinancialInstrument
        implements DividendPaying {

    private final double annualRate;

    public FixedTermDeposit(String ticker, int principal,
                            double annualRate) {
        super(ticker, principal);
        this.annualRate = annualRate;
    }

    @Override
    public double getMarketValueUah() {
        return quantity;
    }

    @Override
    public double calculateAnnualDividend() {
        return quantity * annualRate / 100.0;
    }
}

abstract class Task_19 {

    public static void main(String[] args) {

        TechGrowthStock tech =
                new TechGrowthStock("TECH", 10, 500);

        BlueChipStock blueChip =
                new BlueChipStock("BLUE", 20, 300, 15);

        FixedTermDeposit deposit =
                new FixedTermDeposit("DEPOSIT", 100000, 10);

        AbstractFinancialInstrument[] instruments = {
                tech,
                blueChip,
                deposit
        };

        for (AbstractFinancialInstrument instrument : instruments) {

            System.out.println("Інструмент: " + instrument.getTicker());

            System.out.println("Ринкова вартість: "
                    + instrument.getMarketValueUah() + " грн");

            if (instrument instanceof DividendPaying) {
                DividendPaying dividend = (DividendPaying) instrument;

                System.out.println("Річний дохід: "
                        + dividend.calculateAnnualDividend() + " грн");
            }

            if (instrument instanceof Tradable) {
                System.out.println("Можна торгувати на біржі");
            } else {
                System.out.println("Не торгується на біржі");
            }

            System.out.println();
        }
    }
}
