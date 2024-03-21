package controller;

public class CorridaController extends Thread{

	private int points = 260;
	private int totalPlayers;
	private int indexPlayer = 0;
	private int[] players;
	
	public CorridaController(int total){
		this.totalPlayers = total;
		this.players = new int[total];
	}
	
	public void run() {
		while(totalPlayers > 0){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		showPlayers();
	} 
	
	public void showPlayers(){
		System.out.println("SHOW");
	}
	
	public void setPlayers(int points){
		totalPlayers--;
		players[indexPlayer++] = points;
	}
	
	public int getPoints(){
		if(points > 0){
			points -= 10;
		}
		return points;
	}
	
}
