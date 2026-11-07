package semester1.practice08;

public class Task_19 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket("Концерт", 1000);

        StudentTicket studentTicket =
                new StudentTicket("Концерт", 1000, "ST12345");

        VipTicket vipTicket =
                new VipTicket("Концерт", 1000, true, 500);

        System.out.println(ticket);
        System.out.println(studentTicket);
        System.out.println(vipTicket);
    }
}

class Ticket {
    private String eventName;
    private double basePrice;

    public Ticket(String eventName, double basePrice) {
        this.eventName = eventName;
        this.basePrice = basePrice;
    }

    public double getFinalPrice() {
        return basePrice;
    }

    public String getEventName() {
        return eventName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Подія: " + eventName
                + ", базова ціна: " + basePrice + " грн"
                + ", фінальна ціна: " + getFinalPrice() + " грн";
    }
}

class StudentTicket extends Ticket {
    private String studentCardNumber;

    public StudentTicket(String eventName, double basePrice,
                         String studentCardNumber) {
        super(eventName, basePrice);

        this.studentCardNumber = studentCardNumber;
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() * 0.5;
    }

    @Override
    public String toString() {
        return "Студентський квиток: " + super.toString()
                + ", номер студентського: " + studentCardNumber;
    }
}

class VipTicket extends Ticket {
    private boolean includesBackstage;
    private double loungeFee;

    public VipTicket(String eventName, double basePrice,
                     boolean includesBackstage, double loungeFee) {
        super(eventName, basePrice);

        this.includesBackstage = includesBackstage;
        this.loungeFee = loungeFee;
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() + loungeFee;
    }

    @Override
    public String toString() {
        return "VIP-квиток: " + super.toString()
                + ", доступ за лаштунки: "
                + (includesBackstage ? "так" : "ні")
                + ", плата за лаунж: " + loungeFee + " грн";
    }
}