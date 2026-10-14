package two_dimensional_arrays.assigment_problems;

/**
 * Week 10 - Problem 6 : Class Attendance Tracker
 * One pass: a running streak grows on every 1 and resets on every 0;
 * the longest value it reaches is the answer.
 * Time: O(n), additional space: O(1). Both results come from a single pass.
 */
public class ClassAttendanceTracker {

    static String attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longest = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;
                longest = Math.max(longest, streak);
            } else {
                streak = 0;
            }
        }
        return "Present: " + present + ", Longest streak: " + longest;
    }

    public static void main(String[] args) {
        System.out.println(attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1}));
        System.out.println(attendanceSummary(new int[]{0, 0, 0}));
    }
}
