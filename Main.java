import java.util.ArrayList;
import java.util.Scanner;

// Abstract Employee class
abstract class Employee {
    private String name;
    private int id;

    // Constructor to initialize name and id
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Overriding toString method to provide employee details
    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

// Fulltime employee class
class Fulltime extends Employee {
    private double monthlySalary;

    public Fulltime(String name, int id, double monthlySalary) {
        super(name, id); // Call to superclass constructor
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// PartTime employee class
class PartTime extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTime(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id); // Call to superclass constructor
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// PayrollSystem class
class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Method to remove an employee by ID
    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
            System.out.println("Employee with ID " + id + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Method to display all employees
    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }
}

// Main class to demonstrate functionality
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Full-time Employee");
            System.out.println("2. Add Part-time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Full-time Employee Name: ");
                    String fullName = scanner.next();
                    System.out.print("Enter Employee ID: ");
                    int fullId = scanner.nextInt();
                    System.out.print("Enter Monthly Salary: ");
                    double salary = scanner.nextDouble();
                    payrollSystem.addEmployee(new Fulltime(fullName, fullId, salary));
                    System.out.println("Full-time Employee added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Part-time Employee Name: ");
                    String partName = scanner.next();
                    System.out.print("Enter Employee ID: ");
                    int partId = scanner.nextInt();
                    System.out.print("Enter Hours Worked: ");
                    int hours = scanner.nextInt();
                    System.out.print("Enter Hourly Rate: ");
                    double rate = scanner.nextDouble();
                    payrollSystem.addEmployee(new PartTime(partName, partId, hours, rate));
                    System.out.println("Part-time Employee added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Remove: ");
                    int removeId = scanner.nextInt();
                    payrollSystem.removeEmployee(removeId);
                    break;

                case 4:
                    System.out.println("Employee Details:");
                    payrollSystem.displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
