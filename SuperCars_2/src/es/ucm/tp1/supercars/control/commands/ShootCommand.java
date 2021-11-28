package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class ShootCommand extends Command {
	
	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot";
	private static final String SHORTCUT = "s";
	private static final String HELP = "show this help";
	
	public ShootCommand() {
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

/*El player dispara una pared y le dan 5 monedas
 * Gasta 1 coin por disparo
 * los GameObject se actualizan\
 * los ciclos avanzan
 * se eliminan los objetos muertos*/
