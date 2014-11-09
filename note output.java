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
        public int velocity;
        public int tick;
        public boolean isOn;
        
        public Note(int tick, int channel, boolean isOn, int key, int velocity);
        
        // public Method
        public void setV(int newValue) {
                velocity = newValue;
        
        }
        public void setTick(int newValue) {
                tick = newValue;
        }
        public void setOn(boolean newValue) {
                isOn = newValue;
        }
        public void setKey(int newValue) {
                key = newValue;
        }
        }

public class Measure {
        public int tempo;
        public LinkedList() noteList;
        
        public Measure(int tempo, LinkedList() noteList)
        
        
        public void setTempo(int newValue) {
                tempo = newValue;
        }
        public void editNote(int index,Note newNote) {
                noteList.set(index, newNote);
        }
        public void addNote(Note newNote) {
                noteList.set(index, newNote)
        }
