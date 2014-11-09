/** This takes a measure and returns the next measure. 
*(Randomly chooses which change to make and calls appropriate method?)
* Relies on:  ChangeTempo(measure) change in... bpm?
*             ChangeToggle(measure), toggle a random instrument 
*             ChangeMelody(measure), change some part of the melody
*             ChangeRhythm(measure), reorganize the same melody into a different rhythm.
*/

Include Measure

public class RandomChange{
	public Measure random(Measure initialMeasure) {
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
	  roll1 = Math.rand();
	  roll2 = Math.rand();
	  
  	  if(roll1<pTempo){
  	      postTempo = ChangeTempo(initialMeasure);
  	  } else { 
  	      postTempo = initialMeasure;
  	  }
  	  }
  	
  	  if(roll2<pToggle){
  	      return ChangeToggle(postTempo);
  	  } else { 
  	          roll2 =  roll2 - pToggle;
  	     
	  
	  
	  
		
	}
}
