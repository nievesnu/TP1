package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;

public class CheatCommand extends Command{
	
	private static final String NAME = "cheat";
	private static final String DETAILS = "[1...5]";
	private static final String SHORTCUT = "1 2 3 4 5";
	private static final String HELP = "Cheat [1..5]: Removes all elements of last visible column, and adds an Advanced Object";
	private int num;
	
	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.clean();
		GameObjectGenerator.forceAdvanceObject(game, num, game.getVisibility() + game.getPlayer().getY() - 1);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
        if(NAME.equalsIgnoreCase(commandWords[0])) {
        	commandWords[0] = "Error";
        }else if(SHORTCUT.contains(commandWords[0])){
    		num = Integer.parseInt(commandWords[0]);
    		commandWords[0] = NAME;
        }
        return super.parse(commandWords);
    }
}