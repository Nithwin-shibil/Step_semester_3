package two_dimensional_arrays.assigment_problems;

/**
 * Week 10 - Problem 10 : Busiest Bus Row
 * Sum each row and keep the best one; updating only on a strictly larger total
 * means ties automatically keep the smaller row index.
 * Time: O(r * c), additional space: O(1).
 */
public class BusiestBusRow {

    static String busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        return "Row " + bestRow + ", Total " + bestTotal;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 0, 1}, {3, 3, 1}, {1, 1, 1}};
        System.out.println(busiestRow(grid));
        int[][] tie = {{1, 2}, {2, 1}, {0, 0}};
        System.out.println(busiestRow(tie));
    }
}
