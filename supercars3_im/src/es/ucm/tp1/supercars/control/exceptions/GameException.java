package es.ucm.tp1.supercars.control.exceptions;

@SuppressWarnings("serial")
public class GameException extends Throwable{
	String message;
	
	public GameException(String msg) {
		this.message = msg;
	}
	
	public String GameExc() {
		return this.message;
	}
}