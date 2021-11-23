package es.ucm.tp1.supercars.control.commands;

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
	   
		return true;
	}
	
	@Override
	public Command parse(String[] commandWords) {
        if(this.matchCommandName(commandWords[0]))
        if(commandWords.length<2)
            return this;
        
        return null;
    }
}