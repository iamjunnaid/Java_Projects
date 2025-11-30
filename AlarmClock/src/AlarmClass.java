import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * AlarmClass implements Runnable so it can run on a separate thread.
 * It counts down until the alarm time and then plays an audio file.
 */

public class AlarmClass implements Runnable{

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    AlarmClass(LocalTime alarmTime, String filePath, Scanner scanner){
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    /**
     * Thread execution method.
     * Continuously checks current time until alarm time is reached.
     * Once reached, plays an alarm sound.
     */
    @Override
    public void run(){
        
        while(LocalTime.now().isBefore(alarmTime)){
            try{
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                System.out.printf("\r%02d:%02d:%02d",
                                now.getHour(),
                                now.getMinute(),
                                now.getSecond());
            }
            catch(InterruptedException e){
                System.out.println("Thread was interrupted");
            }
            
        }

        System.out.println("\n*Alarm Noise*");
        playSound(filePath);

    }

     /**
     * Plays the alarm sound using javax.sound.sampled API.
     * Allows user to press Enter to stop the alarm.
     */

    private void playSound(String filePath){
        File audioFile = new File(filePath);
       

        try( AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.print("Press Enter to stop the alarm: ");
            scanner.nextLine();
            clip.stop();

            
            scanner.close();
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Audio file Format is not supported");


        }
        catch(LineUnavailableException e){
            System.out.println("Audio is unavailable");
        }
        catch(IOException e){
            System.out.println("Error reading audio file");
        }
        
    }

}
