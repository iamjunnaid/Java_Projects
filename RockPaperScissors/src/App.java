import java.util.Random;
import java.util.Scanner;

/**
 * Rock, Paper, Scissors Game
 * --------------------------
 * A simple console-based game where the player competes against
 * the computer in the classic "Rock, Paper, Scissors" game.
 *
 * Features:
 *  - Player vs Computer gameplay
 *  - Randomized computer choice
 *  - Input validation
 *  - Option to play multiple rounds
 *
 * Author: Junnaid Iqbal
 * Date: 2025-10-20
 * Version: 1.0
 */

public class App {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        String playerChoice;
        String computerChoice;
        String playAgain = "yes";

        // Game loop — runs until player chooses to stop
        do{

        System.out.println("Welcome to Rock, Paper, Scissor Game");
        System.out.print("Enter your move (rock, paper,scissors): ");
        playerChoice = scanner.nextLine().toLowerCase();


        // Validate user input
        if(!playerChoice.equals("rock") &&
            !playerChoice.equals("paper") &&
            !playerChoice.equals("scissors")){

                System.out.println("Invalid choice");
                continue;
            }
         
        computerChoice = choices[random.nextInt(3)];
        System.out.println("Computer Choice: " + computerChoice);

        
        // Compare player and computer choices
        
        if(playerChoice.equals(computerChoice)){
            System.out.println("It is a tie");

        }

        else if((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))){
                    System.out.println("You Win!");

        }
        else{
            System.out.println("You Lose");
        }

        System.out.print("Do you want to play agian(yes/no): ");
        playAgain = scanner.nextLine().toLowerCase();
        }while(playAgain.equals("yes"));

        
        
        scanner.close();
    }
}
