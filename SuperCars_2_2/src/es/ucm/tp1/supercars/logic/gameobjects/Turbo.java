package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo  extends GameObject{
	
	private static final String SYMBOL = ">>>";
	public static final String INFO = "[TURBO] pushes the car 3 columns";
	
	public Turbo(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = SYMBOL;
	}
	
	@Override
	public boolean doCollision() {
		return false;
	}
	@Override
	public boolean receiveCollision(Player player) {
		player.jump(3);
		this.onDelete();
		return true;
	}
	@Override
	public boolean receiveShoot(Player player) {
		return false;
	}
	@Override
	public void onEnter() {
		this.health = 1;		
	}
	@Override
	public void update() {
	}
	@Override
	public void onDelete() {
		this.health = 0;
	}
}