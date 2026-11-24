
package semester1.practice12;

import java.util.*;

class UserSession {
    private final String token;
    private final int idleMinutes;

    public UserSession(String token, int idleMinutes) {
        this.token = token;
        this.idleMinutes = idleMinutes;
    }

    public int getIdleMinutes() {
        return idleMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSession)) return false;

        UserSession s = (UserSession) o;
        return Objects.equals(token, s.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        return token + " (" + idleMinutes + " хв)";
    }
}

public class Task_19 {

    public static int purgeExpiredSessions(
            Set<UserSession> sessions, int maxIdleMinutes) {

        Iterator<UserSession> it = sessions.iterator();
        int removed = 0;

        while (it.hasNext()) {
            UserSession session = it.next();

            if (session.getIdleMinutes() > maxIdleMinutes) {
                it.remove();
                removed++;
            }
        }

        return removed;
    }

    public static void main(String[] args) {

        Set<UserSession> activeSessions = new HashSet<>();

        activeSessions.add(new UserSession("TOKEN-01", 2));
        activeSessions.add(new UserSession("TOKEN-02", 15));
        activeSessions.add(new UserSession("TOKEN-03", 35));
        activeSessions.add(new UserSession("TOKEN-04", 60));
        activeSessions.add(new UserSession("TOKEN-05", 90));
        activeSessions.add(new UserSession("TOKEN-06", 120));
        activeSessions.add(new UserSession("TOKEN-07", 10));

        System.out.println("Активні сесії:");
        System.out.println(activeSessions);

        int removed = purgeExpiredSessions(activeSessions, 30);

        System.out.println("\nВидалено сесій: " + removed);
        System.out.println("Сесії після очищення:");
        System.out.println(activeSessions);
    }
}
