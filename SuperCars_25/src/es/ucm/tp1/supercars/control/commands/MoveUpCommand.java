package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class MoveUpCommand extends Command{
	private static final String NAME = "up";
	private static final String DETAILS = "go up";
	private static final String SHORTCUT = "q";
	private static final String HELP = "[q]: go up";
	
	public MoveUpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

    @Override
    public boolean execute(Game game) {
    	game.getPlayer().doCollision();
    	game.goUp();
        game.update();
        game.getPlayer().doCollision();
        game.containerUpdate();
        return true;
    }

    @Override
    public Command parse(String[] commandWords) {
        if(this.matchCommandName(commandWords[0]) || commandWords[0].equals("q"))
        if(commandWords.length<2)
            return this;
        
        return null;
    }
}