package storage;
import java.util.*;
import storage.Note;
import storage.RawMeasure;
import javax.sound.midi.*;


public class Measure {
private:
	int tempo;
	LinkedList<Note>[] noteList;
	int beatsPerBar;
	int ticksPerBeat;
	//constructors
public:
	//Empty constructor
	public Measure() {
		tempo = 120;
		for(int i=0;i<16;i++)
			noteList[i] = new LinkedList<Note>();
		beatsPerBar=4;
		ticksPerBeat=4;
	}
	
	/*artifact from CodeDay not sure of intended usage
	public Measure(int tempoIn,LinkedList<Note>[] noteListIn){
		tempo=tempoIn;
		noteList=noteListIn;
	}
	//*/
	
	//Methods to set fields
	void setTempo(int newValue) {
		tempo = newValue;
	}
	
	void setBeat(int newValue){
		beatsPerBar=newValue;
	}
	
	void setTick(int newValue){
		ticksPerBeat=newValue;
	}
	
	void editNote(int index,Note newNote) {
		noteList[newNote.getChannel()].set(index, newNote);
	}
	
	void addNote(Note newNote) {
		noteList[newNote.getChannel()].addLast(newNote);
	}
	
	//Methods to get fields
	public Note noteAt(int index){//old method, should be phased out
		System.out.println("Warning: Usage of old method.\nMethod: noteAt in storage.Measure");
		return noteList[0].get(index);
	}
	
	public Note noteAt(int channel,int index){//new method, use this one
		return noteList[channel].get(index);
	}
	
	public int getTempo(){
		return tempo;
	}
	
	int getBeat(){
		return beatsPerBar;
	}
	
	int getTick(){
		return ticksPerBeat;
	}
	
	//Artifact from RawMeasure for the player, unsure if to be used in Measure
	public boolean isMore(int[] index){
		boolean more=false;
		for(int i=0;i<16;i++)
			if(index[i]<=noteList[i].size())
				more=true;
		return more;
	}
	//TODO
	//Create a method to change this Measure into the equivalent RawMeasure
	//RawMeasure toRawMeasure(){
	//}
	
	public RawMeasure toRawMeasure() {
		RawMeasure outMeasure = new RawMeasure();
		RawNote onNote;
		RawNote offNote;
		
		for(int i=0; i<noteList.size();i++) {
			onNote = new Note(True, noteList[i].getChannel(), noteList[i].getKey(), noteList[i].getVelocity(), noteList[i].getTick());
			offNote = new Note(False, noteList[i].getChannel(), noteList[i].getKey(), noteList[i].getVelocity(), noteList[i].getTick()+noteList[i].getDuration());
			outMeasure.addNote(onNote);
			outMeasure.addNote(offNote);
		}
		outMeasure.setTempo(tempo);
		outMeasure.setBeats(beatsPerBar);
		outMeasure.setTicks(ticksPerBeat);
		return outMeasure;
	}
}
