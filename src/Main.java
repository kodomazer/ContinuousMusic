import storage.*;
import run.*;


public class Main{

	public static void main(String[] args){
		Player play= new Player();
		
		play.changeCurrentMeasure(test());
		
		Generator gen = new Generator(test());
		System.out.println(1);
		playing thread1 = new playing();
		generation thread2 = new generation();
		System.out.println(1);
		thread2.run(gen,play);
		thread1.run(play);
		while(true){}//*/
		
	}
	public static Measure test(){
		Measure out=new Measure();
		out.setTempo(60);
		int[] key = new int[32];
		int[] tick= new int[32];
		for(int i=0;i<16;i++){
			key[2*i]=48+i;
			key[2*i+1]=48+i;
		}
		for (int i=0;i<16;i++){
			tick[i]=(i+1)/2;
		}
		
		System.out.print(3);
		for(int i=0;i<32;i++){
			if(i%2==0){
				out.addNote(new Note(tick[i],1,true,key[i],127));
				/*
				if(i%4==0){
					out.addNote(new Note(tick[i],9,true,48,127));
					out.addNote(new Note(tick[i],9,false,48,64));
				}*/
			}
			else
				out.addNote(new Note(tick[i],1,false,key[i],64));
		}
		return out;
	}
	
	
	
	public static class playing extends Thread{
		playing(){}
		public void run(Player play){
			try{
				Thread.sleep(400);
			}
			catch(InterruptedException a){
				for(int i=0;i<40;i++)Math.sqrt(i+3);
			}
			play.play();
		}
	}
	
	public static class generation extends Thread{
		generation(){}
		public void run(Generator gen,Player play){
			
			int num =0;
			int cap = 100;
			while(true){
				play.addToQueue(gen.iterate());
				if(num==cap)break;
				num++;
			}
		}
	}
	
	
	
	
}