package es.ucm.tp1.supercars.logic.instantaction;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;

public class WaveAction implements InstantAction {

	@Override
	public void execute(Game game) {
		Collider o;
		for (int i = game.getVisibility() - 1; i >=0; i--) {
			for (int j = game.getRoadWidth() - 1; j >=0; j--) {
			o = game.containerObj(j, i + game.getPlayer().getY());
				if (o!=null &&  game.containerObj(j, i + game.getPlayer().getY() + 1) == null){
					o.wave();
				}
			}
		}
	}
}