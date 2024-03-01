package ca2;

class Employee { // "Write the complete class, Employee, which has the following fields and methods:"

// "Instance fields:"
    String name; // "name, of type String;"
    String email; // "email, of type String;"
    int empNum; // "empNum, of type int"

// "Static field:"
    static int nextEmpNum = 1; // "nextEmpNum, of type int and initialized to 1, which initialises empNum in the constructor. Its value must then be incremented to give consecutive numbers to each newly created object."

// "Two Constructors:"
    public Employee() { // "One constructor initialises the name and email instance fields with default values."
        this.name = name;
        this.email = email;
        empNum = nextEmpNum++; // "...incremented to give consecutive numbers to each newly created object."
    }

    public Employee(String name, String email) { // "The other constructor initialises these fields with values passed as parameters."
        this.name = name;
        this.email = email;
        empNum = nextEmpNum++; // "...incremented to give consecutive numbers to each newly created object."
    }
