package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class UpdateCommand extends Command {
	private static final String NAME = "update";
	private static final String DETAILS = "update";
	private static final String SHORTCUT = "n";
	private static final String HELP = "[n]one | []: update";
	
		public UpdateCommand() {
			super(NAME, SHORTCUT, DETAILS, HELP);
		}
	    @Override
	    public boolean execute(Game game) {
	    	game.getPlayer().doCollision();
	        game.update();
	        game.getPlayer().doCollision();
	        game.containerUpdate();
	        return true;
	    }

	    @Override
	    public Command parse(String[] commandWords) {
	        if(this.matchCommandName(commandWords[0]) || commandWords[0].equals(""))
	        if(commandWords.length<2)
	            return this;
	        return null;
	    }
}