import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Java Audio Player
 * -----------------
 * A simple console-based audio player built in Java. 
 * You can play, stop, reset, or quit the audio file using keyboard commands.
 *
 * Notes:
 * - This program supports .wav audio files.
 * - Ensure the file path is correct and the file exists.
 *
 * Author: Junnaid Iqbal
 * Version: 1.0
 * Date: 2025-11-12
 */

public class App {
    public static void main(String[] args){
        String filePath = "src\\make the visible invisible - Alge.wav";
        File file = new File(filePath);

        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

                // Get a Clip object to control audio playback
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                String response = "";

                // Main loop: runs until user quits
                while(!response.equals("Q")){

                    System.out.println("P = Play");
                    System.out.println("S = Stop");
                    System.out.println("R = Reset");
                    System.out.println("Q = Quit");
                    System.out.print("Enter your choice: ");

                    response = scanner.next().toUpperCase();
                    switch(response){
                        case "P" -> clip.start();
                        case "S" -> clip.stop();
                        case "R" -> clip.setMicrosecondPosition(0);
                        case "Q" -> clip.close();
                        default -> System.out.println("Invalid Response");
                    }

                    
                }

        }

        catch(FileNotFoundException e){
            System.out.println("Could not locate file.");
        }
        catch(IOException e){
            System.out.println("Something went wrong");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Audio File is not supported.");
        }
        catch(LineUnavailableException e){
            System.out.println("Audio File is corrupted.");
        }
        finally{
            System.out.println("Bye");
        }
    }
}
