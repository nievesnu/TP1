package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Grenade extends GameObject{

	public static final Object INFO = null;
	private static final String SYMBOL = "ð";
	
	public Grenade(Game game, int x, int y) {
		super(game,x, y);
		this.symbol = SYMBOL;
	}

	public boolean isInPosition(int x, int y) {
		return (this.x == x && this.y == y); 
	}
	
	@Override
	public boolean doCollision() {
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
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub	
	}

	@Override
	public boolean receiveShoot(Player player) {
		return false;
	}
	
	/*El código del explosión lo podríamos añadir directamente en el onDelete de la granada,
	pero lo mejor es crear una nueva Instant Action que encapsule el código. Así que cuando la
	granada explota se crea y ejecuta una Explosion Action. */

}