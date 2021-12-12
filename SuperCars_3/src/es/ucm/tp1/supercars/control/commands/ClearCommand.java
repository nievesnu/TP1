package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class ClearCommand extends Command{

	private static final String NAME = "clear";
	private static final String DETAILS = "[c]lear";
	private static final String SHORTCUT = "0";
	private static final String HELP = "Clear [0]: Clears the road";
	
	public ClearCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.cleanAll();
		return true;
	}
	
	@Override
	public Command parse(String[] commandWords) throws CommandParseException{
		if(NAME.equalsIgnoreCase(commandWords[0]))	commandWords[0] = "Error";
		return super.parse(commandWords);
    }
}