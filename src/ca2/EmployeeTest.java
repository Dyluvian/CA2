package ca2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class EmployeeTest { // "Write another class, EmployeeTest..."

// Please note: I didn't receive feedback on any previous assignments for this module by the time of submission. I also cannot manage to get in contact with Sam the lecturer via email to ask into things after multiple attempts. I am doing my best but you may see repetitive errors or practices here as a result! Hopefully that's a fair explanation. I would account for feedback if it were possible

// https://github.com/Dyluvian/CA1 ("Include a link to the GitHub repo as a comment above the “main” method.")
    public static void main(String[] args) { // "...containing the main method, which..."

        Employee employee1 = new Employee("Joe Bloggs", "jb@gmail.com"); // "...creates 3 Employee objects, with the following details..."
        Employee employee2 = new Employee("Ann Banana", "ab@gmail.com");
        Employee employee3 = new Employee("Tom Thumb", "tt@gmail.com");

        Employee[] projectGroup = new Employee[3]; // "...declares an array, called projectGroup, to store these 3 Employee objects..."

        projectGroup[0] = employee1; // "...loads the array with the objects..."
        projectGroup[1] = employee2;
        projectGroup[2] = employee3;

        System.out.println(Employee.nextEmpNum); // "...and prints out the value of variable nextEmpNum to the terminal window." (and JUST the value as prescribed)
