package controller;

import view.Main;

public class Player extends Thread {

	
	int actualDistance = 0;
	int maxDistance = 300;
	int points = 0;
	int id;
	
	public Player(int id){
		this.id = id;
	}
	
	public void run(){
		try {
			correr();
			alvo();
			ciclismo();
			points += Main.corrida.getPoints();
			Main.corrida.setPlayers(points);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void correr() throws InterruptedException{
		while(actualDistance < maxDistance){
			sleep(30);
			actualDistance += getNumber(20, 25);
			System.out.println("Atleta["+id+"] corrida " + actualDistance + "m");
		}
	}
	
	public void alvo() throws InterruptedException{
		Main.tiroAlvo.acquire();
		for(int i = 0; i < 3; i++){
			int extraPoints = getNumber(0, 10);
			sleep(getNumber(500, 3000));
			points += extraPoints;
			System.out.println("Atleta["+id+"] pontuou " + extraPoints + " pontos");
		}
		Main.tiroAlvo.release();
	}
	
	public void ciclismo() throws InterruptedException{
		actualDistance = 0;
		maxDistance = 500;
		while(actualDistance < maxDistance){
			sleep(30);
			actualDistance += getNumber(20, 25);
			System.out.println("Atleta["+id+"] pedalou " + actualDistance+"m");
		}
	}
	
	public int getNumber(int min, int max){
		return (int)(Math.random()*(max+1-min))+min;
	}
	
}
