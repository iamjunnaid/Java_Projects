import java.util.Scanner;
import java.util.Random;

/**
 * Java Slot Machine
 * -----------------
 * A small console-based slot machine game. Player starts with a balance,
 * places bets, and spins a 3-symbol row. Matching symbols pay out based
 * on the bet and symbol type.
 *
 * Notes:
 *  - Uses emoji symbols for visual flair; ensure your terminal supports UTF-8
 *    and an emoji-capable font so symbols display correctly.
 *
 * Author: Junnaid Iqbal
 * Version: 1.0
 * Since: 2025-10-21
 */

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int balance = 100;
        int bet;
        int payout;
        String[] row;
        String playAgain;

        System.out.println("*****************************");
        System.out.println("Welcome to Java Slot Machine");
        System.out.println("Symbols: 🍒 🍉 🍐 🔔 📀");
        System.out.println("*****************************");

        while(balance > 0){
            System.out.println("Current Balnace: £" + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet > balance){
                System.out.println("Insufficent Funds");
                break;
            }
            else if (bet <= 0){
                System.out.println("Bet must be greater than 0");
                continue;
            }
            else{
                balance -= bet;
            }

            System.out.println("Spinning ...");
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);
            if(payout > 0){
                System.out.println("You won: £" + payout);
                balance += payout;
            }
            else{
                System.out.println("Sorry you lost this round");
            }

            System.out.print("Do you want to play again(Y/N)?: ");
            playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")){
                break;
            }
            
        }
        System.out.println("Game Over! Your Balance is: £" + balance);
        scanner.close();
    }
 /**
* spinRow
* --------
* Randomly generates a row of 3 symbols from the available symbol set.
   */
static String[] spinRow(){
    String[] symbols = {"🍒", "🍉", "🍐", "🔔", "📀"};
    String[] row = new String[3];
    Random random = new Random();
    
    for (int i=0; i<3; i++){
        row[i] = symbols[random.nextInt(symbols.length)];
    }
    return row;
}

/**
* printRow
* --------
* Nicely prints the 3-symbol row to the console.
    */
static void printRow(String[] row){
    System.out.println("********************");
    System.out.println(" " + String.join(" | ", row));

}

/**
* getPayout
* ---------
* Determine payout based on the final row and the bet amount.
* - Three matching symbols -> higher multipliers
* - Two adjacent matching symbols -> lower multipliers
*
* Payout multipliers are chosen per symbol type.
    */
static int getPayout(String[] row, int bet){
    if(row[0].equals(row[1]) && (row[1].equals(row[2]))){
        return switch(row[0]){
            case "🍒" -> bet * 3;
            case "📀" -> bet * 5;
            case "🔔" -> bet * 7;
            case "🍐" -> bet * 10;
            case "🍉" -> bet * 15;
            default -> 0;


        };

    }
    else if(row[0].equals(row[1])){
        return switch(row[0]){
            case "🍒" -> bet * 2;
            case "📀" -> bet * 4;
            case "🔔" -> bet * 6;
            case "🍐" -> bet * 8;
            case "🍉" -> bet * 13;
            default -> 0;


        };
    }
    else if(row[1].equals(row[2])){
        return switch(row[0]){
            case "🍒" -> bet * 2;
            case "📀" -> bet * 4;
            case "🔔" -> bet * 6;
            case "🍐" -> bet * 8;
            case "🍉" -> bet * 13;
            default -> 0;


        };
    }

    return 0;
}
}
