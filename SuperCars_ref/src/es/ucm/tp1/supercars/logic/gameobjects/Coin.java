package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject{
	
	private static int  coinsCounter = 0;
	private static final String SYMBOL = "¢";
	public static final String INFO = null;
	
	public Coin(Game game, int x, int y) {
		super(game,x, y);
		this.symbol = SYMBOL;
	}
	
	public boolean isInPosition(int x, int y) {
		return (this.x == x && this.y == y); 
	}
	
	public int getCoinVida() {
		return this.health;
	}
	
	public void reset() {
		coinsCounter = 0;
	}

	public static int getCoinsCount() {
		return coinsCounter;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		this.health = 0;
		coinsCounter--;
		return true; //impacta = true
	}

	@Override
	public void onEnter() {
		coinsCounter++;		
	}

	@Override
	public void update() {		
	}

	@Override
	public void onDelete() {
		coinsCounter--;	
	}
}