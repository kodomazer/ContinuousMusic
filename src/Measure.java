package storage;
import java.util.*;
import storage.Note;
import javax.sound.midi.*;

public class Measure {
	public int tempo;
	public LinkedList<Note> noteList;
	public int size(){
		return noteList.size();
	}
	public Measure(int tempoIn,LinkedList<Note> noteListIn){
		tempo=tempoIn;
		noteList=noteListIn;
	}
	public Measure() {
		tempo = 0;
		noteList = new LinkedList<Note>();
	}
	public Note noteAt(int index){
		return noteList.get(index);
	}
	public int getTempo(){
		return tempo;
	}
	public void setTempo(int newValue) {
		tempo = newValue;
	}
	public void editNote(int index,Note newNote) {
		noteList.set(index, newNote);
	}
	public void addNote(Note newNote) {
		noteList.addLast(newNote);
	}//*
	public ShortMessage messageAt(int index){
		return noteList.get(index).toShortMessage();
	}//*/
}
