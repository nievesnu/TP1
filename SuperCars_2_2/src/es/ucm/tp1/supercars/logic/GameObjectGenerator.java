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
import es.ucm.tp1.supercars.logic.instantaction.ThunderAction;

public class GameObjectGenerator {
	
	public static void generateGameObjects(Game game, Level level) { //modificar randlane con x

		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
			game.tryToAddObject(new Obstacle(game, game.getRandomLane(), x ), level.getObstacleFrequency());
			game.tryToAddObject(new Coin(game,game.getRandomLane(), x), level.getCoinFrequency());
			
			if (level . hasAdvancedObjects()) {
				
				game.tryToAddObject(new Wall(game, game.getRandomLane(), x), level.getAdvancedObjectsFrequency());
				game.tryToAddObject(new Turbo(game, game.getRandomLane(), x), level.getAdvancedObjectsFrequency());
				if (! SuperCoin.hasSuperCoin()) {
					game.tryToAddObject(new SuperCoin(game, game.getRandomLane(), x), level.getAdvancedObjectsFrequency());
				}
				game.tryToAddObject(new Truck(game, game.getRandomLane(), x), level.getAdvancedObjectsFrequency());
				game.tryToAddObject(new Pedestrian(game, 0, x), level.getAdvancedObjectsFrequency());
			}
		}
	}
	
	public static void reset(Level level) {
		Obstacle.reset();
		Coin.reset();
		SuperCoin.reset();
	}

	public static void generateRuntimeObjects(Game game) {
		if (game.getLevel().hasAdvancedObjects()) {
			game.execute(new ThunderAction());
		}
	}
	
	public static void forceAdvanceObject(Game game, int id, int x) {
		GameObject o = null;
		switch (id) {
		case 1:
			o = new Wall(game, game.getRandomLane(), x);
			break;
		case 2:
			o = new Turbo(game, game.getRandomLane(), x); //cambiar randlane y x de sitio como en wall
			break;
		case 3:
			o = new SuperCoin(game, game.getRandomLane(), x);
			break;
		case 4:
			o = new Truck(game, game.getRandomLane(), x);
			break;
		case 5:
			o = new Pedestrian(game, 0, x);
			break;
		}
		game.forceAddObject(o);
	}
}
