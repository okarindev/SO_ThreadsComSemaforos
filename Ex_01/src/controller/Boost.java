package controller;

public class Boost {

	private int qtd = 1;
	
	public boolean getTorch(){
		return (qtd-- > 0);
	}
	
}
