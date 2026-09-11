public class Employee1 {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee1(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        Employee1 e1 = new Employee1("Divya", 65000);
        Employee1 e2 = new Employee1("Arjun", 45000);
        Employee1 e3 = new Employee1("Priya", 55000);

        Employee1.printCompanyInfo();
    }
}