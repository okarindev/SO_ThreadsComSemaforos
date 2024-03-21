package controller;

public class Stone {

	private int qtd = 1;
	
	public boolean getStone(){
		return (qtd-- > 0);
	}
	
}
