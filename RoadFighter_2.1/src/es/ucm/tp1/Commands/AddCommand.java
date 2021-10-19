package es.ucm.tp1.Commands;

import es.ucm.tp1.logic.Game;

public class AddCommand extends Command {
    
    Integer x;
    Integer y;
    Double frequency;

    public AddCommand() {
        super("add", "a", "Add", "");
    }

    @Override
    public boolean execute(Game game) {
        return game.tryToAddObject(this.x, this.y, frequency); 
    }

    /**
     * 
     */
    @Override
    public Command parse(String[] commandWords) {
        if(this.matchCommandName(commandWords[0]))
            if(commandWords.length<4){
                this.x = Integer.parseInt(commandWords[1]);
                this.y = Integer.parseInt(commandWords[2]);
                if(this.x != null && this.y != null)
                    return this;
            }
        return null;
    }
    
}