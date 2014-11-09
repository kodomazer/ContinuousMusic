/** This takes a measure and returns the next measure. 
*(Randomly chooses which change to make and calls appropriate method?)
* Relies on:  ChangeTempo(measure) change in... bpm?
*             ChangeToggle(measure), toggle a random instrument 
*             ChangeMelody(measure), change some part of the melody
*             ChangeRhythm(measure), reorganize the same melody into a different rhythm.
*/
package run;

import storage.Measure;

public class Generator{

	int goalTempo;
	Measure initialMeasure;
	boolean[] instruToggle;
	double cons; //use for tempo change consistency.
	
	public Generator(Measure initMeasureIn) {
		System.out.println(10);
	 	goalTempo = initMeasureIn.tempo;
	 	initialMeasure = initMeasureIn;
		instruToggle = new boolean[16];
		cons = .70;
		
	 }
	
	public Measure iterate() {
	  double pTempo = 0.2; /* Tempo can be changed independently of others */
	  double pToggle = 0.25;
	  double pMelody = 0.375;
	  double pRhythm = 1 - pToggle - pMelody; /* Only one of these can be changed at once */
	  double roll1= Math.random();
	  double roll2 = Math.random();
	  Measure postTempo = new Measure();
	  
  	  if(roll1<pTempo){
  	      changeTempo();
  	  }
  	  
  	
  	  if(roll2<pToggle){
  	      changeToggle();
  	  } else { 
  	          roll2 =  roll2 - pToggle;
  	          if(roll2<pMelody){
  	          	changeMelody();
  	          } else {
  	          	changeRhythm();
  	          }
  	  }
		System.out.println("RETURNS");
  	    return initialMeasure;    
	}
	
	public void changeTempo() {
		double roll;
		int goFaster;
		int small = 3;
		int big = 20;
		double cons = 1;//consistency of tempo change. 
		if(true){//initialMeasure.tempo < goalTempo) {
			goFaster =10;
		}else {
			//goFaster =-1;
		}
		if(initialMeasure.tempo == goalTempo) {
			if(Math.random()>0.5) {
				goalTempo = goalTempo + big;
			}else{
				goalTempo = goalTempo - big;
			}
		} else {
			goalTempo = goalTempo + small * (int)(Math.random()*3)-1;
		}
		if(Math.random()<cons) { 
			initialMeasure.setTempo(initialMeasure.tempo + 1 * goFaster);
		} else { 
			initialMeasure.setTempo(initialMeasure.tempo - 1 * goFaster);
		}

	}
	
	//Dummy Methods follow:
	
	public void changeMelody (){
		
		//Nothing here~
		
	}
	
	public void changeRhythm (){
		
		//Nothing here either....
		
	}
	// End Dummy Methods.
	public void changeToggle() {
		int randomNum=(int)(Math.random()*16);
		if(instruToggle[randomNum] = true) {
			instruToggle[randomNum] = false; 
		}else {
			instruToggle[randomNum] = true; 
		}
	}	
}
