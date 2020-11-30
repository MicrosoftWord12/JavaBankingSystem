import DBConnection.DBConnection;

import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.lang.*;

public class Main {

//     Variables/Consts
    private final AccountInfo createAcc = new AccountInfo();
    private final Scanner input;

//    Custom Classes
    DBConnection db = new DBConnection();


    public static void main(String[] args) throws IOException, SQLException {
        Main app = new Main();
        app.run();
    }


    public Main() throws SQLException {
        db.dbConnection();
        System.out.println("*** Welcome to your Online bank ***");
        input = new Scanner(System.in);
        System.out.println("What is your first name?");
        createAcc.setFirstName(input.next());
        System.out.println("What is your last name?");
        createAcc.setLastName(input.next());
    }


    private void PrintMenu() {
        System.out.println("\nChoose an option: ");
        System.out.println("A: Create Current Account");
        System.out.println("B: Create Savings Account");
        System.out.println("C: View Balance");
        System.out.println("D: Add Funds");
        System.out.println("E: View account");
        System.out.println("S: Save account");
        System.out.println("L: Load account");
        System.out.println("Q: Close program");
    }

    public void run() throws SQLException {
        String choice;
        do {
            PrintMenu();
            choice = input.next().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("What is your email address? ");
                    createAcc.setEmailAddress(input.next());

                    System.out.println("Your balance is £0.00 until funds added");
                    createAcc.setBalance(0.00);

                    long ranNum = (long)(Math.random() + 6 * 58 + 4 - 16);
                    createAcc.setAccountNo(ranNum);
                    System.out.println("Your account number is: " + createAcc.getAccountNo());

                    break;
                case "B":
                    System.out.println("What is your email address? ");
                    

                    break;

                case "C":
                    System.out.println("What is your Email?");
                    String viewBalEmail = input.next();

                    System.out.println("What is your Account Number");
                    long viewBalAccountNum = input.nextLong();
                    createAcc.viewBalance(viewBalEmail, viewBalAccountNum);


                    break;

                case "D":
                    System.out.println("What is your Account Number? ");
                    long addFundsAccountNum = input.nextLong();
                    System.out.println("How much would you like to add? ");
                    double addFundsamount = input.nextDouble();
                    createAcc.addFunds(addFundsAccountNum, addFundsamount);
                    break;

                case "E":
                    System.out.println("What is your email? ");
                    String viewEmail = input.next();
                    System.out.println("What is your account Number? ");
                    long viewAccountNo = input.nextLong();
                    createAcc.viewAccount(viewEmail, viewAccountNo);
                    break;

                case "S":
                    System.out.println("First name is? ");
                    String firstName = input.next();
                    System.out.println("Last name is? ");
                    String lastName = input.next();
                    System.out.println("Email is? ");
                    String saveEmail = input.next();
                    long randNum = (long)(Math.random() + 3 * 58 + 4);
                    double bankStarterMoney = 500;
                    createAcc.save(firstName, lastName, saveEmail, randNum, bankStarterMoney);
                    break;

                case "L":
                    System.out.println("What is your First Name ");
                    String fName = input.next();
                    System.out.println("What is your Last Name ");
                    String lName = input.next();
                    System.out.println("What is your Email ");
                    String email = input.next();
                    System.out.println("What is your Account Number ");
                    long accountNo = input.nextLong();
                    createAcc.load(fName, lName, email, accountNo);
                    break;

                case "Q":

                    break;

                default:
                    System.out.println("That is not a choice!");
            }
        } while (!choice.equals("Q"));
    }



}



