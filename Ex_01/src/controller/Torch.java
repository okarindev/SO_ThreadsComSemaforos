package controller;

public class Torch {

	private int qtd = 1;
	
	public boolean getTorch(){
		return (qtd-- > 0);
	}
	
}
