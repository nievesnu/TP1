package es.ucm.tp1.Commands;

import es.ucm.tp1.logic.Game;

public class UpdateCommand extends Command{
	  public UpdateCommand() {
	        super("update", "u", "update", "");
	    }

	    @Override
	    public boolean execute(Game game) {
	        game.update();
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
