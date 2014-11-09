public class Note {
        public int channel;
        public int key;
        // public int offVelocity;
        public int velocity;
        public int tick;
        public boolean isOn;
        
        public Note(int tick, int channel, boolean isOn, int key, int velocity);
        
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

