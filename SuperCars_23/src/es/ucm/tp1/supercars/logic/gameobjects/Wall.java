package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends GameObject{

	public static final String INFO = "[WALL] hard obstacle";
	
	public Wall(Game game, int x, int y) {
		super(game,x, y);
	}

	
	public String toString(){
		String str = "";
		if(this.health == 3){
			str = "█";
			}else if(this.health == 2) {
			str = "▒";
			}else if(this.health == 1) {
				str = "░";
			}
		return str;
	}
	
	public int getWallVida() {
		return this.health;
	}
	
	public void reset() {
		onEnter();
	}
 
	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		this.health--;
		return true; //impacta = true
	}

	@Override
	public void onEnter() {	
		this.health = 3;
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
		this.health = 0;
		game.getPlayer().sumar(5);
	}
	
	public void gotHit() {
		health = health -1;
	}
	
	public boolean receiveExplosion() {
		onDelete();
		return true;
	}

	@Override
	public boolean receiveShoot(Player player) {
		this.health--;
		if(this.health == 0) onDelete();
		return true;
	}
}
