package storage;

public class Note {
        public int channel;
        public int key;
        // public int offVelocity;
        public int velocity;
        public int tick;
        public boolean isOn;
        
        public Note(int tickIn, int channelIn, boolean isOnIn, int keyIn, int velocityIn){
			tick=tickIn;
			channel = channelIn;
			isOn = isOnIn;
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
        }
        public void setKey(int newValue) {
                key = newValue;
        }
        }

