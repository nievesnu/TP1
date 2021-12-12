package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class InvalidPositionException extends CommandExecuteException {

	public InvalidPositionException(String msg, GameException cause) {
		super(msg, cause);
	}

}