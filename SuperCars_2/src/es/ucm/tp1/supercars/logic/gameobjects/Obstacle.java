package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

//Comportamiento: No se mueve. El coche muere cuando choca contra Ã©l.
//Resistencia: 1 punto de resistencia 

public class Obstacle extends GameObject{
	
	static int obstacleCounter = 0; //La contabilizaciÃ³n de cuÃ¡ntos obstÃ¡culos/coins hay se realizarÃ¡ desde la propia clase Coin o Obstacle utilizando atributos estÃ¡ticos
	private static final String SYMBOL = "░";
	public static final String INFO = null;
	Game game;
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		obstacleCounter++;
		this.symbol = SYMBOL;
		
	}
	
	//para que desde Game se pueda ver cuantos objetos hay
	public static int getObstacleCounter() {
		return obstacleCounter;
	}
	
	public void receiveCollision() {
		this.health = 0;
	}	
	
	//checkea si este obstaculo esta en la posicion que nos pasan por parametro
	public boolean isInPosition(int x, int y) {
		return (this.x == x && this.y == y); 	
	}	
	
	//devuelve el symbolo de obstaculo solo si esta  vivo 
	/*public String toString() {
		String salida = "";
		if(this.health > 0) {
			salida = SYMBOL;
		}
		return salida; mirar si esto se puede seguir haciendo o es menos eficiente
	}*/
	
	public int getObstacleVida() {
		return this.health;
	}
	
	//pone el contador de obstaculos a 0
	public void reset() {
		obstacleCounter = 0;
	}

	public static Object getObstaclesCount() {
		return obstacleCounter;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		this.health = 0;
		obstacleCounter--;
		return true;
	}

	@Override
	public void onEnter() {
		obstacleCounter++;		
	}

	@Override
	public void update() {
		}

	@Override
	public void onDelete() {
		obstacleCounter--;
	}

	@Override
	public boolean receiveShoot(Player player) {
		return false;
	}	
}
