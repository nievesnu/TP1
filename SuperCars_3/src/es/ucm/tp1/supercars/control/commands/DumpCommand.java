package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

import java.io.*;

public class DumpCommand extends Command {

	private static final String NAME = "dump";
	private static final String DETAILS = "[d]ump";
	private static final String SHORTCUT = "d";
	private static final String HELP = "[d]ump <filename>: Shows the content of a saved file";
	
	private String archivo;
	
	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try {
			String cadena;
			FileReader f = new FileReader("./" + archivo + ".txt");
			BufferedReader b = new BufferedReader(f);
			while((cadena = b.readLine())!=null) {
				System.out.println(cadena);
			}
			b.close();
		}catch(IOException e) { //engloba las de in/out y filenotfound esta dentro
			throw new CommandExecuteException("[ERROR]: the file you are looking for could not be found", null);
		}
		return false;
	}
	
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		String[] comG = {commandWords[0]};
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 2) {
				archivo = commandWords[1];
				} else {
					throw new CommandParseException("Numero de parametros invalido para el comando dump", null);
				}
		}
		return super.parse(comG);
	}
}