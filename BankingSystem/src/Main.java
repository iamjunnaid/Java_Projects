import java.util.Scanner;
/**
 * Simple Banking System
 * ----------------------
 * This program simulates a basic banking system that allows users to:
 *  - Check balance
 *  - Deposit money
 *  - Withdraw money
 *  - Exit the system
 *
 * @author  Junnaid Iqbal
 * @version 1.0
 * @since   2025-10-13
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        // Declare Variables
        double balance = 0;
        boolean isRunning = true;


        while(isRunning){       
        

        // Display Menu
        System.out.println("**************");
        System.out.println("Banking System");
        System.out.println("**************");

        System.out.println("1. Show Balance");
        System.out.println("2. Depossit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");

        // GET and Process Users Choice

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1 -> showBalance(balance);
            case 2 -> balance = balance + deposit();
            case 3 -> balance = balance - withdraw(balance);
            case 4 -> isRunning = false;
            default -> System.out.println("Invalid Choice");
        }

        }
     
        System.out.println("Thank you for using the Banking System");

        scanner.close();
        
        
    }
    // showBalance()
    static void showBalance(double balance){
        
        System.out.printf("Your current balance is: £%.2f\n\n", balance);

    }

    // deposit()

    static double deposit(){
        double amount;
        System.out.print("Enter the deposit amount: ");
        amount = scanner.nextDouble();

        if (amount > 0){
            return amount;
        }
        else{
            System.out.println("Amount can not be negative");
            return 0;
        }


        
    }

    // withdraw()

    static double withdraw(double balance){
        System.out.print("Enter the withdrawal Amount: ");
        double amount = scanner.nextDouble();

        if (amount < 0){
            System.out.println("The withdrawal amount can not be negative");
            return 0;
        }
        else if (amount > balance){
            System.out.println("Insufficient Balance");
            return 0;
        }
        else{
            return amount;
        }


    }
    
}
