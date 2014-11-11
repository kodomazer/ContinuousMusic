package storage;
import java.util.*;
import storage.RawNote;
import storage.Note;
import storage.Measure;
import javax.sound.midi.*;

public class RawMeasure {
private:
	int tempo;
	LinkedList<RawNote> noteList;
	int beatsPerBar;
	int ticksPerBeat;
	
public:
	
	//Empty constructor
	public RawMeasure() {
		tempo = 120;
		beatsPerBar=4;
		ticksPerBeat=4;
		noteList = new LinkedList<RawNote>();
	}
	
	public RawMeasure(RawMeasure first,RawMeasure carry){
		//TODO
		//Create method to carry over all the commands after the last
		//tick of the "measure" so that notes have proper endings
		//assume both measures have the same time signature as the first message
		//assume the carry measure has all the contents and that filtering out
		//   old, already sent commands is necessary
	}
	
	//Methods to set fields
	void setTempo(int newValue) {
		tempo = newValue;
	}
	void editNote(int index,RawNote newNote) {
		noteList[newNote.getChannel()].set(index, newNote);
	}
	
	void addNote(RawNote newNote) {
		noteList.addLast(newNote);
	}
	
	void setBeats(int newValue){
		beatsPerBar=newValue;
	}
	void setTicks(int newValue){
		ticksPerBeat=newValue;
	}
	
	//Methods to get fields
	public RawNote noteAt(int index){
		return noteList.get(index);
	}
	
	public int getTempo(){
		return tempo;
	}
	
	int getBeats(){
		return beatsPerBar;
	}
	
	int getTicks(){
		return ticksPerBeat;
	}
	
	//logic related methods
	boolean isMore(int index){
		boolean more=false;
		if(index[i]<=noteList[i].size())
		more=true;
		return more;
	}
	
	public ShortMessage commandAt(int index){
		return noteList.get(index).toShortMessage();
	}
	
	//TODO:
	//create a Measure that contains the same information as this RawMeasure
	//Measure toMeasure(){
	//}
	
}
