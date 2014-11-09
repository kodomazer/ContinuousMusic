import java.io.File;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import Measure;

public class Extract {
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    
    //public extractnotes midiextract(tick, channel, command, key, velocity){tick = event.getTick(), channel = sm.getChannel(), key = sm.getData1(), velocity = sm.getData2()};
    
    //Measure extractnotes;
    //extractnotes = new Measure ();
    
    //Note extract
    //extract = new Note (tick, channel, command, key, velocity);
    
    public static void extractnotes(String[] args) throws Exception {
        Sequence sequence = MidiSystem.getSequence(new File("test.mid"));
        Measure extractnotes;
        extractnotes = new Measure ();
    
        Note extract
        
        int trackNumber = 0;
        for (Track track :  sequence.getTracks()) {
            trackNumber++;
            // System.out.println("Track " + trackNumber + ": size = " + track.size());
            // System.out.println();
            for (int i=0; i < track.size(); i++) { 
                MidiEvent event = track.get(i);
                int tick = event.getTick();
                // System.out.print("@" + event.getTick() + " ");
                MidiMessage message = event.getMessage();
                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    int channel = sm.getChannel();
                    // System.out.print("Channel: " + sm.getChannel() + " ");
                    if (sm.getCommand() == NOTE_ON) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        boolean command = true;
                        // System.out.println("Note on, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    } else if (sm.getCommand() == NOTE_OFF) {
                        int key = sm.getData1();
                        int octave = (key / 12)-1;
                        int note = key % 12;
                        // String noteName = NOTE_NAMES[note];
                        int velocity = sm.getData2();
                        boolean command = false;
                        // System.out.println("Note off, " + noteName + octave + " key=" + key + " velocity: " + velocity);
                    } else {
                        // System.out.println("Command:" + sm.getCommand());
                    }
                } else {
                    // System.out.println("Other message: " + message.getClass());
                }
            }
            extract = new Note (tick, channel, command, key, velocity);
            // System.out.println();
        }

    }
}
