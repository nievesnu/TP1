package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class CommandExecuteException extends GameException {
	String message;
	
	public CommandExecuteException(String msg, GameException cause) {
		super(msg, cause);
	}
}