package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Week 8 - Problem 2 : The Campus Parking Charge Calculator
 * Each vehicle type overrides charge() with its own rule.
 */
abstract class Vehicle {

    protected final int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract String label();

    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int hours) { super(hours); }

    String label() { return "BIKE"; }

    double charge() { return 10.0 * hours; }
}

class Car extends Vehicle {
    Car(int hours) { super(hours); }

    String label() { return "CAR"; }

    double charge() { return 30.0 + 20.0 * (hours - 1); }
}

class Truck extends Vehicle {
    Truck(int hours) { super(hours); }

    String label() { return "TRUCK"; }

    double charge() { return Math.max(100.0, 50.0 * hours); }
}

public class ParkingCharge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            switch (type) {
                case "BIKE": vehicles.add(new Bike(hours)); break;
                case "CAR": vehicles.add(new Car(hours)); break;
                default: vehicles.add(new Truck(hours));
            }
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double fee = v.charge();
            System.out.printf("%s: %.2f%n", v.label(), fee);
            total = total + fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
