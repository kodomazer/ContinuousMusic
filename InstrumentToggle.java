import Measure;
import Note;

public class InstruToggle{
  public static int randInt {
    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();
    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((15 - 0) + 1) + 0;
    
    return randomNum;
}

  public void toggle() {
    boolean postToggle
    instruArray[randomNnum] = postToggle;
    
    if(instruArray[randomNum] = True) {
      postToggle = False }
    else {
      postToggle = True }
    }
  
	public Measure iterate(Measure initialMeasure) {
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
	  postTempo = new Measure();
	  
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
  	          if(roll2<pMelody){
  	          	return ChangeMelody(postTempo);
  	          } else {
  	          	return ChangeRhythm(postTempo);
  	          }
  	     
	  
	  
	  
		
	}
}
