package arrays.assigment_problems;

import java.util.Arrays;

/**
 * Week 4 - A1 : Product of Array Except Self
 * Two passes, no division anywhere. O(n) time, O(1) extra space besides the output.
 */
public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1 (left to right): answer[i] = product of everything to the LEFT of i.
        int leftRunning = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = leftRunning;
            leftRunning = leftRunning * nums[i];
        }

        // Pass 2 (right to left): multiply in the product of everything to the RIGHT of i.
        int rightRunning = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightRunning;
            rightRunning = rightRunning * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
