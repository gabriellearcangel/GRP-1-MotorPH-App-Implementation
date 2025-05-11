package com.mycompany.employee;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {
    private int attendID;
    private LocalDate date;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private int lateMinutes;
    private LocalTime gracePeriod;
    
    public Attendance(int attendID, LocalDate date, LocalTime timeIn, LocalTime timeOut) {
        this.attendID = attendID;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.lateMinutes = 0;
    }
    
    public double calculateHoursWorked() {
        return timeOut.getHour() - timeIn.getHour() + (timeOut.getMinute() - timeIn.getMinute()) / 60.0;
    }
    
    public boolean isLate() {
        LocalTime gracePeriod = LocalTime.of(8,11);
        
        return timeIn.isAfter(gracePeriod);
    }
    
    public int getLateMinutes() {
        if (isLate()) {
            lateMinutes = (int) java.time.Duration.between(LocalTime.of(8,11), timeIn).toMinutes();
        } else {
        lateMinutes = 0;
    } 
        return lateMinutes;
}
    
    public static void main(String[] args) {
        // Create employee
        Employee employee1 = new Employee(1, "10001", "Garcia", "Manuel III", LocalDate.of(1983,10,11), 535.71, "Chief Executive Officer", "Regular");
      
        // Create attendance record
        Attendance attendance1 = new Attendance(101, LocalDate.now(), LocalTime.of(9, 15), LocalTime.of(17,0));
        
        // Display details
        System.out.println("Name: " + employee1.getFullName());
        
        //Attendance details
        System.out.println("Hours Worked: " + attendance1.calculateHoursWorked());
        
        if (attendance1.isLate()) {
            System.out.println("Late Minutes: " + attendance1.getLateMinutes());
    } else {
            System.out.println("On Time");
        }
    }
}
