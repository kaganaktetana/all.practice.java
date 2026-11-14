
package semester1.practice10;

interface DataExportable {

    String toJson();

    String toCsvRow();
}

class StudentGradeRecord implements DataExportable {
    private final String name;
    private final int group;
    private final double gpa;

    public StudentGradeRecord(String name, int group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    @Override
    public String toJson() {
        return "{\"name\":\"" + name + "\",\"group\":"
                + group + ",\"gpa\":" + gpa + "}";
    }

    @Override
    public String toCsvRow() {
        return name + "," + group + "," + gpa;
    }
}

class WeatherObservation implements DataExportable {
    private final String city;
    private final double tempC;
    private final int humidity;

    public WeatherObservation(String city, double tempC, int humidity) {
        this.city = city;
        this.tempC = tempC;
        this.humidity = humidity;
    }

    @Override
    public String toJson() {
        return "{\"city\":\"" + city + "\",\"tempC\":"
                + tempC + ",\"humidity\":" + humidity + "}";
    }

    @Override
    public String toCsvRow() {
        return city + "," + tempC + "," + humidity;
    }
}

abstract class Task_16 {

    public static void main(String[] args) {

        DataExportable[] records = {
                new StudentGradeRecord("Тетяна", 11, 4.5),
                new StudentGradeRecord("Олексій", 12, 4.8),
                new WeatherObservation("Львів", 12.5, 75),
                new WeatherObservation("Київ", 15.0, 60)
        };

        System.out.println("JSON:");

        System.out.println("[");

        for (int i = 0; i < records.length; i++) {
            System.out.print("  " + records[i].toJson());

            if (i < records.length - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }

        System.out.println("]");

        System.out.println();
        System.out.println("CSV:");

        System.out.println("data");

        for (DataExportable record : records) {
            System.out.println(record.toCsvRow());
        }
    }
}

