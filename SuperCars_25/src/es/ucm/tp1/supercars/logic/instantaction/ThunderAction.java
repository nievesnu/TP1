package es.ucm.tp1.supercars.logic.instantaction;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ThunderAction implements InstantAction {

	@Override
	public void execute(Game game) {
		int x = game.getRandomLane(), y =  (int) (game.getRandomNumber()* game.getVisibility());
		GameObject o = game.containerObj(x, y = game.getPlayer().getY());
		System.out.print("Thunder hit: " + y + " , " + x + "\n");
		if (o != null && !o.isAlive()) {
			System.out.print("=> " + o.toString() + " hit");
			o.onDelete();
		}
		System.out.println();
	}
}