package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class MoveUpCommand extends Command{
	public MoveUpCommand() {
        super("up", "q", "go up", "");
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