package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class MoveDownCommand extends Command{
	
	private static final String NAME = "down";
	private static final String DETAILS = "go down";
	private static final String SHORTCUT = "a";
	private static final String HELP = "[a]: go down";
	
	public MoveDownCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

    @Override
    public boolean execute(Game game) {
    	game.getPlayer().doCollision();
    	game.goDown();
        game.update();
        game.getPlayer().doCollision();
        game.containerUpdate();
        return true;
    }

    @Override
    public Command parse(String[] commandWords) {
        if(this.matchCommandName(commandWords[0]) || commandWords[0].equals("a"))
        if(commandWords.length<2)
            return this;
        
        return null;
    }
}
