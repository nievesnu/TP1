package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class InputOutputRecordException extends CommandExecuteException {

	public InputOutputRecordException(String msg, GameException cause) {
		super(msg, cause);
	}
}