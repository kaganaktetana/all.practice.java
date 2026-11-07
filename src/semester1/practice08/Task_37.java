package semester1.practice08;

public class Task_37 {
    public static void main(String[] args) {

        CinemaHall hall = new CinemaHall(
                "Зал №1", 4, 5, 150
        );

        hall.bookSeat(0, 0);
        hall.bookSeat(0, 1);
        hall.bookSeat(1, 2);

        System.out.println(hall);

        System.out.println("\nVIP ЗАЛ:");

        VipCinemaHall vipHall = new VipCinemaHall(
                "VIP Зал", 4, 5, 250, 50
        );

        vipHall.bookSeat(0, 0);
        vipHall.bookSeat(3, 1);
        vipHall.bookSeat(3, 2);

        System.out.println(vipHall);
    }
}

class CinemaHall {
    private String hallName;
    protected boolean[][] seats;
    protected double baseTicketPrice;

    public CinemaHall(String hallName, int rows,
                      int columns, double baseTicketPrice) {
        this.hallName = hallName;
        this.baseTicketPrice = baseTicketPrice;
        this.seats = new boolean[rows][columns];
    }

    public boolean bookSeat(int row, int col) {
        if (row < 0 || row >= seats.length
                || col < 0 || col >= seats[row].length) {
            return false;
        }

        if (seats[row][col]) {
            return false;
        }

        seats[row][col] = true;
        return true;
    }

    public int getOccupiedCount() {
        int count = 0;

        for (boolean[] row : seats) {
            for (boolean seat : row) {
                if (seat) {
                    count++;
                }
            }
        }

        return count;
    }

    public double calculateRevenue() {
        return getOccupiedCount() * baseTicketPrice;
    }

    public int getLastRowOccupiedCount() {
        int count = 0;

        if (seats.length == 0) {
            return 0;
        }

        for (boolean seat : seats[seats.length - 1]) {
            if (seat) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Кінотеатр: ")
                .append(hallName)
                .append("\n\nСхема залу:\n");

        for (boolean[] row : seats) {
            for (boolean seat : row) {
                result.append(seat ? "[X] " : "[O] ");
            }

            result.append("\n");
        }

        result.append("\nЗайнятих місць: ")
                .append(getOccupiedCount());

        result.append("\nВиручка: ")
                .append(calculateRevenue())
                .append(" грн");

        return result.toString();
    }
}

class VipCinemaHall extends CinemaHall {
    private double complimentaryBarCost;

    public VipCinemaHall(String hallName, int rows,
                         int columns, double baseTicketPrice,
                         double complimentaryBarCost) {
        super(hallName, rows, columns, baseTicketPrice);

        this.complimentaryBarCost = complimentaryBarCost;
    }

    @Override
    public double calculateRevenue() {
        double normalRevenue =
                super.calculateRevenue();

        double lastRowExtra =
                getLastRowOccupiedCount() * complimentaryBarCost;

        return normalRevenue + lastRowExtra;
    }

    @Override
    public String toString() {
        return "VIP КІНОЗАЛ\n"
                + super.toString()
                + "\nДодаткова вартість напоїв за квиток останнього ряду: "
                + complimentaryBarCost + " грн";
    }
}