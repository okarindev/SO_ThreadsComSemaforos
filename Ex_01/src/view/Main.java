package view;
import controller.Torch;
import controller.Stone;
import controller.Cavaleiro;
import controller.Door;

public class Main {

	public static Torch torch = new Torch();
	public static Stone stone = new Stone();
	public static Door door = new Door();
	
	public static void main(String[] args){
		
		for(int i = 0; i < 4; i++) {
			new Cavaleiro(i+1).start();
		}
		
	}
	
}
