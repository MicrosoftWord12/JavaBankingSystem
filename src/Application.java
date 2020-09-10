import java.io.*;
import java.util.Scanner;

public class Application {
    private final AccountInfo createAcc = new AccountInfo();
    private final Scanner input;


    public Application() {
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

    public void run() throws IOException {
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



                    //System.out.println("Would you like to add funds?");

                   //String answer = input.next().toUpperCase();

//                    if (answer.equals("YES") || answer.endsWith("S") || answer.equals("Y")) {
//                        System.out.println("How much would you like to add?");
//                        createAccount.setBalance(input.nextDouble());
//                        buffer.newLine();
//                        buffer.write(createAccount.getBalance());
//                        buffer.close();
//                        System.out.println("Account Created");
//                    } else {
//                        System.out.println("Have a good day");
//                        break;
//                    }
                    break;

                case "C":

                    break;

                case "D":

                    break;

                case "E":
                    System.out.println(createAcc.toString());
                    break;

                case "S":
                    createAcc.save();
                    break;

                case "L":
                    createAcc.load();
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



