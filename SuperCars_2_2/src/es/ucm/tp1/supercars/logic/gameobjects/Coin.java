package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject{
	
	private static final String SYMBOL = "¢";
	public static final String INFO = "[Coin] gives 1 coin to the player";
	
	public Coin(Game game, int x, int y) {
		super(game,x, y);
		this.symbol = SYMBOL;
	}
	
	public int getCoinVida() {
		return this.health;
	}
	
	public static void reset() {
		coinCounter = 0;
	}

	public static int getCoinsCount() {
		return coinCounter;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.sumar(1);
		this.onDelete();
		return true; //impacta = true
	}

	@Override
	public void onEnter() {
		this.health = 1;
		coinCounter++;
	}

	@Override
	public void update() {		
	}

	@Override
	public void onDelete() {
		this.health = 0;
		coinCounter--;	
	}

	@Override
	public boolean receiveShoot(Player player) {
		return false;
	}
}