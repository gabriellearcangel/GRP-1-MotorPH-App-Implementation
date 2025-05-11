public class Deductions {

    private int deductionID;
    private double deductSSS;
    private double deductPagibig;
    private double deductPhilhealth;
    private double deductWithholdingTax;

    public Deductions(int deductionID, double sss, double pagibig, double philhealth, double withholdingTax) {
        this.deductionID = deductionID;
        this.deductSSS = sss;
        this.deductPagibig = pagibig;
        this.deductPhilhealth = philhealth;
        this.deductWithholdingTax = withholdingTax;
    }

    public double applyDeductions() {
        return deductSSS + deductPagibig + deductPhilhealth + deductWithholdingTax;
    }

    // Getters and setters (optional)
    public int getDeductionID() {
        return deductionID;
    }

    public void setDeductionID(int deductionID) {
        this.deductionID = deductionID;
    }

    public double getDeductSSS() {
        return deductSSS;
    }

    public void setDeductSSS(double deductSSS) {
        this.deductSSS = deductSSS;
    }

    public double getDeductPagibig() {
        return deductPagibig;
    }

    public void setDeductPagibig(double deductPagibig) {
        this.deductPagibig = deductPagibig;
    }

    public double getDeductPhilhealth() {
        return deductPhilhealth;
    }

    public void setDeductPhilhealth(double deductPhilhealth) {
        this.deductPhilhealth = deductPhilhealth;
    }

    public double getDeductWithholdingTax() {
        return deductWithholdingTax;
    }

    public void setDeductWithholdingTax(double deductWithholdingTax) {
        this.deductWithholdingTax = deductWithholdingTax;
    }

    public static void main(String[] args) {
      // Create employee
      Employee employee1 = new Employee(1, "10001", "Garcia", "Manuel III", LocalDate.of(1983, 10, 11),535.71, "Chief Executive Officer", "Regular");
      
      // Display details
      System.out.println("Employee Name: " + employee1.getFullName());
      
      // Deductions
      int deductionID = 1;
      double sss = 500.00;
      double pagibig = 200.00;
      double philhealth = 300.00;
      double withholdingTax = 150.00;
      
      Deductions deduction = new Deductions(deductionID, sss, pagibig, philhealth, withholdingTax);
      
      double totalDeductions = deduction.applyDeductions();
      
      System.out.println("Total Deductions: " + totalDeductions);
  }  
}
