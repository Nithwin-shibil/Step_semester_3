package arrays.assigment_problems;

/**
 * Week 4 - A2 : Maximum Subarray (Kadane's algorithm)
 * O(n) time, O(1) space.
 */
public class MaximumSubarray {

    static int maxSubArray(int[] nums) {
        int currentSum = nums[0];   // best sum of a subarray ENDING at the current index
        int bestSum = nums[0];      // best sum seen anywhere so far

        for (int i = 1; i < nums.length; i++) {
            // Extend the running subarray, or abandon it and restart at nums[i] - whichever is bigger.
            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];
            } else {
                currentSum = nums[i];
            }

            if (currentSum > bestSum) {
                bestSum = currentSum;
            }
        }

        return bestSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-3, -1, -2}));
    }
}
