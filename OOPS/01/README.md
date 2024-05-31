# Payroll System

This Java application is designed to manage a payroll system. It allows for **adding, removing, updating, and displaying** employees, as well as calculating the total payroll.

## Employee Class (Abstract)
- **Purpose**: Serves as a base class for all types of employees.
- **Attributes**:
  - `name`: Stores the name of the employee.
  - `id`: Stores the unique ID of the employee.
- **Methods**:
  - `getName()`, `setName()`, `getId()`: Getter and setter methods for the attributes.
  - `calculateSalary()`: Abstract method to be implemented by subclasses to calculate the salary of the employee.
  - `toString()`: Returns a string representation of the employee.

## FullTimeEmployee Class (Extends Employee)
- **Purpose**: Represents a full-time employee.
- **Attributes**:
  - `monthlySalary`: Stores the monthly salary of the full-time employee.
- **Methods**:
  - `getMonthlySalary()`, `setMonthlySalary()`: Getter and setter methods for the monthly salary.
  - `calculateSalary()`: Implements the abstract method to return the monthly salary.

## PartTimeEmployee Class (Extends Employee)
- **Purpose**: Represents a part-time employee.
- **Attributes**:
  - `hoursWorked`: Stores the number of hours worked by the part-time employee.
  - `hourlyRate`: Stores the hourly rate of the part-time employee.
- **Methods**:
  - `getHoursWorked()`, `setHoursWorked()`, `getHourlyRate()`, `setHourlyRate()`: Getter and setter methods for hours worked and hourly rate.
  - `calculateSalary()`: Implements the abstract method to return the salary based on hours worked and hourly rate.

## PayrollSystem Class
- **Purpose**: Manages a list of employees and provides functionalities to add, remove, update, display employees, and calculate the total payroll.
- **Attributes**:
  - `employeeList`: Stores a list of employees.
- **Methods**:
  - `addEmployee(Employee employee)`: Adds an employee to the list.
  - `removeEmployee(int id)`: Removes an employee from the list based on their ID.
  - `updateEmployee(int id, String newName, double newSalary, int newHoursWorked, double newHourlyRate)`: Updates an employee's details based on their ID.
  - `displayEmployee()`: Displays all employees.
  - `calculateTotalPayroll()`: Calculates and returns the total payroll by summing the salaries of all employees.

## Main Class
- **Purpose**: Provides a user interface to interact with the payroll system.
- **Methods**:
  - Contains a `main` method that implements a menu-driven interface to:
    - Add employees (either full-time or part-time).
    - Remove employees by ID.
    - Update employee details.
    - Display all employees.
    - Calculate and display the total payroll.
    - Exit the program.

## Example Usage
1. **Add Employee**: Prompts the user to enter details for a full-time or part-time employee and adds them to the payroll system.
2. **Remove Employee**: Prompts the user to enter the ID of the employee to remove.
3. **Update Employee**: Prompts the user to enter the ID of the employee to update along with the new details.
4. **Display Employees**: Displays the details of all employees.
5. **Calculate Total Payroll**: Calculates and displays the total payroll.
6. **Exit**: Exits the application.



_**Hit the Star button**_

