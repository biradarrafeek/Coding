
import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id 
                + ", Salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

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
        }
    }

    public void updateEmployee(int id, String newName, double newSalary, int newHoursWorked, double newHourlyRate) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employee.setName(newName);
                if (employee instanceof FullTimeEmployee) {
                    ((FullTimeEmployee) employee).setMonthlySalary(newSalary);
                } else if (employee instanceof PartTimeEmployee) {
                    ((PartTimeEmployee) employee).setHoursWorked(newHoursWorked);
                    ((PartTimeEmployee) employee).setHourlyRate(newHourlyRate);
                }
                break;
            }
        }
    }

    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public double calculateTotalPayroll() {
        double totalPayroll = 0;
        for (Employee employee : employeeList) {
            totalPayroll += employee.calculateSalary();
        }
        return totalPayroll;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        while (true) {
            System.out.println("Payroll System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Calculate Total Payroll");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Type (1 for Full-Time, 2 for Part-Time): ");
                    int type = scanner.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    if (type == 1) {
                        System.out.print("Enter Monthly Salary: ");
                        double monthlySalary = scanner.nextDouble();
                        FullTimeEmployee ftEmployee = new FullTimeEmployee(name, id, monthlySalary);
                        payrollSystem.addEmployee(ftEmployee);
                    } else if (type == 2) {
                        System.out.print("Enter Hours Worked: ");
                        int hoursWorked = scanner.nextInt();
                        System.out.print("Enter Hourly Rate: ");
                        double hourlyRate = scanner.nextDouble();
                        PartTimeEmployee ptEmployee = new PartTimeEmployee(name, id, hoursWorked, hourlyRate);
                        payrollSystem.addEmployee(ptEmployee);
                    }
                    break;
                case 2:
                    System.out.print("Enter Employee ID to Remove: ");
                    int removeId = scanner.nextInt();
                    payrollSystem.removeEmployee(removeId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.next();
                    System.out.print("Enter New Monthly Salary (0 if Part-Time): ");
                    double newSalary = scanner.nextDouble();
                    System.out.print("Enter New Hours Worked (0 if Full-Time): ");
                    int newHoursWorked = scanner.nextInt();
                    System.out.print("Enter New Hourly Rate (0 if Full-Time): ");
                    double newHourlyRate = scanner.nextDouble();
                    payrollSystem.updateEmployee(updateId, newName, newSalary, newHoursWorked, newHourlyRate);
                    break;
                case 4:
                    System.out.println("Employee Details:");
                    payrollSystem.displayEmployee();
                    break;
                case 5:
                    double totalPayroll = payrollSystem.calculateTotalPayroll();
                    System.out.println("Total Payroll: " + totalPayroll);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
