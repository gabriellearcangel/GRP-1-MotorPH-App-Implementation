package com.mycompany.employee;

import com.mycompany.employee.Attendance;
import com.mycompany.employee.Employee;
import com.mycompany.employee.Deductions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Payroll {
    private int salaryID;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private double grossPay;
    private double netPay;
    
    public Payroll(int salaryID, LocalDate periodStart, LocalDate periodEnd) {
        this.salaryID = salaryID;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.grossPay = 0;
        this.netPay = 0;
    }
    
    public void calculateGross(double hours, double rate) {
        grossPay = hours * rate;
    }
    
    public void calculateNet(double deductions) {
        netPay = grossPay - deductions;
    }
    
    public String generatePayslip() {
        return "Salary ID: " + salaryID + "\n" + "Gross Pay: " + grossPay + "\n" + "Net Pay: " + netPay;
    }
    
    public static void main(String[] args) {
        // Create employee
        Employee employee1 = new Employee(1, "10001", "Garcia", "Manual III", LocalDate.of(1983, 10, 11), 535.71, "Chief Executive Officer", "Regular");
        
        // Attendance
        Attendance attendance1 = new Attendance(1, LocalDate.now(), LocalTime.of(8, 10), LocalTime.of(17, 0));
        
        // Calculate attendance
        double hoursWorked = attendance1.calculateHoursWorked();
        double hourlyRate = employee1.getHourlyRate();
        
        // Payroll record
        Payroll payroll1 = new Payroll(1, LocalDate.now().minusDays(7), LocalDate.now());
        
        // Gross Pay
        payroll1.calculateGross(hoursWorked, hourlyRate);
        
        // Deductions
        Deductions deduction = new Deductions(1, 500, 200, 300, 150);
        double totalDeductions = deduction.applyDeductions();
        
        // Net Pay
        payroll1.calculateNet(totalDeductions);
        
        // Payslip display
        System.out.println("Employee: " + employee1.getFullName());
        System.out.println("Hours Worked: " + hoursWorked);
        if (attendance1.isLate()) {
            System.out.println("Late Minutes: " + attendance1.getLateMinutes());
        } else {
            System.out.println("On Time");
        }
        System.out.println(payroll1.generatePayslip()); 
    }
}
