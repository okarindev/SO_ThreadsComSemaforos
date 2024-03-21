package controller;

public class Door {

	private int[] death = new int[4];
	private int doorIndex = 0;
	
	public Door(){
		for(int i = 0; i < 4; i++){
			death[i] = 0;
		}
		death[(int)(Math.random()*4)] = 1;
	}
	
	public int getDoor(){
		return death[doorIndex++];
	}
	
}
