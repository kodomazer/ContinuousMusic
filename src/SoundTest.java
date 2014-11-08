import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
public class SoundTest{
	public static void main(String[] args) throws Exception {
		Sequencer sequencer = MidiSystem.getSequencer();
		sequencer.open();
		InputStream is = new BufferedInputStream(new FileInputStream(new File("midifile.mid")));
		sequencer.setSequence(is);
		sequencer.start();
	}
}
