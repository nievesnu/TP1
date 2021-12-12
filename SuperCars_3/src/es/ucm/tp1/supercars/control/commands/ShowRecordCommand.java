package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class ShowRecordCommand extends Command {

    private static final String NAME = "Record";
    private static final String DETAILS = "rec[o]rd";
    private static final String SHORTCUT = "o";
    private static final String HELP = "rec[o]rd: show level record";

    public ShowRecordCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
    	System.out.println(game.getLevel().name() + " record is: " + String.format("%.2f s", game.getRecord() / 1000.0));
        return false;
    }
}