package classes_and_objects.assigment_problems;

/**
 * Week 3 - L1 : Simple Book Record Class
 * A class, an object and direct field access - no constructor needed.
 */
public class SimpleBookRecord {

    static class Book {
        String title;
        double price;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.title = "Clean Code";
        book.price = 650.0;

        System.out.println("Title: " + book.title + " | Price: Rs " + book.price);
    }
}
