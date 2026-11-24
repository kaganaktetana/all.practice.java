
package semester1.practice12;

import java.util.*;

public class Task_21 {

    public static void main(String[] args) {

        List<String> commands = new ArrayList<>(
                List.of("START", "LOAD", "ERROR_TEMP", "PROCESS", "STOP"));

        ListIterator<String> lit = commands.listIterator();

        while (lit.hasNext()) {

            String command = lit.next();

            if (command.equals("ERROR_TEMP")) {
                lit.set("RETRY");
            }

            if (command.equals("LOAD")) {
                lit.add("VALIDATE");
            }
        }

        System.out.println("Оновлений список команд:");
        System.out.println(commands);
    }
}
