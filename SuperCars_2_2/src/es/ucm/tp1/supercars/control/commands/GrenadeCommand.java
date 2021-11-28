package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable{

	private static final String NAME = "grenade";
	private static final String DETAILS = "[g]renade";
	private static final String SHORTCUT = "g";
	private static final String HELP = "[g]renade <x> <y>: add a grenade in position x, y";
	private int x, y;
	
	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		boolean can = false;
		if(game.canBuy(cost())) {
			this.buy(game);
			if(game.emptyPos(x, y)) {
				can = true;
				game.forceAddObject(new Grenade (game, x, y + game.getPlayer().getY() ));
				game.containerUpdate();
			}else {
				System.out.println("Error: posicion no vacia");
				can = false;
			}
		}else {
			System.out.println("Monedas insuficientes");
		}
		return can;
	}

	@Override
	public Command parse(String[] commandWords) {
		String[] comG = {commandWords[0]};
        if(this.matchCommandName(commandWords[0])) {
        	if(commandWords.length == 3) {
        		y = Integer.parseInt(commandWords[1]); // mis x son sus y por ello esta intercambiado para la llamada del comando
        		x = Integer.parseInt(commandWords[2]);
        	} else {
        		comG[0]="No es correcto";
        	}
        }
        return super.parse(comG);
    }

	@Override
	public int cost() {
		return 3;
	}
}