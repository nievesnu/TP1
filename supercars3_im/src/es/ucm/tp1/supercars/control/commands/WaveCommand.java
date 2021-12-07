package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.control.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.instantaction.WaveAction;

public class WaveCommand extends Command implements Buyable{
	
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "Do wave";

	private String excpt = "Failed to shoot wave";
	
	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		if(game.canBuy(cost())) {
			try {
				this.buy(game);
				game.execute(new WaveAction());
				game.containerUpdate();
			} catch (NotEnoughCoinsException e) {
				throw new CommandExecuteException(excpt, e);
			}
		}
		return true;
	}

	@Override
	public int cost() {
		return 5;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		return null;
	}
}