package two_dimensional_arrays.assigment_problems;

/**
 * Week 10 - Problem 7 : Second-Best Score
 * Track highest and second in one pass; a score equal to the highest is skipped
 * so only distinct values count.
 * Time: O(n), additional space: O(1). Sorting would cost O(n log n).
 */
public class SecondBestScore {

    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s != highest && s > second) {
                second = s;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));
        System.out.println(secondHighest(new int[]{50, 50, 50}));
    }
}
