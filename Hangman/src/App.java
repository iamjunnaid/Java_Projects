import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Java Hangman Game
 * -----------------
 * A simple console-based Hangman game built in Java.
 * The program randomly selects a word from a text file,
 * and the player must guess the letters before the hangman is fully drawn.
 *
 * Author: Junnaid Iqbal
 * Version: 1.0
 * Date: 2025-11-13
 */
public class App {
    public static void main(String[] args) {

        // Path to the file that contains words for the game
        String filePath = "src\\words.txt";
        ArrayList<String> words = new ArrayList<>();

        // Read words from the file and store them in a list
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong while reading the words file.");
        }

        // Choose a random word from the list
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        // Prepare variables for the game
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0;

        // Initialize the word state with underscores
        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("************************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("************************");

        // Main game loop
        while (wrongGuesses < 6) {
            System.out.print(getHangman(wrongGuesses)); // Display hangman stage
            System.out.print("Word: ");

            // Display the current guessed state of the word
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            // Ask player for a letter guess
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            // Check if guessed letter exists in the word
            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct guess!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong guess!");
            }
        }

        // Game over message when player reaches 6 wrong guesses
        if (wrongGuesses >= 6) {
            System.out.print(getHangman(wrongGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The word was: " + word);
        }

        scanner.close();
    }

    /**
     * getHangman()
     * Returns the ASCII art for each stage of the hangman
     * based on the number of wrong guesses.
     */
    static String getHangman(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """
                    


                    """;

            case 1 -> """
                        o

                    
                    """;

            case 2 -> """
                        o
                       /
                    
                    """;

            case 3 -> """
                        o
                       /|          

                    
                    """;

            case 4 -> """                  
                        o
                       /|\\  
                    
                    """;

            case 5 -> """            
                        o
                       /|\\  
                       /                    
                    
                    """;
            case 6 -> """            
                        o
                       /|\\  
                       / \\                   
                    
                    """;
            default -> "";
        };
    }
}
