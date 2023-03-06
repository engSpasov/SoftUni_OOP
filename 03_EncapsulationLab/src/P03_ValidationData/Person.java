package P03_ValidationData;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    private Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }
    public Person(String firstName, String lastName, int age, double salary) {
        this(firstName, lastName, age);
        this.setSalary(salary);
    }
    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    private int getAge() {
        return age;
    }
    private double getSalary() {
        return salary;
    }
    private void setSalary(double salary) {
        if(salary<460.0){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }
    public void setFirstName(String firstName) {
        if(firstName.length()<3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if(lastName.length()<3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }
    public void setAge(int age) {
        if(age<1){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }
    public void increaseSalary(double bonus) {
        double finalBonus;
        if (this.getAge() < 30) {
            finalBonus = bonus / 200;
        } else {
            finalBonus = bonus / 100;
        }
        double newSalary = this.getSalary() * (1 + finalBonus);
        this.setSalary(newSalary);
    }

    @Override
    public String toString() {
        DecimalFormat dm = new DecimalFormat("0.0##");
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(), dm.format(this.getSalary()));
    }
}
