package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

//Comportamiento: Avanza, va hacia arriba o va hacia abajo.
//Velocidad: 1 casilla por turno.
//Resistencia: Muere autom�ticamente con una colisi�n.

public class Player extends GameObject{
	private boolean crashed;
	private int coins;
	private int x;
	private int y;
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
	
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
			if (other != null) {
				return other.receiveCollision (this);
			}
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
}