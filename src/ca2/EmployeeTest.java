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

// "Write the code to search and display the name of each of the employees in the projectGroup array, who have an employee number above the value stored in a variable called m."
        Random r = new Random();
        int m = r.nextInt(2); // no value has been prescribed for m, thus for these purposes just generate something random to ensure at least one name displays

        for (Employee projectmember : projectGroup) { // "search the name of each of the employees in the projectGroup array..."
            if (projectmember.empNum > m) { // "...who have an employee number above the value stored in a variable called m..."
                System.out.println(projectmember.name); // "...and display"
            }
        }

// "Create a Netbean-console menu system for the manager to log in and view current staff and add new staff. (username – “Gnomeo”; Password – “smurf”)"

/*/ Although not explicitly obligated, I went for a looping menu in which the manager can repeatedly perform all operations in one session. Hopefully nothing breaks or softlocks. /*/

        Manager[] managerGroup = new Manager[1]; // create a group for managers, making this menu system flexible beyond Gnomeo

        managerGroup[0] = new Manager("Waylon Smithers", "ws@gmail.com", "Gnomeo", "smurf"); // create the Gnomeo manager

        Company BusinessGnómes = new Company("Business Gnómes"); // create the Business Gnómes company

        boolean login = false; // boolean for user logged out or user logged in

        String inputUsername = null; // initialise username early for printing

        BusinessGnómes.staff.addAll(Arrays.asList(projectGroup)); // load all previously defined employees into the company array list
        BusinessGnómes.staff.addAll(Arrays.asList(managerGroup)); // load all previously defined managers into the company array list

