package test.Oppgave3;

import java.util.Arrays;
import java.util.Date;

public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private double monthlySalary;
    private Date startDate;
    private Date endDate;

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        if (checkString(firstName.toLowerCase())) {
            this.firstName = firstName; 
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        if (checkString(lastName.toLowerCase())) {
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return the monthlySalary
     */
    public double getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * @param monthlySalary the monthlySalary to set
     */
    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        } else {
            throw new IllegalArgumentException();
        }
        
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {

        if (endDate.after(this.startDate)) {
            this.endDate = endDate;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkString(String string) {
        String[] s = string.split("");
        System.out.println(Arrays.toString(s));
        return Arrays.stream(s).allMatch(c -> "qwertyuiopåasdfghjkløæzxcvbnm".contains(c));
    }

    public double getAnnualSalary() {
        return this.getMonthlySalary()*12;
    }

    public void raiseSalary(int percent) {
        if (percent > 0) {
            this.monthlySalary = this.monthlySalary + this.monthlySalary*percent/100;
        }
    }

    public void terminateEmployment() {
        this.setEndDate(new Date());        
        this.monthlySalary = 0;
        this.id = "";
        
    }
    //bare tester litt:
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setFirstName("Vegard");
        System.out.println(emp.getFirstName());
        emp.setStartDate(new Date());
        emp.setMonthlySalary(1);
        System.out.println(emp.getAnnualSalary());
        emp.raiseSalary(2);
        System.out.println(emp.getMonthlySalary());
        emp.terminateEmployment();
        System.out.println(emp.getEndDate());
        
    }







}