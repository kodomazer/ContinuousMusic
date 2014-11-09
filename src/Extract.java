import java.io.File;
import java.util.Queue;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import storage.Note;
import storage.Measure;

public class Extract {
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    
    //public extractnotes midiextract(tick, channel, command, key, velocity){tick = event.getTick(), channel = sm.getChannel(), key = sm.getData1(), velocity = sm.getData2()};
    
    //Measure extractnotes;
    //extractnotes = new Measure ();
    
    //Note extract
    //extract = new Note (tick, channel, command, key, velocity);
    
    public static Measure extractnotes(Sequence sequence) throws Exception {
		Measure extractNotes=new Measure();
        int tick=0;
        int channel=0;
        int key=0;
        int velocity=0;
        boolean command=true;
        
        
        int trackNumber = 0;
        for (Track track :  sequence.getTracks()) {
            trackNumber++;
            for (int i=0; i < track.size(); i++) { 
                MidiEvent event = track.get(i);
                tick = (int)event.getTick();
                MidiMessage message = event.getMessage();
                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    channel = sm.getChannel();
                    if (sm.getCommand() == NOTE_ON) {
                        key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        velocity = sm.getData2();
                        command = true;
                    } else if (sm.getCommand() == NOTE_OFF) {
                        key = sm.getData1();
                        velocity = sm.getData2();
                        command = false;
                    }
                } 
				extractNotes.addNote(new Note(tick, channel, command, key, velocity));
            }
			
        }
		return extractNotes;
    }
}
