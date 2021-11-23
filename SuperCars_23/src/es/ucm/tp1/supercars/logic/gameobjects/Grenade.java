package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantaction.ExplosionAction;

public class Grenade extends GameObject{

	public static final String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around";
	private static final String SYMBOL = "ð";
	
	
	public Grenade(Game game, int x, int y) {
		super(game,x, y);
		this.symbol = SYMBOL;
		this.health = 4;
	}
	
	public String toString(){
		return "ð[" + this.health + "]";
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
	}

	@Override
	public void update() {
		health--;
		if(health == 0) {
			onDelete();
		}
	}

	@Override
	public void onDelete() {
		game.execute(new ExplosionAction(x, y));		
	}

	@Override
	public boolean receiveShoot(Player player) {
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}
	
	/*El código del explosión lo podríamos añadir directamente en el onDelete de la granada,
	pero lo mejor es crear una nueva Instant Action que encapsule el código. Así que cuando la
	granada explota se crea y ejecuta una Explosion Action. */

}