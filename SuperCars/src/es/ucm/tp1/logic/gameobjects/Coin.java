package es.ucm.tp1.logic.gameobjects;

public class Coin {
	
	static int  coinsCounter = 0;
	private int x, y, vida;
	private static final String SYMBOL = "¢";
	
	public Coin(int x, int y, int vida) {
		coinsCounter++;
		this.x = x;
		this.y = y;
		this.vida = vida;  
	
	}
	
	public void receiveCollision() {
		this.vida = 0;
		coinsCounter--;
	}
	
	public boolean isInPosition(int x, int y) {
		return (this.x == x && this.y == y); 
	}
	
	static int getcoinsCounter() {
		return coinsCounter;
	}
	
	public int getCoinVida() {
		return this.vida;
	}
	
	public String toString() {
		String salida = "";
		if(this.vida > 0) {
			salida = SYMBOL;
		}
		return salida;
	}	
	
	public void reset() {
		coinsCounter = 0;
	}
}
