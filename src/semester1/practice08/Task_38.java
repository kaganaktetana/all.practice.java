package semester1.practice08;

public class Task_38 {
    public static void main(String[] args) {

        TeamLead lead = new TeamLead(
                "Олександр",
                50000,
                "Java",
                5
        );

        Developer dev1 = new Developer(
                "Андрій", 30000, "Java"
        );

        Developer dev2 = new Developer(
                "Марія", 35000, "Python"
        );

        Developer dev3 = new Developer(
                "Іван", 32000, "JavaScript"
        );

        lead.addTeamMember(dev1);
        lead.addTeamMember(dev2);
        lead.addTeamMember(dev3);

        System.out.println(lead);
    }
}

class TeamLead extends Developer {
    private Developer[] teamMembers;
    private int memberCount;

    public TeamLead(String name, double salary,
                    String programmingLanguage,
                    int teamCapacity) {
        super(name, salary, programmingLanguage);

        teamMembers = new Developer[teamCapacity];
        memberCount = 0;
    }

    public void addTeamMember(Developer dev) {
        if (dev == null) {
            System.out.println("Помилка: розробник не може бути null");
            return;
        }

        if (memberCount >= teamMembers.length) {
            System.out.println("Команда заповнена!");
            return;
        }

        teamMembers[memberCount] = dev;
        memberCount++;
    }

    public double getTotalTeamBudget() {
        double total = salary;

        for (int i = 0; i < memberCount; i++) {
            total += teamMembers[i].salary;
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("=== КЕРІВНИК КОМАНДИ ===\n");
        result.append(super.toString());

        result.append("\n\nУчасники команди:\n");

        for (int i = 0; i < memberCount; i++) {
            result.append(i + 1)
                    .append(". ")
                    .append(teamMembers[i])
                    .append("\n");
        }

        result.append("\nКількість розробників: ")
                .append(memberCount);

        result.append("\nЗагальний бюджет команди: ")
                .append(getTotalTeamBudget())
                .append(" грн");

        return result.toString();
    }
}