package kushcabbage;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;

import javax.sound.sampled.LineUnavailableException;

public class GoogleApiListenerThread implements Runnable {

    Microphone mic;
    GSpeechDuplex duplex;
    public GoogleApiListenerThread(Microphone m, GSpeechDuplex d){
        mic=m;
        duplex= d;

    }
    @Override
    public void run() {
        try {
            duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
        } catch (LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
