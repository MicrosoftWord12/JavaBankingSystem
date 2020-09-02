import java.util.Scanner;

public class Application {
    Scanner input = new Scanner(System.in);

//    Custom Classes
    CreateAccount createAccount = new CreateAccount();

    public static void main(String[] args) {
        Application app = new Application();
//        CurrentAccount tomMumford = new CurrentAccount("Thomas", "Mumford", "thm37@aber.ac.uk", 123456789);
        app.run();

        //add code to run
//        System.out.println(tomMumford.toString());
    }

    public void run(){
        System.out.println("Welcome to your Online bank");
        System.out.println("Create Current Account: Setup Current Account");
        System.out.println("Create Savings Account: Setup Savings Account");
        System.out.println("View Balance: view balance");
        System.out.println("Add Funds: add funds");

        String account = input.nextLine();
        switch (account){
            case "setup current account":

            case "setup savings account":
                System.out.println("What is your email Address?");
                createAccount.setEmailAddress(input.nextLine());

                System.out.println("What is your first name");
                createAccount.setFirstName(input.nextLine());

                System.out.println("What is your last name");
                createAccount.setLastName(input.nextLine());

                System.out.println("Account Created");
                break;

            case "view balance":
                createAccount.getBalance();


            case "add funds":
                System.out.println("How much would you like to add?");
                createAccount.setBalance(input.nextInt());
                System.out.println(createAccount.getBalance());
        }
        }
    }

