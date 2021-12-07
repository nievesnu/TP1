package es.ucm.tp1.supercars.control.commands;

import java.io.IOException;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.utils.StringUtils;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;

public class SaveCommand extends Command {

	public final static String NAME = "Save";
	public final static String SHORTCUT = "[S]ave";
	public final static String DETAILS = " ";
	public final static String HELP = "<filename>: Save the state of the game to a file.";


	private String fileName;
	private final String fileExtension = ".dat";

	public SaveCommand(String fileName) {
		super(NAME, SHORTCUT, DETAILS, HELP);
		this.fileName = fileName;
	}

	@Override
	public Command parse(String[] comando) throws CommandParseException {
		Command c = null;

		if ((comando[0].equalsIgnoreCase(NAME) || comando[0].equalsIgnoreCase(NAME.substring(0, 1)))) {

			if (comando.length == 2) {
				c = new SaveCommand(comando[1]);
			} else {
				throw new CommandParseException("Numero de parametros invalido para el comando save");
			}
		}

		return c;
	}

	public boolean execute(Game game) throws CommandExecuteException {
		if (StringUtils.isValidFilename(fileName)) {
			BufferedWriter bw = null;
			try {
				if (!StringUtils.fileExists(fileName)) {

					System.out.println("Se va a crear un nuevo fichero");

					bw = new BufferedWriter(new FileWriter(fileName + fileExtension));

					bw.write(cabecera);
					bw.newLine();
					bw.newLine();
					bw.write(game.store());

				}

				else {
					System.out.println("Ya existe un fichero con este nombre, la partida guardada se perdera");

					bw = new BufferedWriter(new FileWriter(fileName + fileExtension));

					bw.write(cabecera);
					bw.newLine();
					bw.newLine();
					bw.write(game.store());
				}

				System.out.println("Game successfully saved in file " + fileName + ".dat. Use the load command to reload it");

			} catch (Exception e) {
				//System.err.println(e.getClass() + " " + e.getMessage());

			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			throw new CommandExecuteException("Invalid filename: " + fileName);
		}
		return false;

	} 
	
	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}
