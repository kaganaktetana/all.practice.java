
package semester1.practice12;

import java.util.*;

public class Task_33 {

    // Спільні друзі
    public static Set<String> mutualFriends(
            Set<String> u1, Set<String> u2) {

        Set<String> result = new HashSet<>(u1);
        result.retainAll(u2);

        return result;
    }

    // Рекомендації друзів
    public static Set<String> suggestedFriends(
            String user,
            Set<String> myFriends,
            Set<String> friendOfFriendSet) {

        Set<String> result = new HashSet<>(friendOfFriendSet);

        result.removeAll(myFriends);
        result.remove(user);

        return result;
    }

    // Кількість унікальних користувачів
    public static int uniqueNetworkSize(
            List<Set<String>> allGroups) {

        Set<String> allUsers = new HashSet<>();

        for (Set<String> group : allGroups) {
            allUsers.addAll(group);
        }

        return allUsers.size();
    }

    public static void main(String[] args) {

        Set<String> alex = new HashSet<>(
                Arrays.asList("Maria", "Bohdan", "Ivan"));

        Set<String> maria = new HashSet<>(
                Arrays.asList("Alex", "Bohdan", "Olena"));

        Set<String> bohdan = new HashSet<>(
                Arrays.asList("Alex", "Maria", "Olena"));

        Set<String> olena = new HashSet<>(
                Arrays.asList("Maria", "Bohdan", "Ivan"));

        System.out.println("=== СОЦІАЛЬНА МЕРЕЖА ===");

        System.out.println("Друзі Alex: " + alex);
        System.out.println("Друзі Maria: " + maria);

        System.out.println("\nСпільні друзі Alex і Maria:");
        System.out.println(mutualFriends(alex, maria));

        Set<String> friendsOfFriends = new HashSet<>();
        friendsOfFriends.addAll(maria);
        friendsOfFriends.addAll(bohdan);

        System.out.println("\nМожливо, ви знаєте (Alex):");

        Set<String> suggestions = suggestedFriends(
                "Alex", alex, friendsOfFriends);

        System.out.println(suggestions);

        List<Set<String>> groups = Arrays.asList(
                alex, maria, bohdan, olena);

        System.out.println("\nУнікальних користувачів мережі: "
                + uniqueNetworkSize(groups));
    }
}
