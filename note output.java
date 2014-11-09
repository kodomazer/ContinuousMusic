import java.io.File;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class Note {
        public int channel;
        public int key;
        // public int offVelocity;
        public int onVelocity;
        public int onTick;
        public int offTick;
        
        public Note(int channel, int key, int onVelocity, int onTick, int offTick)
        
        // public Method
        public void setVo(int newValue) {
        
        }

public class Measure {
        public int tempo;
        public Note[] noteArray;
        
        public Measure(int tempo, Note[] noteArray)
        
        public void setTempo
        public void setArray
