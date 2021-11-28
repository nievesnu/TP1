package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantaction.WaveAction;

public class WaveCommand extends Command implements Buyable{
	
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "Do wave";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		boolean can = false;
		if(game.canBuy(cost())) {
			this.buy(game);
			game.execute(new WaveAction());
			game.containerUpdate();
			can = true;
		}else {
			System.out.println("Monedas insuficientes");
		}
		return can;
	}

	@Override
	public int cost() {
		return 5;
	}
}