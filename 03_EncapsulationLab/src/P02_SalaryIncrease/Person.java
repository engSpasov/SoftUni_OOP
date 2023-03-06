package P02_SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
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
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        double finalBonus;
        if (this.getAge() < 30) {
            finalBonus = bonus / 200;
        } else {
            finalBonus = bonus / 100;
        }
        double newSalary = this.getSalary() * (1 + finalBonus);
        setSalary(newSalary);
    }

    @Override
    public String toString() {
        DecimalFormat dm = new DecimalFormat("0.0##");
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(), dm.format(this.getSalary()));
    }
}
