package arrays.assigment_problems;

/**
 * Week 4 - A5 : Find Minimum in Rotated Sorted Array
 * Modified binary search - O(log n), never a linear scan.
 */
public class FindMinimumInRotatedSortedArray {

    static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // mid sits in the bigger "left" block, so the minimum is strictly to its right.
                low = mid + 1;
            } else {
                // nums[mid] < nums[high]: mid could itself be the minimum, so keep it.
                high = mid;
            }
        }

        return nums[low];       // low == high, and that position holds the minimum
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
    }
}
