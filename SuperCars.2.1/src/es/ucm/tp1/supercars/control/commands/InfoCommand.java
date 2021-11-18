package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
//import es.ucm.tp1.supercars.utils.StringUtils;
//import es.ucm.tp1.supercars.view.GamePrinter;

public class InfoCommand extends Command {
	private static final String NAME = "info";

	private static final String DETAILS = "[i]nfo";

	private static final String SHORTCUT = "i";

	private static final String HELP = "prints gameobject info";

	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
	    System.out.println(Command.commandInfo());
	    return false;
	}
	
	public Command parse(String[] commandWords) {
	    if(this.matchCommandName(commandWords[0]))
	        if(commandWords.length<2)
	            return this;
	        
	    return null;
	}
}