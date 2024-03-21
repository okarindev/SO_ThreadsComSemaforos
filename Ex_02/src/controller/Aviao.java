package controller;
import java.lang.Thread;
import java.util.concurrent.Semaphore;

import view.Main;

public class Aviao extends Thread {

	private int id;
	private Semaphore pista;
	private String pistaName;
	
	public Aviao(int id){
		int pistaNumber = (int)(Math.random()*2);
		this.id = id;
		this.pista = Main.pistas[pistaNumber];
		this.pistaName = (pistaNumber == 1) ? "Sul" : "Norte";
	}
	
	public void run(){
		try {
			manobrar();
			afastar();
			taxiar();
			decolar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void manobrar() throws InterruptedException{
		int time = getMs(300,700);
		sleep(time);
		System.out.println("O aviao["+id+"] demorou "+time+"ms para manobrar!");
	}
	
	public void afastar() throws InterruptedException{
		int time = getMs(300,800);
		sleep(time);
		System.out.println("O aviao["+id+"] demorou "+time+"ms para se afastar!");
	}
	
	public void taxiar() throws InterruptedException{
		int time = getMs(500,1000);
		pista.acquire();
		sleep(time);
		System.out.println("O aviao["+id+"] demorou "+time+"ms para taxiar!");
	}
	
	public void decolar() throws InterruptedException{
		int time = getMs(600,800);
		sleep(time);
		System.out.println("O aviao["+id+"] demorou "+time+"ms para decolar na pista "+pistaName);
		pista.release();
	}
	
	public int getMs(int min, int max){
		return (int)(Math.random()*(max+1-min))+min;
	}
	
}
