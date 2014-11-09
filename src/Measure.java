import Note;

public class Measure {
        public int tempo;
        public LinkedList() noteList;
        
        public Measure(int tempo, LinkedList() noteList);
        public Measure() {
                tempo = 0;
                noteList = new LinkedList();
        }
        
        
        public void setTempo(int newValue) {
                tempo = newValue;
        }
        public void editNote(int index,Note newNote) {
                noteList.set(index, newNote);
        }
        public void addNote(Note newNote) {
                noteList.addLast(newNote)
        }
