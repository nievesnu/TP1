package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class CommandParseException extends GameException {
	
	public CommandParseException(String message) {
		super(message);
	}
	
	public CommandParseException() {
		super("Unknown command");
	}
}
