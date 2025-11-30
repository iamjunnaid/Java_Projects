import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Main class for the Java Alarm Clock application.
 * This class handles user input, validates the alarm time,
 * and starts the alarm thread when the time is correctly provided.
 */

public class App {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "src\\make the visible invisible - Alge.wav";

        // Loop until the user provides a valid time in HH:MM:SS format
        while(alarmTime == null){
            try{
                System.out.print("Enter an alarm time (HH:MM:SS) : ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for: " + alarmTime);

        }

            catch(DateTimeParseException e){
                System.out.println("Invalid format. Please use HH:MM:SS");

        } 
    }   
    // Create and start the alarm thread
        AlarmClass alarmClock = new AlarmClass(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();

        
    }
}
