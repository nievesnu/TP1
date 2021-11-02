package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.StringUtils;

public class HelpCommand extends Command {
	
	private static final String NAME = "help";
	private static final String DETAILS = "[h]elp";
	private static final String SHORTCUT = "h";
	private static final String HELP = "show this help";
	public HelpCommand() {
		
	super(NAME, SHORTCUT, DETAILS, HELP);
	}
	public boolean execute(Game game) {
	    System.out.println(Command.commandHelp());
	    return false;
	}
	
	public Command parse(String[] commandWords) {
	    if(this.matchCommandName(commandWords[0]))
	        if(commandWords.length<2)
	            return this;
	        
	    return null;
	}
}