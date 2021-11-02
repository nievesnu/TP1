package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

//Comportamiento: No se mueve. El coche muere cuando choca contra él.
//Resistencia: 1 punto de resistencia 

public class Obstacle {
	
	static int obstacleCounter = 0; //La contabilización de cuántos obstáculos/coins hay se realizará desde la propia clase Coin o Obstacle utilizando atributos estáticos
	private int x, y, vida;
	private static final String SYMBOL = "░";
	public static final String INFO = null;
	Game game;
	
	public Obstacle(int x, int y, int vida) {
		obstacleCounter++;
		this.x = x;
		this.y = y;
		this.vida = vida;
	}
	
	//para que desde Game se pueda ver cuantos objetos hay
	static int getObstacleCounter() {
		return obstacleCounter;
	}
	
	public void receiveCollision() {
		this.vida = 0;
	}	
	
	//checkea si este obstaculo esta en la posicion que nos pasan por parametro
	public boolean isInPosition(int x, int y) {
		return (this.x == x && this.y == y); 	
	}	
	
	//devuelve el symbolo de obstaculo solo si esta  vivo
	public String toString() {
		String salida = "";
		if(this.vida > 0) {
			salida = SYMBOL;
		}
		return salida;
	}
	
	public int getObstacleVida() {
		return this.vida;
	}
	
	//pone el contador de obstaculos a 0
	public void reset() {
		obstacleCounter = 0;
	}

	public static Object getObstaclesCount() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
