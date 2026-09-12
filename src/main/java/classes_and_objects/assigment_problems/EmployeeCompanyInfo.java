package classes_and_objects.assigment_problems;

/**
 * Week 6 - M5 : Employee and Company Information Management
 * companyName and employeeCount are static - shared by every Employee object,
 * instead of each object keeping its own copy of the company name.
 */
public class EmployeeCompanyInfo {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;             // increments once per object created
    }

    static void printCompanyInfo() {
        // Deliberately touches ONLY static fields - no instance field is referenced here.
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeCompanyInfo("Ravi", 40000);
        new EmployeeCompanyInfo("Meena", 42000);
        new EmployeeCompanyInfo("Arjun", 38000);

        EmployeeCompanyInfo.printCompanyInfo();   // called through the class name, not an object
    }
}
