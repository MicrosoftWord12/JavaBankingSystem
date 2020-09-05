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
    private boolean choice;

    public static void main(String[] args) throws IOException {
        Application app = new Application();
//        CurrentAccount tomMumford = new CurrentAccount("Thomas", "Mumford", "thm37@aber.ac.uk", 123456789);
        app.run();
    }



    public void run() throws IOException {
        System.out.println("Welcome to your Online bank");
        System.out.println("Create Current Account: Setup Current Account");
        System.out.println("Create Savings Account: Setup Savings Account");
        System.out.println("View Balance: view balance");
        System.out.println("Add Funds: add funds");
        System.out.println("View account: view account");

        String account = input.nextLine();
        switch (account){
            case "setup current account":

            case "setup savings account":
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
                String choice = input.nextLine();
                if (choice.equals("yes")){
                    System.out.println("How much would you like to add?");
                    createAccount.setBalance(input.nextInt());
                    buffer.newLine();
                    buffer.write("Balance is: " + createAccount.getBalance());
                    buffer.close();

                }else{
                    System.out.println("Have a good day");
                }


                System.out.println("Account Created");
                break;

            case "view balance":
                System.out.println("You balance is: " + createAccount.getBalance());
                break;

            case "view account":
                if (!createAccount.getEmailAddress().equals(createAccount.getEmailAddress()) && createAccount.getFirstName().equals(createAccount.getFirstName()) && createAccount.getLastName().equals(createAccount.getLastName())){
                    System.out.println("Email: " + createAccount.getEmailAddress());
                    System.out.println("First Name: " + createAccount.getFirstName());
                    System.out.println("Last name" + createAccount.getLastName());
                    System.out.println("Balance" + createAccount.getBalance());

                }
        }
        }


    }



