package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command {

	private static final String NAME = "reset";
	private static final String DETAILS = "[r]eset";
	private static final String SHORTCUT = "r";
	private static final String HELP = "show this help";
	private Level level = null;
	private long seed;
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
    @Override
    public boolean execute(Game game) {
        game.reset(level, seed);
        return true;
    }

    @Override
    public Command parse(String[] commandWords) {
    	
    	String[] comR = {commandWords[0]};
    	
        if(this.matchCommandName(commandWords[0]))
        	
        if(commandWords.length == 3) {
        	level = Level.valueOfIgnoreCase(commandWords[1]);
        	seed = Long.parseLong(commandWords[2]);
        }else if(commandWords.length!=1) {
        	comR[0] = "Error de argumentos";
        }
        return super.parse(comR);
    }
}