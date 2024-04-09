package org.training.java11.security;

import java.util.ArrayList;

final class Department { // cannot subclass this class and all methods are final
    // private final instance variables
    private final String name, address; // String is immutable
    private final int numEmployees;
    private final ArrayList<String> employees; // mutable

    // private constructor - cannot subclass this class because this constructor
    // cannot be invoked from a subclass (hidden)
    private Department(String name, String address, int numEmployees, ArrayList<String> employees){
        this.name = name;
        this.address = address;
        this.numEmployees = numEmployees;
        this.employees = new ArrayList<String>(employees); // create a new ArrayList to prevent modifications
        //this.employees = employees; // breaking encapsulation!
    }

    // factory method to create a Department
    public static Department createNewInstance(String name, String address, int numEmployees,
                                               ArrayList<String> employees){
        return new Department(name, address, numEmployees, employees);
    }

    // no 'set' methods, only 'get' methods
    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public int getNumEmployees(){
        return numEmployees;
    }

    public ArrayList<String> getEmployees(){
        return new ArrayList<String>(employees); // return a new object to prevent modifications
        //return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numEmployees=" + numEmployees +
                ", employees=" + employees +
                '}';
    }
}
public class TestImmutable {

    public static void main(String[] args){
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Ann");
        employees.add("Liam");

        Department dept = Department.createNewInstance("IBM", "Mexico", 100, employees);

        // Created: Department{name='IBM', address='Mexico', numEmployees=100, employees=[Ann, Liam]}
        System.out.println("Created: " + dept);

        String name = dept.getName();
        String address = dept.getAddress();
        int numEmployees = dept.getNumEmployees();
        employees = dept.getEmployees();

        // Retrieved: IBM Mexico 100 [Ann, Liam]
        System.out.println("Retrieved: " + name + " " + address + " " + numEmployees + " " + employees);

        // change what I got back - any effect on the "dept" immutable object?
        name = "Boots"; // Strings are immutable so new objects are created in the background => ok
        address = "Galway";
        numEmployees = 5; // simple primitive i.e. value is just copied back
        employees.add("Luis"); // as we only got a copy of the Array List back; we are changing that copy

        // As we can see the copy of employees has change directly
        // Any change?: Department{name='IBM', address='Mexico', numEmployees=100, employees=[Ann, Liam, Luis]}
        // To prevent this return a new instance of the Array List
        System.out.println("Any change?: " + dept);
    }
}
