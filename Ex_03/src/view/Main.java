package view;

import java.util.concurrent.Semaphore;

import controller.CorridaController;
import controller.Player;

public class Main {
	
	private static int totalPlayers = 3;
	public static Semaphore tiroAlvo = new Semaphore(1);
	public static CorridaController corrida = new CorridaController(totalPlayers);
	
	public static void main(String[] args){

		for(int i = 0; i < totalPlayers; i++){
			new Player(i+1).start();
		}
		
	}

}
