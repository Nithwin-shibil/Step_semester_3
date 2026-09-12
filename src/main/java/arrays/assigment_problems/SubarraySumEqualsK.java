package arrays.assigment_problems;

import java.util.HashMap;

/**
 * Week 4 - A4 : Subarray Sum Equals K
 *
 * Why a sliding window does NOT work here: a sliding window relies on the sum growing
 * when you extend right and shrinking when you move left. With negative numbers that
 * guarantee disappears, so there is no safe rule for when to shrink the window.
 *
 * Prefix-sum idea: sum of subarray (i+1 .. j) = prefix[j] - prefix[i].
 * So at index j we need the count of earlier prefixes equal to (currentSum - k).
 */
public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);      // the "empty prefix" - lets a subarray starting at index 0 count

        int currentSum = 0;
        int totalSubarrays = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];

            int needed = currentSum - k;
            if (prefixCounts.containsKey(needed)) {
                totalSubarrays = totalSubarrays + prefixCounts.get(needed);
            }

            prefixCounts.put(currentSum, prefixCounts.getOrDefault(currentSum, 0) + 1);
        }

        return totalSubarrays;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}
