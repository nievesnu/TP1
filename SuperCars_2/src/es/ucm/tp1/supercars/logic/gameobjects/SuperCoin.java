package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends GameObject{
	
	//private static int  coinsCounter = 0;
	private static final String SYMBOL = "$";
	public static final String INFO = null;
	
	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = SYMBOL;
		
	}
	
	
	public static boolean hasSuperCoin() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean doCollision() {
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		this.health = 0;
		//coinsCounter =+ 100;
		return true; //impacta = true;
	}
	
	@Override
	public boolean receiveShoot(Player player) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void onEnter() {
	
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void onDelete() {
		
	}
}