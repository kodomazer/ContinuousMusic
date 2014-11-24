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
	
	boolean getCommand(){
		if(this.commandNum==0x80)
			return true;
		else
			return false;
	}
	
	//Setters
	boolean setChannel(int newChannel){
		if(newChannel>=0&&newChannel<16)
			this.channel=newChannel;
		else
			return false;
		return true;
	}
	boolean setKey(int newKey){
		if(newKey>=0&&newKey<128)
			this.key=newKey;
		else
			return false;
		return true;
	}
	boolean setVelocity(int newVelocity){
		if(newVelocity>=0||newVelocity<128)
			this.velocity=newVelocity;
		else
			return false;
		return true;
	}
	boolean setTick(int newTick){
		if(newTick>=0)
			this.tick=newTick;
		else
			return false;
		return true;
	}
	
	void setCommand(boolean on){
		if(on)
			commandNum=0x90;
		else
			commandNum=0x80;
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

