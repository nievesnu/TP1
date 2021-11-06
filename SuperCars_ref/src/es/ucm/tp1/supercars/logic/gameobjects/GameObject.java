package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	protected int x;
	protected int y;
	protected int health;
	protected String symbol;
	protected Game game;

	public GameObject(int x, int y, int health, String symbol, Game game){
		this.x = x;
		this.y = y;
		this.health = health;
		this.symbol = symbol;
		this.game = game;
	}

	protected String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}

		return "";
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public boolean isAlive() {
		boolean yes = false;
		if(health == 1) yes = true;
			return yes;
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();


	// TODO add your code

}