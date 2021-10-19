package es.ucm.tp1.Commands;

import es.ucm.tp1.logic.Game;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit", "e", "exit :", "");
    }

    @Override
    public boolean execute(Game game) {
        game.setExit(true);
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