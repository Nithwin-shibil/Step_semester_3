package classes_and_objects.assigment_problems;

/**
 * Week 6 - M3 : Employee Profile Creation
 * The intern constructor chains to the permanent-employee constructor via this(...),
 * so the field-assignment logic exists in exactly one place.
 */
public class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);   // chain - reuses the constructor above
        this.isIntern = true;      // then override just this one field
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
