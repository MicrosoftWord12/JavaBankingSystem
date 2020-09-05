import java.io.*;
import java.util.Scanner;

public class Application {
    Scanner input = new Scanner(System.in);
    FileWriter write = new FileWriter("D:\\JavaBankingSystem\\src\\accountsDB.txt");
    BufferedWriter buffer = new BufferedWriter(write);

    //    Custom Classes
    CreateAccount createAccount = new CreateAccount();

    public Application() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        Application app = new Application();
//        CurrentAccount tomMumford = new CurrentAccount("Thomas", "Mumford", "thm37@aber.ac.uk", 123456789);
        app.run();
    }


    public void run() throws IOException {
        boolean repeatMenu = true;
        while (repeatMenu) {

        System.out.println("Welcome to your Online bank! \nChoose an option: ");
        System.out.println("A: Create Current Account: Setup Current Account");
        System.out.println("B: Create Savings Account: Setup Savings Account");
        System.out.println("C: View Balance: view balance");
        System.out.println("D: Add Funds: add funds");
        System.out.println("E: View account: view account");
        System.out.println("Q: Close program");

            String account = input.nextLine().toUpperCase();
            switch (account) {
                case "A":
                    //do something
                    break;
                case "B":
                    System.out.println("What is your email Address?");
                    createAccount.setEmailAddress(input.nextLine());
                    buffer.newLine();
                    buffer.write("Email is: " + createAccount.getEmailAddress());

                    System.out.println("What is your first name");
                    createAccount.setFirstName(input.nextLine());
                    buffer.newLine();
                    buffer.write("First Name is: " + createAccount.getFirstName());

                    System.out.println("What is your last name");
                    createAccount.setLastName(input.nextLine());
                    buffer.newLine();
                    buffer.write("Last name is: " + createAccount.getLastName());


                    System.out.println("Would you like to add funds?");
                    String choice = input.nextLine().toUpperCase();
                    try {
                        if (choice.equals("YES") || choice.endsWith("S") || choice.equals("Y")) {
                            System.out.println("How much would you like to add?");
                            createAccount.setBalance((int) input.nextFloat());
                            //TODO: This doesnt save for some reason! I will work on a fix.
                            buffer.newLine();
                            buffer.write("Balance is: " + createAccount.getBalance());
                            buffer.close();
                            System.out.println("Account Created");
                        } else {
                            System.out.println("Have a good day");
                            break;
                        }
                    } catch (IOException e) {
                        System.err.println("error" + e);
                    }
                    break;

                case "C":
                    System.out.println("You balance is: " + createAccount.getBalance());
                    break;

                case "D":
                    if (!createAccount.getEmailAddress().equals(createAccount.getEmailAddress()) &&
                            createAccount.getFirstName().equals(createAccount.getFirstName()) &&
                            createAccount.getLastName().equals(createAccount.getLastName())) {
                        System.out.println("Email: " + createAccount.getEmailAddress());
                        System.out.println("First Name: " + createAccount.getFirstName());
                        System.out.println("Last name" + createAccount.getLastName());
                        System.out.println("Balance" + createAccount.getBalance());
                        break;
                    }
                case "Q":
                    repeatMenu = false;
                    break;
            }
        }
    }


}



