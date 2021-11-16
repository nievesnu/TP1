package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends GameObject{

	//private static final String SYMBOL;
	
	public Wall(Game game, int x, int y) {
		super(game,x, y);
		this.health = 3;
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
		this.health = 3;
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
	}

	@Override
	public void update() {		
	}

	@Override
	public void onDelete() {
		
	}
	public void gotHit() {
		health = health -1;
	}


	@Override
	public boolean receiveShoot(Player player) {
		return true;
	}
}
