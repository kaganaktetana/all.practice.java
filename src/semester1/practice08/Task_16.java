package semester1.practice08;

public class Task_16 {
    public static void main(String[] args) {
        Gamer gamer = new Gamer("Shadow", 1500);

        ProEsportsPlayer pro = new ProEsportsPlayer(
                "NAVI_Tanya",
                3000,
                "NAVI",
                15000,
                5
        );

        System.out.println(gamer);
        System.out.println(pro);

        System.out.println("Середній приз за перемогу: "
                + pro.getAveragePrizePerWin() + " USD");
    }
}

class Gamer {
    private String nickname;
    private int hoursPlayed;

    public Gamer(String nickname, int hoursPlayed) {
        this.nickname = nickname;
        this.hoursPlayed = hoursPlayed;
    }

    public String getNickname() {
        return nickname;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    @Override
    public String toString() {
        return "Гравець: " + nickname
                + ", зіграно годин: " + hoursPlayed;
    }
}

class ProEsportsPlayer extends Gamer {
    private String teamName;
    private double prizeMoneyUSD;
    private int tournamentsWon;

    public ProEsportsPlayer(String nickname, int hoursPlayed,
                            String teamName, double prizeMoneyUSD,
                            int tournamentsWon) {
        super(nickname, hoursPlayed);

        this.teamName = teamName;
        this.prizeMoneyUSD = prizeMoneyUSD;
        this.tournamentsWon = tournamentsWon;
    }

    public double getAveragePrizePerWin() {
        if (tournamentsWon == 0) {
            return 0;
        }

        return prizeMoneyUSD / tournamentsWon;
    }

    @Override
    public String toString() {
        return "Кіберспортсмен: " + getNickname()
                + ", зіграно годин: " + getHoursPlayed()
                + ", команда: " + teamName
                + ", призові: " + prizeMoneyUSD + " USD"
                + ", перемог у турнірах: " + tournamentsWon;
    }
}