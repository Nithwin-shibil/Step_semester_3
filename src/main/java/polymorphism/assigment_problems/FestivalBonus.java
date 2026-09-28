package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Week 8 - Problem 4 : The Festival Bonus Calculator
 * Name and salary are shared in the base class; each type overrides bonus().
 */
abstract class Employee {

    protected final String name;
    protected final double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return name;
    }

    abstract double bonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) { super(name, salary); }

    double bonus() { return salary * 0.10; }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) { super(name, salary); }

    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }

    double bonus() { return 2000; }
}

public class FestivalBonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            switch (type) {
                case "FULLTIME": staff.add(new FullTimeEmployee(name, salary)); break;
                case "PARTTIME": staff.add(new PartTimeEmployee(name, salary)); break;
                default: staff.add(new Intern(name, salary));
            }
        }

        double total = 0;
        for (Employee e : staff) {
            double b = e.bonus();
            System.out.printf("%s: %.2f%n", e.getName(), b);
            total = total + b;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
