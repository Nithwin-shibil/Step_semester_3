package encapsulation_and_access_control.assigment_problems;

/**
 * Week 7 - Problem 5 : The Shopping Cart
 * Prices are stored privately; total and count are computed on request
 * each time rather than kept as a separately-maintained running field.
 */
public class Cart {

    private final double[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount == prices.length) {
            System.out.println("Cart is full - cannot add item");
            return;
        }
        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());          // 500.0
        System.out.println("Item Count: " + cart.getItemCount()); // 3
    }
}
