package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;

public class SaveCommand extends Command {

	public final static String NAME = "Save";
	public final static String SHORTCUT = "v";
	public final static String DETAILS = "Sa[v]e";
	public final static String HELP = "sa[v]e <filename>: Save the state of the game to a file.";


	private String fileName;
	private final String fileExtension = ".txt";

	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		File file = new File("./" + fileName + fileExtension);
		 try {
			 if (!file.exists()) {
				 file.createNewFile();
				 }
			 FileWriter fw = new FileWriter(file);
			 BufferedWriter bw = new BufferedWriter(fw);
			 bw.write(game.posSertoString());
			 bw.close();
			 System.out.println("Game correctly save in: " + fileName + fileExtension);
			 return false;
			 }catch (IOException e) {
				 throw new CommandExecuteException("[ERROR]: File couldn't be created", null);
		    }
		 }
	
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		String[] comG = {commandWords[0]};
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 2) {
				fileName = commandWords[1];
				} else {
					throw new CommandParseException("Numero de parametros invalido para el comando save", null);
					}
			}
		return super.parse(comG);
		}
	}