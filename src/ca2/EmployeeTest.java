package ca2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class EmployeeTest { // "Write another class, EmployeeTest..."

// Please note: I didn't receive feedback on any previous assignments for this module by the time of submission. I also cannot manage to get in contact with Sam the lecturer via email to ask into things after multiple attempts. I am doing my best but you may see repetitive errors or practices here as a result! Hopefully that's a fair explanation. I would account for feedback if it were possible

// https://github.com/Dyluvian/CA2 ("Include a link to the GitHub repo as a comment above the “main” method.")
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

// "Bonus challenge: Create a HashSet called staffSet that will not allow two employees with the same empNum to be elements"

/*/ I couldn't really come up with a scenario within the brief to demonstrate this in action, but you will hopefully be able to observe it if you edit to forcibly decrement the nextEmpNum somewhere and try adding some overlapping staff. Notionally the hashset begins with all initial employees' empNums and also gathers new empNums upon addition of any new staff. It then checks the new staff member's empNum against existing ones and, whenever a match is found, increments both the new empNum until a free empNum is found - preventing duplication - and the nextEmpNum, to set up the next staff addition. Additionally the empNum of an existing staff member is removed from the hashset if that staff member is also removed. I hope this correctly interprets the situation in mind./*/

        HashSet<Integer> staffSet = new HashSet<>();

        staffSet.add(employee1.getEmpNum()); // add all the starter empNums of employees and manager - continued further down in the add staff section
        staffSet.add(employee2.getEmpNum());
        staffSet.add(employee3.getEmpNum());
        staffSet.add(managerGroup[0].getEmpNum());

        System.out.println("---\nEmployee Administration Software for Business Gnómes Ltd\nManagers: welcome! Gnóme sweet gnóme, once again."); // horrifying welcome message
        while (true) { // have this repeat
            for (Manager managermember : managerGroup) { // to identify a manager
                Scanner menuInput = new Scanner(System.in); // scan for next user input
                if (login == false) { // if not logged in...
                    System.out.println("---\nTo log in and perform operations, please begin by inputting your username.\n---"); // ask username
                    inputUsername = menuInput.nextLine();
                    System.out.print("---\nNow, please input your password.\n---\n"); // then password
                    String inputPassword = menuInput.nextLine();
                    if (!managermember.getUsername().equals(inputUsername) || !managermember.getPassword().equals(inputPassword)) { // if credentials are a mismatch, declare them invalid
                        System.out.print("---\nInvalid credentials.\n");
                    } else if (managermember.getUsername().equals(inputUsername) && managermember.getPassword().equals(inputPassword)) { // if credentials are a match, log the user in
                        login = true; // user now logged in so avoid this step on next cycle
                        System.out.print("---\nValidated!\n");
                    }
                }
                if (login == true) { // if logged in...
                    System.out.print("---\nWelcome, " + inputUsername + ".\nInput 1 to view current staff.\nInput 2 to add new staff.\nInput 3 to remove employees.\nInput 4 to close the software.\n---\n");
                    String inputChoice = menuInput.nextLine(); // input your choice
                    while (inputChoice.matches("1")) { // option to view current staff
                        try {
                            System.out.print("---\nPlease insert an employee number. All employees above that number will be displayed. To view all staff, input 0.\n---\n");
                            int printEmployeesAboveThisValue = menuInput.nextInt(); // choose the preferred employee number
                            System.out.print("---\nEmployees with an employee number above " + printEmployeesAboveThisValue + ":\n---\n");
                            BusinessGnómes.listEmployees(printEmployeesAboveThisValue); // print whichever employees are above said value in the company
                            inputChoice = "0"; // reset your choice
                        } catch (InputMismatchException e) {
                            System.out.print("---\nInvalid input.\n"); // if anything other than an integer was entered, ask again
                            menuInput.next();
                        }
                    }
                    while (inputChoice.matches("2")) { // option to add staff
                        System.out.print("---\nInput the name of the staff member.\n---\n");
                        String newName = menuInput.nextLine(); // input the staff's name
                        Employee newEmployee = new Employee(); // instantiate the new employee object here
                        newEmployee.name = newName; // assign the input to their name
                        while (newEmployee.email == null) { // until a valid email is given, repeat
                            System.out.print("---\nInput the email address of the staff member.\n---\n");
                            String newEmail = menuInput.nextLine(); // input the staff member's email address
                            newEmployee.setEmail(newEmail); // pass the email to the method for validation
                        }
                        while (staffSet.contains(newEmployee.empNum)) { // any time a new employee's empNum overlaps with an empNum in the bonus hashset...
                            newEmployee.empNum++; // ...increase the new employee's empNum to avoid duplication...
                            Employee.nextEmpNum++; // ...and also increase the nextEmpNum with it
                        }
                        staffSet.add(newEmployee.getEmpNum()); // add the new staff member's empNum to the bonus hashset
                        BusinessGnómes.addNewStaff(newEmployee); // when satisfactory, add the staff to the company
                        System.out.print("---\n" + newEmployee.name + " has been added to the staff.\n");
                        inputChoice = "0"; // reset your choice
                    }
                    while (inputChoice.matches("3")) { // option to remove staff ... "Allow the manager to remove employees from the menu"
                        try {
                            System.out.print("---\nPlease indicate the employee number of the staff member to be removed.\n---\n"); // not forcing a valid user response to this one before returning to menu as there may be no staff remaining to remove!
                            int empNumOfStaffToRemove = menuInput.nextInt(); // input the empNum of the staff member to remove
                            BusinessGnómes.removeStaff(empNumOfStaffToRemove); // pass the empNum to the removal method, removing the staff member
                            staffSet.remove(empNumOfStaffToRemove); // remove the employee's empNum from the bonus hashset
                            inputChoice = "0"; // reset your choice
                        } catch (InputMismatchException e) {
                            System.out.print("---\nInvalid input.\n"); // if anything other than an integer was entered, ask again
                            menuInput.next();
                        }
                    }
                    while (inputChoice.matches("4")) { // option to close the software, including dystopian pun
                        System.out.print("---\nClosing the Employee Administration Software. All roads lead to Gnóme. May your road be untroubled, " + inputUsername + "!\n---\n");
                        System.exit(0); // close it out
                    }
                }
            }
        }
    }
}
