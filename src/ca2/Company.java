package ca2;

import java.util.ArrayList;
import java.util.Iterator;

public class Company { // "The Company class stores information about employees. It contains:"

    private String companyName; // "the field companyName for the name of the company"

    ArrayList<Employee> staff = new ArrayList<>(); // "an ArrayList, called staff, to hold a list of employee objects, whose class is described in Question 1 above."

    public Company() { // "Write the default constructor for this class which initialises all fields."
        this.companyName = companyName; // couldn't see any other fields for this one
    }

    public Company(String companyName) { // "Write an overloaded constructor which accepts a name value as a parameter."
        this.companyName = companyName;
    }

// "Complete the implementation by writing the code for the following methods only:"
    public void addNewStaff(Employee newEmployee) { // "adds a new employee to the staff arrayList (the employee is a parameter)."
        staff.add(newEmployee);
    }

    public int getStaffNumber() { // "returns the number of employees currently in the arrayList."
        return staff.size();
    }

    public void listEmployees(int printEmployeesAboveThisValue) { // "uses an iterator object to find in the arrayList all employees above a given employee number value (this value is a parameter for this method) and prints the names of these employees."
        Iterator<Employee> iterateStaff = staff.iterator(); // iterate through employees in the staff list
        while (iterateStaff.hasNext()) { // continue as long as there is another
            Employee EmployeeToIterate = iterateStaff.next();
            if (EmployeeToIterate.getEmpNum() > printEmployeesAboveThisValue) { // if the employee's empNum exceeds the value given...
                System.out.println(EmployeeToIterate.getName()); // print the names and JUST the names as prescribed
            }
        }
    }

