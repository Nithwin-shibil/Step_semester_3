package arrays_and_methods.assigment_problems;

/**
 * Week 5 - Problem 2 (Easy) : Duplicate Player Pick Checker
 * Plain nested loops only - no Collections class of any kind.
 */
public class DuplicatePlayerPickChecker {

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length - 1; i++) {
            // Only look at the names AFTER i, so no pair is ever compared twice.
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {   // case-sensitive comparison
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Kohli", "Rohit"}));
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Rohit"}));
    }
}
