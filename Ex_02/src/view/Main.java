package view;
import java.util.concurrent.Semaphore;
import controller.Aviao;

public class Main {

	private static Semaphore pistaNorte = new Semaphore(1);
	private static Semaphore pistaSul = new Semaphore(1);
	public static Semaphore[] pistas = {pistaNorte,pistaSul};
	
	public static void main(String[] args) {
		for(int i = 0; i < 12; i++) {
			new Aviao(i+1).start();
		}
	}

}
