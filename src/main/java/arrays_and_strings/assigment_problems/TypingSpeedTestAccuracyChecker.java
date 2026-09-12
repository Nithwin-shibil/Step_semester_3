package arrays_and_strings.assigment_problems;

/**
 * Week 1 - Problem 2 : The Typing Speed Test Accuracy Checker
 */
public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Invalid Input - both strings must be of equal length");
            return;
        }

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchIndex = -1;

        for (int i = 0; i < totalCharacters; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;      // remember only the FIRST mistake
            }
        }

        double accuracy = (matchedCharacters * 100.0) / totalCharacters;

        String report = "Matched: " + matchedCharacters + "/" + totalCharacters
                + " | Accuracy: " + String.format("%.2f", accuracy) + "%";

        if (firstMismatchIndex == -1) {
            report = report + " | No Mismatches";
        } else {
            report = report + " | First Mismatch at position " + (firstMismatchIndex + 1)
                    + " ('" + original.charAt(firstMismatchIndex) + "' vs '"
                    + typed.charAt(firstMismatchIndex) + "')";
        }

        System.out.println(report);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
