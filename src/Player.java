package run;

import javax.sound.midi.*;
import storage.RawNote;
import storage.RawMeasure;
import java.util.concurrent.LinkedBlockingDeque;

public class Player{
	LinkedBlockingDeque<RawMeasure> inputQueue=new LinkedBlockingDeque<RawMeasure>();
	RawMeasure currentMeasure=null;
	int tick=0;
	long lastT=0;
	int deltaT=0;
	int index=0;
	Receiver rec;
	
	public Player(){
		try{
			rec = MidiSystem.getReceiver();
		}
		catch(MidiUnavailableException a){
			rec = null;
		}
	}
	
	public void play(){
		long initialTime=System.currentTimeMillis();
		while(inputQueue.size()>0){
			while(index<currentMeasure.size()){
				if(System.currentTimeMillis()-lastT>deltaT){
					lastT=System.currentTimeMillis();
					while(tick<=currentMeasure.noteAt(index).tick){
						Note h=currentMeasure.noteAt(index);
						rec.send(currentMeasure.messageAt(index),initialTime-lastT);
						index++;
						if(index==32)break;
						if(currentMeasure.size()==0);
					}
					tick++;
					
				}
			}
			if(inputQueue.peek() instanceof Measure)
				currentMeasure=inputQueue.remove();
			else break;
			int newDeltaT=(int)(60./currentMeasure.getTempo()*1000.);
			if(newDeltaT-deltaT>50)
				deltaT+=50;
			else if(newDeltaT-deltaT<50)
				deltaT-=50;
			else 
				deltaT=newDeltaT;
			if(inputQueue.size()<2) deltaT-=55;
			
			tick=0;
			index=0;
		}
	}
	public void changeCurrentMeasure(Measure nextMesure){
		currentMeasure=nextMesure;
		deltaT=(int)(60000./currentMeasure.getTempo());
	}
	
	public void addToQueue(Measure newMeasure){
		System.out.println("addToQueueCalled");
		inputQueue.add(newMeasure);
	}

}
