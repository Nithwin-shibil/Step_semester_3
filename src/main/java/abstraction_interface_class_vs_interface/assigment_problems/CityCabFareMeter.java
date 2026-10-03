package abstraction_interface_class_vs_interface.assigment_problems;

import java.util.Scanner;

/**
 * Week 9 - Problem 4 : City Cab Fare Meter
 * Abstract Cab holds the shared minimum-fare rule; NightService is an optional ability
 * that only sedans and SUVs implement, so a mini night trip is rejected.
 */
abstract class Cab {

    static final double MINIMUM_FARE = 100;

    abstract String label();

    abstract double ratePerKm();

    double fare(double km) {
        return Math.max(MINIMUM_FARE, km * ratePerKm());
    }
}

interface NightService {

    default double nightFare(double dayFare) {
        return dayFare * 1.20;
    }
}

class MiniCab extends Cab {
    String label() { return "MINI"; }

    double ratePerKm() { return 10; }
}

class SedanCab extends Cab implements NightService {
    String label() { return "SEDAN"; }

    double ratePerKm() { return 14; }
}

class SuvCab extends Cab implements NightService {
    String label() { return "SUV"; }

    double ratePerKm() { return 18; }
}

public class CityCabFareMeter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            boolean night = sc.next().equals("NIGHT");
            Cab cab;
            switch (type) {
                case "MINI": cab = new MiniCab(); break;
                case "SEDAN": cab = new SedanCab(); break;
                default: cab = new SuvCab();
            }
            double fare = cab.fare(km);
            if (night) {
                if (!(cab instanceof NightService)) {
                    System.out.println(cab.label() + ": night service not available");
                    continue;
                }
                fare = ((NightService) cab).nightFare(fare);
            }
            System.out.printf("%s: %.2f%n", cab.label(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
