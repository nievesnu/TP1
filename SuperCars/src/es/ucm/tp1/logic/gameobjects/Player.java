package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

//Comportamiento: Avanza, va hacia arriba o va hacia abajo.
//Velocidad: 1 casilla por turno.
//Resistencia: Muere autom�ticamente con una colisi�n.

public class Player {
	private boolean crashed;
	private int coins;
	private int x;
	private int y;
	private static final String CAR_ALIVE = ">";
	private static final String CAR_DEAD = "@"; //alive 
	private Game game; 
	
	public Player (Game game, int x, int y, int coins) {
		this.x = x;
		this.y = y;
		this.coins = coins;
		this.crashed = false;
		this.game = game;
	}
	
	public boolean isCrashed() {
		return crashed;
	}
	
	public void crash() {
		this.crashed = true;
	}
	
	public void sumar() {
		this.coins++;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Game getGame() {
		return game;
	}
	
	public String toString() {
		String car = CAR_ALIVE;
		if(crashed) {
			car = CAR_DEAD;
		}
		return car;
	}

	public boolean isInPosition(int x , int y) {
		return this.x == x && this.y == y;	
	}
	
	public int getCoins(){
		return coins;
	}
	
	public void playerUp() {
		this.x--;
	}
	
	public void playerDown() {
		this.x++;
	}

	public void update() {
		this.y++; //y++	
	}
}