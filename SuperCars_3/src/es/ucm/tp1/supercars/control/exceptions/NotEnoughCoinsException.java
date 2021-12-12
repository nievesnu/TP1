package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class NotEnoughCoinsException extends CommandExecuteException {
	public NotEnoughCoinsException(String msg, GameException cause) {
		super(msg, cause);
	}
}