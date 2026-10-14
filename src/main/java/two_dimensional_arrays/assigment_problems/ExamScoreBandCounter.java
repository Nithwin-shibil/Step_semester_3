package two_dimensional_arrays.assigment_problems;

/**
 * Week 10 - Problem 4 : Exam Score Band Counter
 * Count = (first index with score > high) - (first index with score >= low).
 * A lower-bound style binary search keeps moving left on a match, so duplicates
 * at the band edges are handled correctly instead of stopping at any one of them.
 * Time: O(n) for a linear scan, O(log n) for this solution; additional space: O(1).
 */
public class ExamScoreBandCounter {

    // first index whose score is >= target (n if none)
    static int firstAtLeast(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (scores[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return firstAtLeast(scores, high + 1) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}
