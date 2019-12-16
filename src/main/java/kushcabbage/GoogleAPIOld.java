
package kushcabbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import javax.sound.sampled.LineUnavailableException;


import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;
////https://github.com/lkuza2/java-speech-api


import net.sourceforge.javaflacencoder.FLACFileWriter;




public class GoogleAPIOld {

    //private final TextToSpeech tts = new TextToSpeech();
    private final Microphone mic = new Microphone(FLACFileWriter.FLAC);
    private final GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
    String oldText = "";




    public static void main(String[] args) {

        new GoogleAPIOld();



    }

    /**
     * Constructor
     */
    public GoogleAPIOld() {


        //Duplex Configuration
        duplex.setLanguage("en");

        duplex.addResponseListener(new GSpeechResponseListener() {

            public void onResponse(GoogleResponse googleResponse) {
                String output = "";

                //Get the response from Google Cloud
                output = googleResponse.getResponse();
                System.out.println(output);
                if (output != null) {
                    makeDecision(output);
                } else
                    System.out.println("Output was null");
            }
        });


        startSpeechRecognition();

    }

    /**
     * This method makes a decision based on the given text of the Speech Recognition
     *
     * @param
     */
    public void makeDecision(String output) {

        output = output.trim();
        //System.out.println(output.trim());

        //We don't want duplicate responses
        if (!oldText.equals(output)){
            oldText = output;}
        else{
            return;}
        output=output.toLowerCase();

        if(output.toLowerCase().equals("cancel")){
            System.exit(0);
        }

        if(output.toLowerCase().contains("off") && output.toLowerCase().contains("lights")){

        }
        if(output.toLowerCase().contains("on") && output.toLowerCase().contains("lights")){

        }



    }






    /**
     * Starts the Speech Recognition
     */
    public void startSpeechRecognition() {
        //Start a new Thread so our application don't lags
        new Thread(() -> {
            try {
                duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
            } catch (LineUnavailableException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Stops the Speech Recognition
     */
    public void stopSpeechRecognition() {
        mic.close();
        System.out.println("Stopping Speech Recognition...." + " , Microphone State is:" + mic.getState());
    }




}