import java.util.Scanner;

public class Application {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Application app = new Application();
        CurrentAccount tomMumford = new CurrentAccount("Thomas", "Mumford", "thm37@aber.ac.uk", 123456789);
        app.run();

        //add code to run
        System.out.println(tomMumford.toString());
    }

    public void run(){
        System.out.println("Welcome to your bank");
        System.out.println("Do you need to setup a current account/Savings account?");
        String account = input.nextLine();
        switch (account){
            case "setup":
                System.out.println("Account Created");
                break;

            case "no":
                System.out.println("No");
            }

        }
    }

