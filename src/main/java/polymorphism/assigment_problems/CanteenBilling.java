package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Week 8 - Problem 1 : The Canteen Billing Counter
 * Each customer type overrides finalAmount() with its own pricing rule.
 */
abstract class Customer {

    protected final double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract String label();

    abstract double finalAmount();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) { super(amount); }

    String label() { return "STUDENT"; }

    double finalAmount() { return amount * 0.90; }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) { super(amount); }

    String label() { return "STAFF"; }

    double finalAmount() { return amount * 0.95; }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) { super(amount); }

    String label() { return "GUEST"; }

    double finalAmount() { return amount + 10; }
}

public class CanteenBilling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            switch (type) {
                case "STUDENT": bills.add(new StudentCustomer(amount)); break;
                case "STAFF": bills.add(new StaffCustomer(amount)); break;
                default: bills.add(new GuestCustomer(amount));
            }
        }

        double total = 0;
        for (Customer c : bills) {
            double fee = c.finalAmount();
            System.out.printf("%s: %.2f%n", c.label(), fee);
            total = total + fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
