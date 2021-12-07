package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class CommandExecuteException extends GameException {
	String message;
	Throwable cause;
	
	public CommandExecuteException(String msg, Throwable cause) {
		super(msg);
	}
}