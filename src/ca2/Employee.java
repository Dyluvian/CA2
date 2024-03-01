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

// "Methods:"
    public String getName() { // "Accessor method to return name value"
        return this.name;
    }

    public String getEmail() { // "Accessor method to return email value"
        return this.email;
    }

    public int getEmpNum() { // "Accessor method to return empNum value"
        return this.empNum;
    }

    public void setEmail(String newEmail) { // "to set the email field to a new value passed as a parameter."
        if (newEmail.length() <= 3) { // "The value must not be accepted if its length is 3 or less."
            System.out.println("---\nUnfortunately, " + newEmail + " is not an acceptable email address. The address cannot consist of 3 characters or less.");
/*/ ----------------------------------------------------
"Challenge: Implement a check for a valid email address"
This was a real rabbit hole. There are many varied perspectives on email validation. Who to trust?
The regex I opted for below, rightly or wrongly, is the RFC 5322 Official Standard as defined by general consensus here: https://emailregex.com/
I couldn't come up with the headspace to manually review this pattern and painstakingly adapt it to Java syntax myself, so I ran it through this and hoped for the best: https://www.regexplanet.com/advanced/java/index.html
---------------------------------------------------- /*/
        } else if (!newEmail.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) { // Lovecraftian email regex checker
            System.out.println("---\nUnfortunately, " + newEmail + " is not an acceptable email address. The address must be compliant with the RFC 5322 Official Standard.");
        } else {
            this.email = newEmail; // if the input satisfies both checks, set the email
        }
    }

    public int getNextEmpNum() { // "to return the current value of nextEmpNum"
        return this.nextEmpNum;
    }
}

class Manager extends Employee { // "A particular employee has been designated a 'manager'. They are considered as a regular employee for all purposes, except that they also have a “username” and a “password” as fields..."

    private String username;
    private String password;

    public Manager(String name, String email, String username, String password) { // same fields as employee, plus additional manager fields
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getUsername() { // "...with corresponding getters and setters [for username and password]."
        return this.username;
    }

    public String getPassword() { // see above
        return this.password;
    }

    public void setUsername(String newUsername) { // see above
        this.username = newUsername;
    }

    public void setPassword(String newPassword) { // see above
        this.password = newPassword;
    }
}
