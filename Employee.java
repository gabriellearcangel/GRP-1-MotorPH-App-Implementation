package com.mycompany.employee;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private LocalDate birthday;
    private double hourlyRate;
    private String position;
    private String status;

    // Constructor
    public Employee(int id, String employeeNumber, String lastName, String firstName, 
                    LocalDate birthday, double hourlyRate, String position, String status) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.hourlyRate = hourlyRate;
        this.position = position;
        this.status = status;
    }

    // Accessor Methods
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getPosition() {
        return position;
    }

    public String getStatus() {
        return status;
    }

    public static void main(String[] args) {
        // Sample data
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "10001", "Garcia", "Manuel III", LocalDate.of(1983, 10, 11), 535.71, "Chief Executive Officer", "Regular"));
        employees.add(new Employee(2, "10002", "Lim", "Antonio", LocalDate.of(1988, 6, 19), 357.14, "Chief Operating Officer", "Regular"));

        // Displaying the header
        System.out.printf("%-15s %-25s %-15s %-15s %-30s %-10s%n", 
                          "Employee #", "Full Name", "Birthday", "Hourly Rate", "Position", "Status");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");

        // Displaying employee details
        for (Employee employee : employees) {
            System.out.printf("%-15s %-25s %-15s %-15.2f %-30s %-10s%n", 
                              employee.getEmployeeNumber(), 
                              employee.getFullName(), 
                              employee.getBirthday(), 
                              employee.getHourlyRate(), 
                              employee.getPosition(), 
                              employee.getStatus());
        }
    }
}
