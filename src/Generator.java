/** This takes a measure and returns the next measure. 
*(Randomly chooses which change to make and calls appropriate method?)
* Relies on:  ChangeTempo(measure) change in... bpm?
*             ChangeToggle(measure), toggle a random instrument 
*             ChangeMelody(measure), change some part of the melody
*             ChangeRhythm(measure), reorganize the same melody into a different rhythm.
*/

Include Measure

public class Generator{
	
	
	int goalTempo;
	Measure initialMeasure;
	Boolean[] instruToggle;
	double cons; //use for tempo change consistency.
	
	public Generator(Measure initMeasureIn) {
	 	goalTempo = initMeasureIn.tempo;
	 	initialMeasure = initMeasureIn;
		instruToggle = new Boolean[16];
		cons = .70;
	 }
	
	public Measure iterate() {
	  double pTempo; /* Tempo can be changed independently of others */
	  double pToggle;
	  double pMelody;
	  double pRhythm; /* Only one of these can be changed at once */
	  double roll1;
	  double roll2;
	  Measure postTempo;
	  
	  pTempo = 0.2;
	  pToggle = 0.25;
	  pMelody = 0.375;
	  pRhythm = 1 - pToggle - pMelody; /* Probablilities should sum up to 1. */
	  roll1 = Math.random();
	  roll2 = Math.random();
	  postTempo = new Measure();
	  
  	  if(roll1<pTempo){
  	      postTempo = ChangeTempo(initialMeasure);
  	  } else { 
  	      postTempo = initialMeasure;
  	  }
  	  
  	
  	  if(roll2<pToggle){
  	      ChangeToggle(postTempo);
  	  } else { 
  	          roll2 =  roll2 - pToggle;
  	          if(roll2<pMelody){
  	          	ChangeMelody(postTempo);
  	          } else {
  	          	ChangeRhythm(postTempo);
  	          }
  	  }
  	    return initialMeasure;    
	}
	
	public void ChangeTempo() {
		double roll;
		int big;
		int small;
		int goFaster;
		double cons; //consistency of tempo change. 
		
		small = 3;
		big = 20;
		cons = .7;
		goFaster = if(initialMeasure.tempo < goalTempo) {1} else {-1};
		
		
		if(initialMeasure.tempo == goalTempo) {
			if(Math.random()>0.5) {
				goalTempo = goalTempo + big;
			} else {
				goalTempo = goalTempo - big;
			}
		} else {
			goalTempo = goalTempo + small * (int(Math.random()*3)-1);
			
		}
		
		if(Math.random()<cons) { 
			initialMeasure.setTempo(initialMeasure.tempo + 1 * goFaster);
		} else { 
			initialMeasure.setTempo(initialMeaure.tempo - 1 * goFaster);
		}
		
	}
	
	//Dummy Methods follow:
	
	public void ChangeMelody {
		
		//Nothing here~
		
	}
	
	public void ChangeRhythm {
		
		//Nothing here either....
		
	}
	
	// End Dummy Methods.
	
	}
	}
	
}
