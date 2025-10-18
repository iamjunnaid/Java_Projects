import java.util.Scanner;

/**
 * Java Guessing Game
 * -------------------
 * A simple quiz-style guessing game that asks the user multiple-choice
 * questions and calculates their total score based on correct answers.
 *
 * Features:
 *  - Displays a list of questions with multiple-choice options
 *  - Accepts user input for answers
 *  - Shows "CORRECT" or "WRONG" messages
 *  - Displays the final score at the end
 *
 * Author: Junnaid Iqbal
 * Date: 2025-10-18
 * Version: 1.0
 */

public class App {
    public static void main(String[] args){

        // Array of quiz questions
        String[] questions = {"A. What is the main function of a router? ",
                              "B. Which part of the computeris considered the brain? ",
                              "C. What year was Facebook launched? ",
                              "D. Who is known as the father of computers? ",
                              "E. What was the first programming language? "};

        // 2D array of answer options for each question                      
        String[][] options = {{"1. Storing Files","2. Encrypting data","3. Directing internet traffic ","4. Managing Passwords"},
                              {"1. CPU","2. Hard Drive","3. RAM","4. GPU"},
                              {"1. 2000","2. 2004","3. 2006","4. 2008"},
                              {"1. Steve Jobs","2. Bill Gates","3. Alan Turing","4. Charles Babbage"},
                              {"1. COBOL","2. C","3. Fortran","4. Assembly"}};
        int[] answers = {3, 1, 2, 4, 3};
        int score = 0;
        int guess;

        Scanner scanner = new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("Welcome to Java Guess Game");
        System.out.println("**************************");

        for(int i = 0; i < questions.length; i++ ){
            System.out.println(questions[i]);

            for(String option : options[i]){
                System.out.println(option);
                
            }

            // Loop through each question
            System.out.print("Enter your answer (1-4): ");
            guess = scanner.nextInt();

            if(guess == answers[i]){
                System.out.println("*******");
                System.out.println("CORRECT");
                System.out.println("*******");
                score ++;
            }
            else{
                System.out.println("*******");
                System.out.println(" WRONG ");
                System.out.println("*******");

            }
        }
        System.out.print("You have guessed " + score + " right answers out of 5");

        scanner.close();
    }
}
