/*Arrays in Memory:
Representation: Arrays are contiguous blocks of memory where each element is stored at a fixed offset from the start of the array. */
/*Advantages:
Constant-Time Access: Arrays provide constant-time access to elements using an index, i.e., O(1) complexity.
Memory Efficiency: Arrays use a fixed amount of memory and are straightforward to implement. */

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);
        // Adding employees
        ems.addEmployee(new Employee(1, "John Doe", "Software Engineer", 70000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Product Manager", 85000));
        ems.addEmployee(new Employee(3, "Alice Johnson", "HR Manager", 65000));
        // Searching for an employee
        Employee employee = ems.searchEmployee(2);
        System.out.println("Search Result: " + (employee != null ? employee : "Employee not found"));

        // Traversing employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Deleting an employee
        ems.deleteEmployee(1);

        // Traversing employees after deletion
        System.out.println("All Employees After Deletion:");
        ems.traverseEmployees();
    }

    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add a new employee
    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            resizeArray();
        }
        employees[size++] = employee;
    }

    // Resize the array when it's full
    private void resizeArray() {
        int newCapacity = employees.length * 2;
        Employee[] newArray = new Employee[newCapacity];
        System.arraycopy(employees, 0, newArray, 0, employees.length);
        employees = newArray;
    }

    // Search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(int employeeId) {
        int indexToDelete = findEmployeeIndex(employeeId);
        if (indexToDelete == -1) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return;
        }
        // Shift elements to the left
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--size] = null; // Clear last element
    }

    // Find the index of an employee by ID
    private int findEmployeeIndex(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return i;
            }
        }
        return -1; // Employee not found
    }
}
// Analysis
/*
 * Time Complexity:
 * Add Operation: O(1) - Adding an employee to the end of the array.
 * Search Operation: O(n) - Searching for an employee requires a linear scan of
 * the array.
 * Traverse Operation: O(n) - Traversing the array involves visiting each
 * element.
 * Delete Operation: O(n) - Finding and shifting elements to remove an employee
 * requires linear time.
 */

/*
 * Limitations of Arrays:
 * Fixed Size: Arrays have a fixed size, which means once created, the size
 * cannot be changed. This can lead to inefficient use of memory or lack of
 * capacity.
 * Expensive Deletions and Insertions: Removing or adding elements requires
 * shifting elements, which can be costly in terms of time complexity.
 */