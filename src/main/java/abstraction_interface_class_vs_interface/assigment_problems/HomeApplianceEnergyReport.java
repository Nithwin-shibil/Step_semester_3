package abstraction_interface_class_vs_interface.assigment_problems;

import java.util.Scanner;

/**
 * Week 9 - Problem 5 : Home Appliance Energy Report
 * Abstract Appliance computes units from its own wattage; SaverMode is an interface only
 * the AC and washer implement, so the report just asks "instanceof SaverMode".
 */
abstract class Appliance {

    static final double COST_PER_UNIT = 8;

    abstract String label();

    abstract double watts();

    double units(double hours) {
        return watts() * hours / 1000;
    }
}

interface SaverMode {

    default double saverUnits(double units) {
        return units * 0.75;
    }
}

class Fridge extends Appliance {
    String label() { return "FRIDGE"; }

    double watts() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    String label() { return "AC"; }

    double watts() { return 1500; }
}

class Television extends Appliance {
    String label() { return "TV"; }

    double watts() { return 100; }
}

class WashingMachine extends Appliance implements SaverMode {
    String label() { return "WASHER"; }

    double watts() { return 500; }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            Appliance a;
            switch (parts[0]) {
                case "FRIDGE": a = new Fridge(); break;
                case "AC": a = new AirConditioner(); break;
                case "TV": a = new Television(); break;
                default: a = new WashingMachine();
            }
            double units = a.units(hours);
            if (saver) {
                if (!(a instanceof SaverMode)) {
                    System.out.println(a.label() + ": saver mode not supported");
                    continue;
                }
                units = ((SaverMode) a).saverUnits(units);
            }
            double cost = units * Appliance.COST_PER_UNIT;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.label(), units, cost);
            total += cost;
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}
