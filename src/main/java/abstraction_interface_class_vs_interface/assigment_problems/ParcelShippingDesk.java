package abstraction_interface_class_vs_interface.assigment_problems;

import java.util.Scanner;

/**
 * Week 9 - Problem 2 : Parcel Shipping Desk
 * Abstract class for what every parcel does (charge); interface for the ability only some
 * parcels have (insurance), so non-insured types stay untouched.
 */
abstract class Parcel {

    protected final double weightKg;
    protected final double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract String label();

    abstract double charge();
}

interface Insurable {

    double INSURANCE_RATE = 0.02;

    double declaredValue();

    default double insurance() {
        return declaredValue() * INSURANCE_RATE;
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super(w, v); }

    String label() { return "STANDARD"; }

    double charge() { return 40 + 10 * weightKg; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super(w, v); }

    String label() { return "EXPRESS"; }

    double charge() { return 80 + 15 * weightKg; }

    public double declaredValue() { return declaredValue; }
}

class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double w, double v) { super(w, v); }

    String label() { return "FRAGILE"; }

    double charge() { return super.charge() + 50; }

    public double declaredValue() { return declaredValue; }
}

public class ParcelShippingDesk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            Parcel p;
            switch (type) {
                case "STANDARD": p = new StandardParcel(w, v); break;
                case "EXPRESS": p = new ExpressParcel(w, v); break;
                default: p = new FragileParcel(w, v);
            }
            double charge = p.charge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).insurance() : 0;
            double total = charge + insurance;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.label(), charge, insurance, total);
            grand += total;
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}
