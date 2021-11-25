package es.ucm.tp1.supercars.logic.instantaction;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ExplosionAction implements InstantAction {

	private int x, y;
	
	public ExplosionAction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void execute(Game game) {
		GameObject o = null;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				o = game.containerObj(i + x, j + game.getPlayer().getY() + y );
				if(o!=null) {
					o.receiveExplosion();
				}
			}
		}
	}
}