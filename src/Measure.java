package storage;
import java.util.*;
import storage.Note;

public class Measure {
	public int tempo;
	public LinkedList<Note> noteList;

	public Measure(int tempoIn,LinkedList<Note> noteListIn){
		tempo=tempoIn;
		noteList=noteListIn;
	}
	public Measure() {
			tempo = 0;
			noteList = new LinkedList<Note>();
	}


	public void setTempo(int newValue) {
			tempo = newValue;
	}
	public void editNote(int index,Note newNote) {
			noteList.set(index, newNote);
	}
	public void addNote(Note newNote) {
			noteList.addLast(newNote);
	}
}
