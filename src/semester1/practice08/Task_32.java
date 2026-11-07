package semester1.practice08;

public class Task_32 {
    public static void main(String[] args) {

        PrescriptionMedicine medicine =
                new PrescriptionMedicine(
                        "Препарат A", 250, false, "DOC123"
                );

        ControlledSubstance substance =
                new ControlledSubstance(
                        "Препарат B", 500, false,
                        "DOC456", 25
                );

        System.out.println(medicine);
        System.out.println("Продаж із рецептом: "
                + medicine.canSell(true));

        System.out.println();

        System.out.println(substance);

        System.out.println("Продаж із рецептом: "
                + substance.canSell(true));

        System.out.println("Продаж без рецепта: "
                + substance.canSell(false));
    }
}

class Medicine {
    private String name;
    private double price;
    private boolean isExpired;

    public Medicine(String name, double price, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.isExpired = isExpired;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isExpired() {
        return isExpired;
    }

    @Override
    public String toString() {
        return "Препарат: " + name
                + ", ціна: " + price + " грн"
                + ", прострочений: " + (isExpired ? "так" : "ні");
    }
}

class PrescriptionMedicine extends Medicine {
    private String doctorLicense;

    public PrescriptionMedicine(String name, double price,
                                boolean isExpired,
                                String doctorLicense) {
        super(name, price, isExpired);

        this.doctorLicense = doctorLicense;
    }

    public boolean canSell(boolean hasPrescription) {
        return !isExpired() && hasPrescription;
    }

    public String getDoctorLicense() {
        return doctorLicense;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", ліцензія лікаря: " + doctorLicense;
    }
}

class ControlledSubstance extends PrescriptionMedicine {
    private int patientAge;

    public ControlledSubstance(String name, double price,
                               boolean isExpired,
                               String doctorLicense,
                               int patientAge) {
        super(name, price, isExpired, doctorLicense);

        this.patientAge = patientAge;
    }

    @Override
    public boolean canSell(boolean hasPrescription) {
        return super.canSell(hasPrescription)
                && patientAge >= 18;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", вік пацієнта: " + patientAge
                + ", продаж дозволений: "
                + (canSell(true) ? "так" : "ні");
    }
}