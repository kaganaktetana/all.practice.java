package semester1.practice10;

interface BonusEligible {
    double calculateQuarterBonus();
}

interface MedicalInsured {
    double getInsuranceCoverage();
}

abstract class AbstractWorker {
    protected String name;
    protected double salary;

    public AbstractWorker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class FullTimeDeveloper extends AbstractWorker
        implements BonusEligible, MedicalInsured {

    public FullTimeDeveloper(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateQuarterBonus() {
        return salary * 0.15;
    }

    @Override
    public double getInsuranceCoverage() {
        return 50000;
    }
}

class FopContractor extends AbstractWorker implements BonusEligible {

    public FopContractor(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateQuarterBonus() {
        return salary * 0.05;
    }
}

class InternStudent extends AbstractWorker {

    public InternStudent(String name, double salary) {
        super(name, salary);
    }
}

abstract class Task_27 {

    public static void auditStaff(AbstractWorker[] staff) {
        double totalSalary = 0;
        double totalBonuses = 0;
        int insuredCount = 0;

        for (AbstractWorker worker : staff) {
            totalSalary += worker.salary;

            if (worker instanceof BonusEligible b) {
                totalBonuses += b.calculateQuarterBonus();
            }

            if (worker instanceof MedicalInsured) {
                insuredCount++;
            }
        }

        System.out.println("Базовий фонд оплати праці: " + totalSalary);
        System.out.println("Сума квартальних премій: " + totalBonuses);
        System.out.println("Кількість застрахованих осіб: " + insuredCount);
    }

    public static void main(String[] args) {
        AbstractWorker[] staff = {
                new FullTimeDeveloper("Олег", 40000),
                new FopContractor("Марія", 30000),
                new InternStudent("Іван", 10000)
        };

        auditStaff(staff);
    }
}