package semester1.practice08;

public class Task_17 {
    public static void main(String[] args) {
        StaffMember staff = new StaffMember("Олена", 20000);

        Manager manager = new Manager(
                "Андрій", 30000, 10000
        );

        SalesPerson salesperson = new SalesPerson(
                "Тетяна", 18000, 50000, 5
        );

        System.out.println(staff);
        System.out.println(manager);
        System.out.println(salesperson);
    }
}

class StaffMember {
    protected String name;
    protected double baseSalary;

    public StaffMember(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateMonthlyPay() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "Працівник: " + name
                + ", базова зарплата: " + baseSalary
                + ", до виплати: " + calculateMonthlyPay();
    }
}

class Manager extends StaffMember {
    private double teamBonus;

    public Manager(String name, double baseSalary, double teamBonus) {
        super(name, baseSalary);

        this.teamBonus = teamBonus;
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + teamBonus;
    }

    @Override
    public String toString() {
        return "Менеджер: " + name
                + ", базова зарплата: " + baseSalary
                + ", бонус команди: " + teamBonus
                + ", до виплати: " + calculateMonthlyPay();
    }
}

class SalesPerson extends StaffMember {
    private double salesVolume;
    private double commissionRate;

    public SalesPerson(String name, double baseSalary,
                       double salesVolume, double commissionRate) {
        super(name, baseSalary);

        this.salesVolume = salesVolume;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay()
                + salesVolume * (commissionRate / 100.0);
    }

    @Override
    public String toString() {
        return "Продавець: " + name
                + ", базова зарплата: " + baseSalary
                + ", обсяг продажів: " + salesVolume
                + ", комісія: " + commissionRate + "%"
                + ", до виплати: " + calculateMonthlyPay();
    }
}