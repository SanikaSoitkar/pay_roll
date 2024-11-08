import java.util.ArrayList;

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

        return "Employee[name=" + name + ",  id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

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

class PayrollSystem {
    private ArrayList<Employee> employeeList; //daynamiclist when it comes to full that time it create new arrya list

    public PayrollSystem() {
        employeeList = new ArrayList<>(); //arrya list
    }

    public void addEmployee(Employee employee) { //add methode is use it is already contain in the arrya list
        employeeList.add(employee);
    }

    public void removeEmployee(int id) { //it is find out where employee is here.
        Employee employeeToRemove = null; //variable it assign null value
        for (Employee employee : employeeList) {  //
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Fulltime emp1 = new Fulltime("Vikas", 1, 50000);
        PartTime emp2 = new PartTime("Rahul", 3, 5, 100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Employee Details:");
        payrollSystem.displayEmployees();

        payrollSystem.removeEmployee(1);

        System.out.println("Employee Details after removal:");
        payrollSystem.displayEmployees();
    }
}
