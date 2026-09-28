package classes_and_objects.assigment_problems;

/**
 * Week 3 - L5 : Counting Objects With a Static Field
 * totalOrders belongs to the class, so every constructor call updates one shared number.
 */
public class StaticOrderCount {

    static class Order {
        static int totalOrders = 0;

        public Order() {
            totalOrders++;
        }
    }

    public static void main(String[] args) {
        new Order();
        new Order();
        new Order();
        new Order();

        System.out.println("Total orders: " + Order.totalOrders);
    }
}
