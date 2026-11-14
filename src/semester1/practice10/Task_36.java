package semester1.practice10;

interface PrintableDocument {
    String formatForPrinter();
}

final class FiscalReceipt implements PrintableDocument {
    private final String fiscalNumber;
    private final double totalAmount;
    private final double vatAmount;

    public FiscalReceipt(String fiscalNumber, double totalAmount) {
        this.fiscalNumber = fiscalNumber;
        this.totalAmount = totalAmount;
        this.vatAmount = totalAmount * 0.20;
    }

    @Override
    public String formatForPrinter() {
        return "ФІСКАЛЬНИЙ ЧЕК\n"
                + "Номер: " + fiscalNumber + "\n"
                + "Сума: " + totalAmount + " грн\n"
                + "ПДВ (20%): " + vatAmount + " грн";
    }
}

class WarehouseReport implements PrintableDocument {
    private final String reportName;
    private final int productsCount;

    public WarehouseReport(String reportName, int productsCount) {
        this.reportName = reportName;
        this.productsCount = productsCount;
    }

    @Override
    public String formatForPrinter() {
        return "ЗВІТ СКЛАДУ\n"
                + "Назва: " + reportName + "\n"
                + "Кількість товарів: " + productsCount;
    }
}

abstract class Task_36 {

    public static void main(String[] args) {
        PrintableDocument[] documents = {
                new FiscalReceipt("FR-2026-001", 1200),
                new WarehouseReport("Звіт за листопад", 150),
                new FiscalReceipt("FR-2026-002", 2500)
        };

        for (PrintableDocument document : documents) {
            System.out.println(document.formatForPrinter());
            System.out.println("--------------------");
        }
    }
}