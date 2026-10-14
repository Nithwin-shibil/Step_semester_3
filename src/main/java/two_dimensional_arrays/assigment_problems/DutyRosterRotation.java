package two_dimensional_arrays.assigment_problems;

import java.util.Arrays;

/**
 * Week 10 - Problem 8 : Duty Roster Rotation
 * Remove full turns with k % n, then place the name at index i into (i + k) % n.
 * Time: O(n), additional space: O(n). Rotating one place at a time k times
 * costs O(n * k), which is far too slow when k is up to 10^9.
 */
public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int shift = k % n;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
