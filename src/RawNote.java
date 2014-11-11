package storage;

import javax.sound.midi.*;

public class RawNote {
	public int channel;
	public int key;
	public int velocity;
	public int tick;
	public boolean isOn;
	int commandNum;
	// public int offVelocity;
	//phase out old constructor usage
	public Note(int tickIn, int channelIn, boolean isOnIn, int keyIn, int velocityIn){
		tick=tickIn;
		channel = channelIn;
		setOn(isOnIn);
		key=keyIn;
		velocity=velocityIn;
	}
	
	//New constructor
	public Note(boolean isOnIn,int channelIn,int keyIn,int velocityIn,int tickIn){
		tick=tickIn;
		channel = channelIn;
		setOn(isOnIn);
		key=keyIn;
		velocity=velocityIn;
	}
	
	// public Method
	//Methods to set fields
	public void setVelocity(int newValue) {
		velocity = newValue;
	}
	public void setTick(int newValue) {
		tick = newValue;
	}
	public void setOn(boolean newValue) {
		isOn = newValue;
		if(isOn){
			commandNum = 0x90;
		} else{
			commandNum = 0x80;
		}
	}
	public void setKey(int newValue) {
		key = newValue;
	}
	
	//Methods to get fields
	public int getChannel(){
		return channel;
	}
	public int getNote(){
		return key;
	}
	
	
	public ShortMessage toShortMessage(){
		try{
			ShortMessage out = new ShortMessage(commandNum,channel,key,velocity);
			return out;
		}
		catch (InvalidMidiDataException a){
			return null;
		}
	}
}

