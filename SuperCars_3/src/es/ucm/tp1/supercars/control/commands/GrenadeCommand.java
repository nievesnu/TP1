package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.control.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
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
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			if(!game.emptyPos(y + game.getPlayer().getY(), x)) {
				throw new CommandExecuteException(" ", new InvalidPositionException("[ERROR]: Posicion inválida", null));
			}else if (!game.insideLimits(y, x)) {
				throw new CommandExecuteException(" ", new InvalidPositionException("[ERROR]: Fuera del limite del tablero", null));
			}
			this.buy(game);
			game.forceAddObject(new Grenade (game, y + game.getPlayer().getY(), x )); //mirar atentamente
			game.containerUpdate();
			return true;
		}catch(NotEnoughCoinsException ne) {
			throw new CommandExecuteException(null, ne);
			}
		}

	@Override
	public Command parse (String[] commandWords) throws CommandParseException  {
		String[] comG = {commandWords[0]};
        if(this.matchCommandName(commandWords[0])) {
        	if(commandWords.length == 3) {
        		try {
        			y = Integer.parseInt(commandWords[1]); // mis x son sus y por ello esta intercambiado para la llamada del comando
        			x = Integer.parseInt(commandWords[2]);
				} catch (NumberFormatException e) {
					throw new CommandParseException("[ERROR]: Pon un número", null);
				} 		
        	}else{
        		throw new CommandParseException(incorrectNumberOfArgsMsg, null);
        	}
        }
        return super.parseNoParamsCommand(comG);
    }

	@Override
	public int cost() {
		return 3;
	}
}