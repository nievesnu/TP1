package es.ucm.tp1.supercars.logic.instantaction;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ShootAction implements InstantAction {
	@Override
	public void execute(Game game) {
		GameObject o;
		boolean end = false;
		int i = 0;
		while(i<game.getVisibility() && !end) {
			o = game.containerObj(game.getPlayer().getX(), game.getPlayer().getY() + i);
			if(o!= null) {
				end = o.receiveShoot(game.getPlayer());
			} i++;
		}
	}
}