package view;
import controller.Boost;
import controller.Cavaleiro;
import controller.Door;

public class Main {

	public static Boost boost = new Boost();
	public static Door door = new Door();
	
	public static void main(String[] args){
		
		for(int i = 0; i < 4; i++) {
			new Cavaleiro(i+1).start();
		}
		
	}
	
}
