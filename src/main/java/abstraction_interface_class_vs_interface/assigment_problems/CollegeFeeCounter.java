package abstraction_interface_class_vs_interface.assigment_problems;

import java.util.Scanner;

/**
 * Week 9 - Problem 3 : College Fee Counter
 * Abstract student holds name and tuition; the BusUser interface carries the single
 * transport fee, and the fee is added by asking "instanceof BusUser", not by type name.
 */
abstract class CollegeStudent {

    protected final String name;

    CollegeStudent(String name) {
        this.name = name;
    }

    abstract double tuition();

    double extraCharges() {
        return 0;
    }

    double totalFee() {
        double fee = tuition() + extraCharges();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).transportFee();
        }
        return fee;
    }
}

interface BusUser {

    default double transportFee() {
        return 12000;
    }
}

class DayScholar extends CollegeStudent implements BusUser {
    DayScholar(String name) { super(name); }

    double tuition() { return 40000; }
}

class Hosteller extends CollegeStudent {
    Hosteller(String name) { super(name); }

    double tuition() { return 40000; }

    double extraCharges() { return 60000; }
}

class ScholarshipStudent extends CollegeStudent implements BusUser {
    ScholarshipStudent(String name) { super(name); }

    double tuition() { return 40000 / 2; }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            CollegeStudent s;
            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER": s = new Hosteller(name); break;
                default: s = new ScholarshipStudent(name);
            }
            double fee = s.totalFee();
            System.out.printf("%s: %.2f%n", s.name, fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
