
package semester1.practice11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Task_32 {

    public static void main(String[] args) {

        ArrayList<String> logs = new ArrayList<>(
                List.of(
                        "INFO: Start",
                        "DEBUG: Init",
                        "ERROR: Timeout",
                        "DEBUG: Retry",
                        "INFO: Done"
                )
        );

        // Видалення DEBUG через Iterator
        Iterator<String> it = logs.iterator();

        while (it.hasNext()) {

            String log = it.next();

            if (log.startsWith("DEBUG:")) {
                it.remove();
            }
        }

        System.out.println("Після видалення DEBUG: " + logs);

        // Обхід вперед та заміна ERROR
        ListIterator<String> listIt = logs.listIterator();

        while (listIt.hasNext()) {

            String log = listIt.next();

            if (log.startsWith("ERROR:")) {
                listIt.set("CRITICAL ERROR: Timeout");
            }
        }

        System.out.println("Після заміни ERROR: " + logs);

        // Обхід назад
        System.out.println("Обхід назад:");

        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }
    }
}
