package storage;

import javax.sound.midi.*;

public class Note{
private:
	int channel;
	int key;
	int velocity;
	int tick;
	int duration;
	
	
public:
	// public int offVelocity;
	//phase out old constructor usage
	public Note(int tickIn, int channelIn, boolean isOnIn, int keyIn, int velocityIn){
		System.out.println("WARNING: Usage of old constructor: storage.Note");
		tick=tickIn;
		channel = channelIn;
		key=keyIn;
		duration=0;
		velocity=velocityIn;
	}
	
	//New constructor
	public Note(int durationIn,int channelIn,int keyIn,int velocityIn,int tickIn){
		tick=tickIn;
		channel = channelIn;
		duration=durationIn;
		key=keyIn;
		velocity=velocityIn;
	}
	
	// public Method
	//Methods to set fields
	void setChannel(int newValue){
		if(newValue<16&&newValue>=0)
			channel=newValue;
	}
	
	void setKey(int newValue) {
		key = newValue;
	}
	
	public void setVelocity(int newValue) {
		velocity = newValue;
	}
	
	public void setTick(int newValue) {
		tick = newValue;
	}
	
	void setDuration(int newValue){
		duration=newValue;
	}
	
	//Methods to get fields
	int getChannel(){
		return channel;
	}
	
	int getKey(){
		return key;
	}
	
	int getVelocity(){
		return velocity;
	}
	
	int getTick(){
		return tick;
	}
	
	int getDuration(){
		return duration;
	}
}

