package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends GameObject{

	public static final String SYMBOL = "←";
	public static final Object INFO = null;
	
	public Truck(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = SYMBOL;
	}
	
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.onDelete();
		return true;
	}

	@Override
	public boolean receiveShoot(Player player) {
		this.onDelete();	
		return true;
	}

	@Override
	public void onEnter() {
		this.health = 1;
		objectCounter++;
	}

	@Override
	public void update() {
		this.y--;
	}

	@Override
	public void onDelete() {
		this.health = 0;	
		objectCounter--;
	}
}