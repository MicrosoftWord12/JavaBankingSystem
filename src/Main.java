import DBConnection.DBConnection;

import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

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
        createAcc.getFirstName();
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

    public void run() throws IOException, SQLException {
        String choice;
        do {
            PrintMenu();
            choice = input.next().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("What is your email address?");
                    createAcc.setEmailAddress(input.next());

                    System.out.println("Your balance is £0.00 until funds added");
                    createAcc.setBalance(0.00);

                    long ranNum = (long)(Math.random() + 6 * 58 + 4);
                    createAcc.setAccountNo(ranNum);
                    System.out.println("Your account number is: " + createAcc.getAccountNo());

                    break;
                case "B":


                    break;

                case "C":

                    break;

                case "D":

                    break;

                case "E":
                    System.out.println(createAcc.toString());
                    break;

                case "S":
                    createAcc.save(createAcc.getFirstName(), createAcc.getLastName(), createAcc.getEmailAddress(), createAcc.getAccountNo(), createAcc.getBalance());
                    break;

                case "L":
                    createAcc.load(createAcc.getFirstName(), createAcc.getLastName(), createAcc.getEmailAddress(), createAcc.getAccountNo(), createAcc.getBalance());
                    break;

                case "Q":

                    break;

                default:
                    System.out.println("That is not a choice!");
            }
        } while (!choice.equals("Q"));
    }



}



