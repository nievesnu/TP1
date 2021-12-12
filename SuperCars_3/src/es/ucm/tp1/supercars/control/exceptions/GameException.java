package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class GameException extends Throwable{
	String message;
	
	public GameException(String msg, GameException c) {
		if (c != null) {
			this.message = c.GameExc() + "\n" + msg;
		}else {
			this.message = msg;
		}
	}
	
	public String GameExc() {
		return this.message;
	}
}