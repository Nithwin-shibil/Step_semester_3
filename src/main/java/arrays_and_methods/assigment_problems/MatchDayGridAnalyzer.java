package arrays_and_methods.assigment_problems;

/**
 * Week 5 - Problem 4 (Intermediate) : Match Day Grid Analyzer
 * Rows may have different lengths (jagged 2D array), so always use row.length.
 */
public class MatchDayGridAnalyzer {

    // Does ONE job: average of a single match's overs. No classifying happens here.
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < row.length; i++) {
            total = total + row[i];
        }
        return (double) total / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder report = new StringBuilder();

        for (int match = 0; match < runsPerOver.length; match++) {
            double average = rowAverage(runsPerOver[match]);      // helper called once per match

            report.append("Match ").append(match).append(": ");
            report.append(average >= threshold ? "Power Surge" : "Normal");

            if (match < runsPerOver.length - 1) {
                report.append(" | ");
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
    }
}
