package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerializer;

public class SerializeCommand extends Command {
	private static final String NAME = "serialized";
	private static final String DETAILS = "[z]";
	private static final String SHORTCUT = "z";
	private static final String HELP = "seriali[z]e: Serializes the board.";
	private GameSerializer GS;
	
	public SerializeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		GS = new GameSerializer(game);
		System.out.println(GS.getSerInfo());
		return false;
	}
}