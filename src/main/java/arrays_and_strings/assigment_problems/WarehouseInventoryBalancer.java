package arrays_and_strings.assigment_problems;

/**
 * Week 1 - Problem 4 : The Warehouse Inventory Balancer
 */
public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Invalid Input - both sections must hold the same number of items");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA = totalA + sectionA[i];
            totalB = totalB + sectionB[i];
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Track the highest quantity together with WHERE it was found.
        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestItem = 1;                       // 1-based item number

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItem = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {   // strict > keeps the first (Section A) winner on a tie
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItem = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highestQuantity
                + " (" + highestSection + ", Item " + highestItem + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 45});
    }
}
