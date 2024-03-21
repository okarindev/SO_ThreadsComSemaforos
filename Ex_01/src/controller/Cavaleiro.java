package controller;

import view.Main;

public class Cavaleiro extends Thread {
	int id;
	int speedBoost = 0;
	int actualDistance = 0;
	int maxDistance = 100; //2000
	int door = -1;
	
	public Cavaleiro(int id){
		this.id = id;
	}
	
	public void run(){
		
		runningPlayer();
		String msg = (door > 0) ? "Ficou vivo!" : "Morreu brutalmente!";
		System.err.println("Cavaleiro["+id + "] " + msg);
		
	}

	
	public void runningPlayer(){
		while(checkDistance()){
			try {
				sleep(50);
				int step = (int)(Math.random()*(4-2+1))+2;
				actualDistance += (step+speedBoost);
				System.out.println("Cavaleiro["+id + "] " + actualDistance + "m boost:" + speedBoost);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}
	
	
	public boolean checkDistance(){
		if(actualDistance > 50 && Main.boost.getTorch()){
			speedBoost = 2;
		}else if(door == -1 && actualDistance > maxDistance) {
			door = Main.door.getDoor();
			maxDistance = (int)(Math.random() * 51-5)+25;
			actualDistance = 0;
		}else if((actualDistance > maxDistance) && (door != -1)){
			return false;
		}
		
		return true;
	}
	
	

}
