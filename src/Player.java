package run;

import javax.sound.midi.*;
import storage.RawNote;
import storage.RawMeasure;
import java.util.concurrent.LinkedBlockingDeque;

public class Player{
private:
	LinkedBlockingDeque<RawMeasure> inputQueue=new LinkedBlockingDeque<RawMeasure>();
	RawMeasure currentMeasure=null;
	int tick=0;
	int ticksPerMeasure=0;
	long lastT=0;
	int deltaT=0;
	int index=0;
	Receiver rec;
	
public:
	Player(){
		try{
			rec = MidiSystem.getReceiver();
		}s
		catch(MidiUnavailableException a){
			rec = null;
		}
	}
	
	
	//Start playing music
	void play(){
		long initialTime=System.currentTimeMillis();
		while(inputQueue.size()>0){
			while(ticks!=ticksPerMeasure){
				if(System.currentTimeMillis()-lastT>deltaT){
					lastT=System.currentTimeMillis();
					while(index<currentMeasure.size()&&tick<=currentMeasure.noteAt(index).getTick()){
						rec.send(currentMeasure.messageAt(index),initialTime-lastT);
						index++;
						if(index==currentMeasure.size())
							break;
					}
					tick++;
				}
			}
			nextMeasure();
			tick=0;
			index=0;
		}
	}
private: //internal methods
	boolean nextMeasure(){
		currentMeasure=new RawMeasure(inputQueue.remove(),currentMeasure);
		stepTime();
		ticksPerMeasure=currentMeasure.getBeats()*currentMeasure.getTicks();
	}
	
	void stepTime(){
		int newDeltaT=60000/currentMeasure.getTempo()/currentMeasure.getTicks();
		if(newDeltaT-deltaT>5)
				deltaT+=5;
			else if(newDeltaT-deltaT<5)
				deltaT-=5;
				deltaT=newDeltaT;
			if(inputQueue.size()<10) deltaT-=7;
			
	}
	
	void setTime(){
		int newDeltaT=60000/currentMeasure.getTempo()/currentMeasure.getTicks();
	}
	
public: //external field changes
	void setTime(int newTime){
		deltaT=newTime;
	}
	void changeCurrentMeasure(Measure nextMesure){
		currentMeasure=nextMesure;
		setTime();
		ticksPerMeasure=currentMeasure.getTicks()*currentMeasure.getBeats();
	}
	
	//used by generator to add measures to the queue
	void addToQueue(Measure newMeasure){
		inputQueue.add(newMeasure);
	}
	
	

}
