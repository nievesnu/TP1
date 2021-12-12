package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class CommandParseException extends GameException {
	
	public CommandParseException(String message, GameException causa) {
		super(message, causa);
	}
}