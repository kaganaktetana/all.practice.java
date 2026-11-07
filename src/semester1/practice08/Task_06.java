package semester1.practice08;

public class Task_06 {
    public static void main(String[] args) {
        double[] temperatures = {12.5, 15.0, 18.3, 20.1, 16.7};

        WeatherDay day = new WeatherDay("07.11.2026", temperatures);

        // Змінюємо початковий масив
        temperatures[0] = 100;

        // Дані всередині WeatherDay не зміняться
        System.out.println(day);

        System.out.println("Мінімальна температура: " + day.getMinTemp());
        System.out.println("Максимальна температура: " + day.getMaxTemp());
        System.out.println("Середня температура: " + day.getAverageTemp());
    }
}

class WeatherDay {
    private String date;
    private double[] hourlyTemps;

    public WeatherDay(String date, double[] hourlyTemps) {
        if (hourlyTemps == null || hourlyTemps.length == 0) {
            throw new IllegalArgumentException("Масив температур не може бути порожнім");
        }

        this.date = date;

        // Створюємо копію масиву
        this.hourlyTemps = new double[hourlyTemps.length];

        for (int i = 0; i < hourlyTemps.length; i++) {
            this.hourlyTemps[i] = hourlyTemps[i];
        }
    }

    public double getMinTemp() {
        double min = hourlyTemps[0];

        for (double temp : hourlyTemps) {
            if (temp < min) {
                min = temp;
            }
        }

        return min;
    }

    public double getMaxTemp() {
        double max = hourlyTemps[0];

        for (double temp : hourlyTemps) {
            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }

    public double getAverageTemp() {
        double sum = 0;

        for (double temp : hourlyTemps) {
            sum += temp;
        }

        return sum / hourlyTemps.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Дата: ").append(date);
        result.append(", температури: [");

        for (int i = 0; i < hourlyTemps.length; i++) {
            result.append(hourlyTemps[i]);

            if (i < hourlyTemps.length - 1) {
                result.append(", ");
            }
        }

        result.append("], середня температура: ");
        result.append(getAverageTemp());

        return result.toString();
    }
}