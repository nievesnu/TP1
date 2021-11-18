package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

//Comportamiento: Avanza, va hacia arriba o va hacia abajo.
//Velocidad: 1 casilla por turno.
//Resistencia: Muere autom�ticamente con una colisi�n.

public class Player extends GameObject{
	private boolean crashed;
	private int coins;
	private static final String CAR_ALIVE = ">";
	private static final String CAR_DEAD = "@"; //alive 
	private Game game; 
	
	public Player (Game game, int x, int y) {
		super(game,x, y);
		this.coins = 5;///luego cambiar a 0
		this.crashed = false;
		this.game = game;
		this.symbol = CAR_ALIVE;
	}
	
	public boolean isCrashed() {
		return crashed;
	}
	
	public void crash() {
		this.crashed = true;
	}
	
	public void sumar(int c) {
		this.coins+= c;
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
		this.y++;
	}
	
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
			if (other != null) {
				return other.receiveCollision (this);
			}
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		return false;
	}

	@Override
	public void onEnter() {
		this.health = 1;
	}

	@Override
	public void onDelete() {
		this.health = 0;
	}

	@Override
	public boolean receiveShoot(Player player) {
		return false;
	}
}