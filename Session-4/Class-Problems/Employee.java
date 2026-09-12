public class Employee {

    String id;
    double salary;

    // Constructor
    public Employee(String id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    // Method using this
    void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printSalary() {
        System.out.println(
            id + " | Final Salary: Rs " + salary
        );
    }

    public static void main(String[] args) {

        Employee[] employees = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        double bonus = 5000;

        for (Employee employee : employees) {
            employee.raiseSalary(bonus);
        }

        for (Employee employee : employees) {
            employee.printSalary();
        }
    }
}