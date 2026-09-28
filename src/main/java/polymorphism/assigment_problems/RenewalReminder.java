package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Week 8 - Problem 5 : The Streaming Plan Renewal Reminder
 * Each plan overrides validityDays(); renewalDate() is shared.
 */
abstract class Plan {

    abstract int validityDays();

    LocalDate renewalDate(LocalDate start) {
        return start.plusDays(validityDays());
    }
}

class BasicPlan extends Plan {
    int validityDays() { return 30; }
}

class StandardPlan extends Plan {
    int validityDays() { return 90; }
}

class PremiumPlan extends Plan {
    int validityDays() { return 365; }
}

class Subscriber {

    private final String name;
    private final Plan plan;
    private final LocalDate startDate;

    Subscriber(String name, Plan plan, LocalDate startDate) {
        this.name = name;
        this.plan = plan;
        this.startDate = startDate;
    }

    String getName() {
        return name;
    }

    LocalDate renewalDate() {
        return plan.renewalDate(startDate);
    }
}

public class RenewalReminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Subscriber> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            Plan plan;
            switch (type) {
                case "BASIC": plan = new BasicPlan(); break;
                case "STANDARD": plan = new StandardPlan(); break;
                default: plan = new PremiumPlan();
            }
            subscribers.add(new Subscriber(name, plan, start));
        }

        for (Subscriber s : subscribers) {
            System.out.println(s.getName() + ": " + s.renewalDate());
        }
    }
}
