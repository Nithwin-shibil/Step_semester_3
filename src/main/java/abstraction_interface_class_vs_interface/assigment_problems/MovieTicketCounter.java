package abstraction_interface_class_vs_interface.assigment_problems;

import java.util.Scanner;

/**
 * Week 9 - Problem 1 : Movie Ticket Counter
 * Abstract class: the shared convenience fee and amount rule live once in the base;
 * only the price differs. Being abstract, a plain seatless ticket can never be created.
 */
abstract class Seat {

    static final double CONVENIENCE_FEE = 20;

    abstract String label();

    abstract double price();

    double amount(int count) {
        return count * (price() + CONVENIENCE_FEE);
    }
}

class RegularSeat extends Seat {
    String label() { return "REGULAR"; }

    double price() { return 150; }
}

class PremiumSeat extends Seat {
    String label() { return "PREMIUM"; }

    double price() { return 250; }
}

class ReclinerSeat extends Seat {
    String label() { return "RECLINER"; }

    double price() { return 400; }
}

public class MovieTicketCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Seat seat;
            switch (type) {
                case "REGULAR": seat = new RegularSeat(); break;
                case "PREMIUM": seat = new PremiumSeat(); break;
                default: seat = new ReclinerSeat();
            }
            double amount = seat.amount(count);
            System.out.printf("%s: %.2f%n", seat.label(), amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
