package arrays.assigment_problems;

import java.util.Arrays;

/**
 * Week 4 - A3 : 3Sum
 * Sort first, then a two-pointer scan for every fixed element. O(n^2) overall.
 */
public class ThreeSum {

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);

        int[][] triplets = new int[16][];     // grows by doubling as results are found
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip a repeated fixed element - it would produce the same triplets again.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Sorted array: once the smallest value is positive, no triplet can reach 0.
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;                   // need a bigger sum
                } else if (sum > 0) {
                    right--;                  // need a smaller sum
                } else {
                    if (count == triplets.length) {
                        triplets = Arrays.copyOf(triplets, triplets.length * 2);
                    }
                    triplets[count] = new int[]{nums[i], nums[left], nums[right]};
                    count++;

                    // Skip duplicates on BOTH sides before moving on.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return Arrays.copyOf(triplets, count);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
        System.out.println(Arrays.deepToString(threeSum(new int[]{0, 0, 0})));
        System.out.println(Arrays.deepToString(threeSum(new int[]{-2, 0, 0, 2, 2})));
    }
}
