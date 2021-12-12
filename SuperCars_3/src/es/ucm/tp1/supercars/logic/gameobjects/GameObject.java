package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	protected int x;
	protected int y;
	protected int health;
	protected String symbol;
	protected Game game;
	protected static int objectCounter;
	protected static int coinCounter;
	

	public GameObject(Game game, int x, int y){
		this.x = x;
		this.y = y;
		this.health = 1;
		this.game = game;
	}

	protected String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		String salida = "";
			if(this.health > 0) {
				salida = this.symbol;
			}
		return salida;		
	}
	
	public String posSertoString() {
		return this.toString() + " (" + this.getY() +  "," + this.getX() + ") ";
	}

	public boolean isInPosition(int x, int y) { //preguntar sobre si esto tiene que estar en todos los otroas objetos si ya esta aqui
		return this.x == x && this.y == y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public boolean isAlive() {
		boolean yes = true;
		if(health == 0) yes = false;
		return yes;
	}
	
	public static int getObjectCounter() {
		return objectCounter;
	}
	
	public static int getCoinCounter() {
		return coinCounter;
	}
	
	public boolean receiveExplosion() {
		return receiveShoot(game.getPlayer());
	}

	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();

	public void wave() {
		this.y++;
	}
}