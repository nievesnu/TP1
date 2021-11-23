package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class CheatCommand extends Command{
	
	private static final String NAME = "cheat";
	private static final String DETAILS = "[1...5]";
	private static final String SHORTCUT = "1 2 3 4 5";
	private static final String HELP = "Cheat [1..5]: Removes all elements of last visible column, and adds an Advanced Object";
	
	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
        if(this.matchCommandName(commandWords[0]))
        if(commandWords.length<2)
            return this;
        
        return null;
    }
}
