import javax.sound.midi.*;
import storage.Note;
import storage.Measure;
import java.util*;

public class player{
	queue<Measure> inputQueue=new queue<Measure>();
	Measure currentMeasure=null;
	int tick=0;
	long lastT=0
	int deltaT=0;
	int index=0;
	
	
	public void player(){
		Receiver rec = MidiSystem.getReceiver();
		long initialTime=System.currentTimeMillis();
		while(true){
			while(index<currentMeasure.size()){
				if(System.currentTimeMillis()-lastT>deltaT){
					lastT=System.currentTimeMillis();
					while(tick<=currentMeasure.noteAt(index)){
						rec.send(currentMeasure.noteAt(index).toShortMessage,initialTime-lastT);
						index++;
					}
					tick++
				}
			}
			if(inputQueue.size()==0)break;
			currentMeasure=inputQueue.remove();
			int newDeltaT=60./currentMeasure.getTempo()*1000;
			if(newDeltaT-deltaT>50)deltaT+=50;
			else if(newDeltaT-deltaT<50)deltaT-=50;
			else deltaT=newDeltaT;
			if(inputQueue.size()<2) deltaT-=55;
		}
	}
	public void addToQueue(Measure newMeasure){
		inputQueue.add(newMeasure);
	}

}
