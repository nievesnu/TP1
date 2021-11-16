package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.Pedestrian;
import es.ucm.tp1.supercars.logic.gameobjects.SuperCoin;
import es.ucm.tp1.supercars.logic.gameobjects.Truck;
import es.ucm.tp1.supercars.logic.gameobjects.Turbo;
import es.ucm.tp1.supercars.logic.gameobjects.Wall;

// TODO add your imports

public class GameObjectGenerator {
	
	public static void generateGameObjects(Game game, Level level) {

		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
			game.tryToAddObject(new Obstacle(game, game.getRandomLane(), x ), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game,game.getRandomLane(), x), level.getCoinFrequency());
		}
	}

	public static void reset(Level level) {
		// TODO add your code
	}

	public static void generateRuntimeObjects(Game game) {
		// TODO add your code
	}
	
	public static void forceAdvanceObject(Game game, int id, int x) {
		GameObject o = null;
		switch (id) {
		case 1:
			o = new Wall(game, x, game.getRandomLane());
			break;
		case 2:
			o = new Turbo(game, x, game.getRandomLane());
			break;
		case 3:
			o = new SuperCoin(game, x, game.getRandomLane());
			break;
		case 4:
			o = new Truck(game, x, game.getRandomLane());
			break;
		case 5:
			o = new Pedestrian(game, x, 0);
			break;
		}
		game.forceAddObject(o);
	}
}
