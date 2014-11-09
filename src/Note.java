package storage;

public class Note {
	public int channel;
	public int key;
	public int velocity;
	public int tick;
	public boolean isOn;
	int commandNum;
	// public int offVelocity;
	
	public Note(int tickIn, int channelIn, boolean isOnIn, int keyIn, int velocityIn){
		tick=tickIn;
		channel = channelIn;
		setOn(isOnIn);
		key=keyIn;
		velocity=velocityIn;
	}
	// public Method
	public void setV(int newValue) {
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
}

