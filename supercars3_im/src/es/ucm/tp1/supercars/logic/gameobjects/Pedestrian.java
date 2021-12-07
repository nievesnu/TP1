package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends GameObject{

	public static final String INFO = "[PEDESTRIAN] person crossing the road up and down";
	public boolean move;
	
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = "☺";
		this.move = false;
	}
	
	@Override
	public boolean doCollision() {
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		player.sumar(-player.getCoins());
		player.onDelete();
		this.onDelete();
		return false;
	}

	@Override
	public void onEnter() {
		this.health= 1;
		objectCounter++;
	}

	@Override
	public void update() {
		
		if (move) {
			this.x--;
		}else {
			this.x++;
		}
		
		if (move && this.x == 0) {
			this.move = false;
		} else if(!move && this.x == game.getRoadWidth() - 1){
			this.move = true;
		}
	}

	@Override
	public void onDelete() {
		this.health = 0;
		objectCounter--;
	}

	@Override
	public boolean receiveShoot(Player player) { //aqui uso el player
		player.sumar(-player.getCoins());
		onDelete();
		return true;
	}
}