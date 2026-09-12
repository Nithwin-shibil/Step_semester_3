package arrays_and_strings.assigment_problems;

/**
 * Week 1 - Problem 3 : The Traffic Signal Streak Analyzer
 */
public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Empty log - nothing to analyse");
            return;
        }

        char currentColour = signalLog.charAt(0);
        int currentLength = 1;

        char bestColour = currentColour;   // running maximum
        int bestLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColour) {
                currentLength++;                       // streak continues
            } else {
                currentColour = signalLog.charAt(i);   // streak breaks, start a new one
                currentLength = 1;
            }

            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestColour = currentColour;
            }
        }

        System.out.println("Longest Streak: '" + bestColour + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
