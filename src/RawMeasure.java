package storage;
import java.util.*;
import storage.RawNote;
import storage.Note;
import javax.sound.midi.*;

public class RawMeasure {
	public int tempo;
	public LinkedList<RawNote>[] noteList;
	
	public boolean isMore(int[] index){
		boolean more=false;
		for(int i=0;i<16;i++)
			if(index[i]<=noteList[i].size())
				more=true;
		return more;
	}
	//Constructor should have noteListIn.length() be 16
	public Measure(int tempoIn,LinkedList<RawNote>[] noteListIn){
		tempo=tempoIn;
		noteList=noteListIn;
	}
	//Empty constructor
	public Measure() {
		tempo = 120;
		for(int i=0;i<16;i++)
			noteList[i] = new LinkedList<RawNote>();
	}
	
	
	public RawNote noteAt(int index){//old method, should be phased out
		System.out.println("Warning: Usage of old method.\nMethod: noteAt in storage.RawMeasure");
		return noteList[0].get(index);
	}
	
	
	public RawNote noteAt(int channel,int index){//new method, use this one
		return noteList[channel].get(index);
	}
	public int getTempo(){
		return tempo;
	}
	public void setTempo(int newValue) {
		tempo = newValue;
	}
	public void editNote(int index,RawNote newNote) {
		noteList[newNote.getChannel()].set(index, newNote);
	}
	public void addNote(RawNote newNote) {
		noteList[newNote.getChannel()].addLast(newNote);
	}//*
	
	//old method, phase out
	public ShortMessage messageAt(int index){
		System.out.println("Warning: Usage of old method.\nMethod: messageAt in storage.Measure");
		return noteList[0].get(index).toShortMessage();
	}//*/
	
	
	public ShortMessage messageAt(int channel,int index){
		return noteList[channel].get(index).toShortMessage();
	}
	
}
