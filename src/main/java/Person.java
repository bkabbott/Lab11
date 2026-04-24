import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * File: Person.java
 * Class: CSCI 1302
 * Author: Brian Abbott
 * Created on: 4/24/26
 * Last modified: 4/24/26
 * Description: Represents a Person with age, name, address, zip code, and salary.
 *              Implements Comparable to sort by salary in descending order.
 */

public class Person implements Comparable<Person>, Serializable {

    private int age;
    private String name;
    private String address;
    private int zipCode;
    private double salary;

    // Default constructor
    public Person() {
        setAge(0);
        setName("");
        setAddress("");
        setZipCode(0);
        setSalary(0.0);
    }

    // Parameterized constructor
    public Person(int age, String name, String address, int zipCode, double salary) {
        setAge(age);
        setName(name);
        setAddress(address);
        setZipCode(zipCode);
        setSalary(salary);
    }

    // Accessors
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public double getSalary() {
        return salary;
    }

    // Mutators
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Sort by salary in descending order
    @Override
    public int compareTo(Person other) {
        return Double.compare(other.salary, this.salary);
    }

    // Format salary with commas, currency symbol, and 2 decimal places
    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return age + " " + name + " " + address + " " + zipCode + " " + currencyFormat.format(salary);
    }
}
