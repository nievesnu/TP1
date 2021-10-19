package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;

public class GameObjectGenerator {
	public static void generateGameObjects(Game game, Level level) {
		for(int x = game.getVisibility() /2; x < game.getRoadLength(); x ++) {
			game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.
			obstacleFrequency());
			game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.coinFrequency());
			}
		}
		public static void reset(Level level ) {
			Obstacle.reset ();
			Coin.reset ();
			}

}
