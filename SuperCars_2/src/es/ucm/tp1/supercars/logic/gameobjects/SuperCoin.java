package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends GameObject{
	
	private static int  superValue = 1000;
	private static final String SYMBOL = "$";
	private static boolean hasIt = false;
	public static final String INFO = null;
	
	
	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = SYMBOL;		
	}	
	
	public static boolean hasSuperCoin() {
		return hasIt;
	}
	
	@Override
	public boolean doCollision() {
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		this.health = 0;
		player.sumar(1000);
		return true; //impacta = true;
	}
	
	@Override
	public boolean receiveShoot(Player player) {
		return false;
	}
	
	@Override
	public void onEnter() {
		hasIt = true;
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void onDelete() {
		hasIt = false;
	}
}