package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantaction.ShootAction;

public class ShootCommand extends Command implements Buyable{
	
	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot";
	private static final String SHORTCUT = "s";
	private static final String HELP = "[s]hoot: shoot bullet";
	
	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	public boolean execute(Game game) {
		
		boolean can = false;
		if(game.canBuy(cost())) {
			this.buy(game);
			game.execute(new ShootAction());
			game.containerUpdate();
		}else {
			System.out.println("Monedas insuficientes");
		}
		return can;
	}

	@Override
	public int cost() {
		return 1;
	}
}