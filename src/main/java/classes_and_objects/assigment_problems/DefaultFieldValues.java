package classes_and_objects.assigment_problems;

/**
 * Week 3 - L3 : Reading Java's Default Field Values
 * Fields are printed straight after creation: null, 0.0 and false.
 */
public class DefaultFieldValues {

    static class Employee {
        String empName;
        double salary;
        boolean permanent;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();

        System.out.println("Name: " + employee.empName);
        System.out.println("Salary: " + employee.salary);
        System.out.println("Permanent: " + employee.permanent);
    }
}
