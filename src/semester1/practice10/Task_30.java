package semester1.practice10;

abstract class AbstractCustomer {
    protected String name;

    public AbstractCustomer(String name) {
        this.name = name;
    }

    public abstract double getDiscountPercent();
}

class VipCustomer extends AbstractCustomer {

    public VipCustomer(String name) {
        super(name);
    }

    @Override
    public double getDiscountPercent() {
        return 20.0;
    }
}

class StudentCustomer extends AbstractCustomer {

    public StudentCustomer(String name) {
        super(name);
    }

    @Override
    public double getDiscountPercent() {
        return 10.0;
    }
}

class RegularCustomer extends AbstractCustomer {

    public RegularCustomer(String name) {
        super(name);
    }

    @Override
    public double getDiscountPercent() {
        return 0.0;
    }
}

abstract class Task_30 {

    public static double calculateDiscount(
            double price, AbstractCustomer customer) {

        return price * (1.0 - customer.getDiscountPercent() / 100.0);
    }

    public static void main(String[] args) {
        double price = 1000;

        AbstractCustomer[] customers = {
                new VipCustomer("Олег"),
                new StudentCustomer("Марія"),
                new RegularCustomer("Іван")
        };

        for (AbstractCustomer customer : customers) {
            System.out.println(
                    customer.name + ": "
                            + calculateDiscount(price, customer) + " грн"
            );
        }
    }
}