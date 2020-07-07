package com.company;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    public Email() {

        // Call a method asking for firstName - return firstName
        this.firstName = setFirstName();

        // Call a method asking for lastName - return lastName
        this.lastName = setLastName();

        // Call a method asking for department - return the department
        this.department = setDepartment();

        // Call a method asking for alternate email - return the alternate email
        this.alternateEmail = setAlternateEmail();

        // Call a method that returns a random password
        this.password = generateRandomPassword(defaultPasswordLength);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    // Ask for firstName, lastName, department, alternate email

    private String setFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name:");
        firstName = scanner.nextLine();
        while(!firstName.matches("[a-zA-Z]+")) {
            System.out.println("Please re-enter first name:");
            firstName = scanner.nextLine();
        }
        return firstName;
    }

    private String setLastName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter last name:");
        lastName = scanner.nextLine();
        while(!lastName.matches("[a-zA-Z]+")) {
            System.out.println("Please re-enter last name:");
            lastName = scanner.nextLine();
        }

        return lastName;
    }

    private String setDepartment() {
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();
        if(departmentChoice == 1) {
            return "sales";
        } else if(departmentChoice == 2) {
            return "dev";
        } else if(departmentChoice == 3) {
            return "acct";
        } else {
            return "";
        }

    }

    public String setAlternateEmail() {
        System.out.println("Enter alternate email:");
        Scanner scanner = new Scanner(System.in);
        alternateEmail = scanner.nextLine();
        return alternateEmail;
    }

    // Generate a random password
    private String generateRandomPassword (int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!$%&?";
        char[] password = new char[length];
        for(int i = 0; i<length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }


    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "\nNew account created successfully!\n" +
                "\nEMPLOYEE NAME: " + firstName + " " + lastName +
                "\nEmail: " + email +
                "\nPassword: " + password +
                "\nMailbox capacity: " + mailboxCapacity + "mb" +
                "\nAlternate email: " + alternateEmail;
    }
}
