import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class Music {
public void play(){
    try{
        Sequencer sequencer = MidiSystem.getSequencer();
        System.out.println("Successfully got a sequencer");
    }
    catch (MidiUnavailableException m){
        System.out.println("Bummer");
    }
}

    public static void main(String[] args) {
        Music m = new Music();
        m.play();
    }
}
