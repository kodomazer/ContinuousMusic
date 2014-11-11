package storage;

import javax.sound.midi.*;


//RawNote is not changeable after creation
public class RawNote {
private:
	int channel;
	int key;
	int velocity;
	int tick;
	boolean isOn;
	int commandNum;
	
public:
	Note(boolean isOnIn,int channelIn,int keyIn,int velocityIn,int tickIn){
		tick=tickIn;
		channel = channelIn;
		setOn(isOnIn);
		key=keyIn;
		velocity=velocityIn;
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
	
	//returns a MidiCommand, that represents the RawNote, to be used in the player
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

