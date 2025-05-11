/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorph;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Mark Goyon
 */
public class Attendance {
   
    private int attendanceID;
    private String employeeNumber;
    private LocalDate date;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private int lateMinutes; // Changed to private, calculated in isLate()

    // Constructor
    public Attendance(int attendanceID, String employeeNumber, LocalDate date, LocalTime timeIn, LocalTime timeOut) {
        this.attendanceID = attendanceID;
        this.employeeNumber = employeeNumber;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.lateMinutes = calculateLateMinutes(); // Calculate late minutes in constructor
    }

    // Default constructor
    public Attendance() {
    }

    //Getters and Setters
    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
        this.lateMinutes = calculateLateMinutes(); // Recalculate when timeIn changes
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    // Method to calculate hours worked
    public double calculateHoursWorked() {
        if (timeIn != null && timeOut != null) {
            Duration duration = Duration.between(timeIn, timeOut);
            return duration.toMinutes() / 60.0; // Convert minutes to hours
        } else {
            return 0.0; // Or throw an exception, depending on your needs
        }
    }

    // Method to check if the employee is late
    public boolean isLate() {
        return this.lateMinutes > 0;
    }

    // Method to calculate late minutes
    private int calculateLateMinutes() {
        LocalTime officeStartTime = LocalTime.of(8, 0); // Example: Office start time is 8:00 AM
        if (timeIn != null && timeIn.isAfter(officeStartTime)) {
            Duration duration = Duration.between(officeStartTime, timeIn);
            return (int) duration.toMinutes();
        } else {
            return 0;
        }
    }
    //Getter for late minutes
    public int getLateMinutes() {
        return lateMinutes;
    }

     public void setLateMinutes(int lateMinutes) {
        this.lateMinutes = lateMinutes;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceID=" + attendanceID +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", date=" + date +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                ", lateMinutes=" + lateMinutes +
                '}';
    }
}


