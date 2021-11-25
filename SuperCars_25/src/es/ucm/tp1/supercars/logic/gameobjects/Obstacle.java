package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

//Comportamiento: No se mueve. El coche muere cuando choca contra Ã©l.
//Resistencia: 1 punto de resistencia 

public class Obstacle extends GameObject{
	
	private static final String SYMBOL = "░";
	public static final String INFO = "[Obstacle] hits car.";
	Game game;
	
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = SYMBOL;
	}
	
	//para que desde Game se pueda ver cuantos objetos hay
	public static int getObstacleCounter() {
		return objectCounter;
	}
	
	public void receiveCollision() {
		this.health = 0;
	}	
	
	public int getObstacleVida() {
		return this.health;
	}
	
	//pone el contador de obstaculos a 0
	public static void reset() {
		objectCounter = 0;
	}

	public static Object getObstaclesCount() {
		return objectCounter;
	}

	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		this.onDelete();
		objectCounter--;
		return true;
	}

	@Override
	public void onEnter() {
		this.health = 1;
		objectCounter++;		
	}

	@Override
	public void update() {
		}

	@Override
	public void onDelete() {
		this.health = 0;
		objectCounter--;
	}

	@Override
	public boolean receiveShoot(Player player) {
		this.onDelete();
		return true;
	}	
}