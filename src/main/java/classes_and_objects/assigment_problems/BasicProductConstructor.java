package classes_and_objects.assigment_problems;

/**
 * Week 3 - L4 : Basic Constructor for a Product
 * One constructor sets both fields when the object is created.
 */
public class BasicProductConstructor {

    static class Product {
        String productId;
        String productName;

        public Product(String productId, String productName) {
            this.productId = productId;
            this.productName = productName;
        }
    }

    public static void main(String[] args) {
        Product product = new Product("P-1042", "Wireless Mouse");

        System.out.println(product.productId + " - " + product.productName);
    }
}
