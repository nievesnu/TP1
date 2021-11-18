package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Truck extends GameObject{

	public boolean crashed;
	public static final String SYMBOL = "←";
	public static final Object INFO = null;
	
	public Truck(Game game, int x, int y) {
		super(game, x, y);
		this.crashed = false;
		this.symbol = SYMBOL;
	}
	
	public boolean isCrashed() {
		return crashed;
	}
	
	public void crash() {
		this.crashed = true;
	}
	
	public boolean doCollision() {
		GameObject other = game.getObjectInPosition(x, y);
			if (other = game.getPlayer()) {
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
	public boolean receiveShoot(Player player) {
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
	

}
