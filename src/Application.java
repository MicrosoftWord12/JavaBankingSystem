import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private CreateAccount createAcc;
    private final Scanner input;
    private final String firstName;
    private final String lastName;


    public Application() {
        System.out.println("*** Welcome to your Online bank ***");
        input = new Scanner(System.in);
        System.out.println("What is your first name?");
        firstName = input.next();
        System.out.println("What is your last name?");
        lastName = input.next();

        createAcc = new CreateAccount(firstName, lastName);
    }


    private void PrintMenu() {
        System.out.println("\nChoose an option: ");
        System.out.println("A: Create Current Account: Setup Current Account");
        System.out.println("B: Create Savings Account: Setup Savings Account");
        System.out.println("C: View Balance: view balance");
        System.out.println("D: Add Funds: add funds");
        System.out.println("E: View account: view account");
        System.out.println("Q: Close program");
    }

    public void run() throws IOException {
        String choice = "";
        do {
            PrintMenu();
            choice = input.next().toUpperCase();

            switch (choice) {
                case "A":
                    //do something
                    break;
                case "B":
                    System.out.println("What is your email Address?");
                    createAccount.setEmailAddress(input.next());
                    buffer.write(createAccount.getEmailAddress());

                    System.out.println("What is your first name");
                    createAccount.setFirstName(input.next());
                    buffer.newLine();
                    buffer.write(createAccount.getFirstName());

                    System.out.println("What is your last name");
                    createAccount.setLastName(input.next());
                    buffer.newLine();
                    buffer.write(createAccount.getLastName());


                    System.out.println("Would you like to add funds?");

                    String answer = input.next().toUpperCase();

                    if (answer.equals("YES") || answer.endsWith("S") || answer.equals("Y")) {
                        System.out.println("How much would you like to add?");
                        createAccount.setBalance(input.nextDouble());
                        buffer.newLine();
                        buffer.write(createAccount.getBalance());
                        buffer.close();
                        System.out.println("Account Created");
                    } else {
                        System.out.println("Have a good day");
                        break;
                    }
                    break;

                case "C":
                    System.out.println("You balance is: " + createAccount.getBalance());
                    break;

                case "D":
                    System.out.println(createAccount.getEmailAddress());
                    System.out.println(createAccount.getFirstName());
                    System.out.println(createAccount.getLastName());
                    System.out.println(createAccount.getBalance());
                    break;
                case "Q":
                    break;

                default:
                    System.out.println("That is not a choice!");
            }
        } while (!choice.equals("Q"));
    }

    public static void main(String[] args) throws IOException {
        Application app = new Application();
        app.run();
    }

}



