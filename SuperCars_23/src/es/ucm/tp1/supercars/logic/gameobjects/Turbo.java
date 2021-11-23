package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo  extends GameObject{
	
	private static final String SYMBOL = ">>>";
	public static final String INFO = "[TURBO] pushes the car 3 columns";
;
	
	public Turbo(Game game, int x, int y) {
		super(game, x, y);
	}
	
	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean receiveShoot(Player player) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	
	/*Si el coche cae sobre otro objeto entonces se quedan en la misma casilla, y al principio del
	ciclo siguiente, se ejecuta la colisi�n (chocar con obst�culo, coger monedas, etc...). Esto
	ser� necesario tambi�n para las extensions de Truck y Pedestrian. Sin embargo el coche no
	colisiona con los objetos intermedios, es como si los saltara.
	
		Para conseguir este comportamiento, tendr�s que chequear las colisiones dos veces en
	cada movimiento del player , una antes de moverse y otra despu�s de moverse.
		Para facilitar la depuraci�n pintamos el coche y el objeto en la misma casilla. Tendr�s
	que modificar el pintado del tablero para a�adir esta funcionalidad. A partir de ahora:
		Pintaremos todos los objetos que est�n en la misma posici�n de la carretera.
	Siempre ir� primero el coche, y los GameObjects por el orden que se introdujeron
	en el juego.
	
	*/
}
