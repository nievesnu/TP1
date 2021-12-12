package es.ucm.tp1.supercars.view;

import es.ucm.tp1.supercars.logic.Game;

public class GameSerializer {
	private static final String SRLZ_MSG = "---- ROAD FIGHTER SERIALIZED ---- \n";
	private static final String LVL = "Level: ";
	private static final String CY = "Cycles: ";
	private static final String C = "Coins: ";
	private static final String ET = "EllapsedTime: ";
	private static final String GO = "Game Objects: ";
	
	private Game game;
	
	public GameSerializer(Game game) {
		this.game = game;
	}	
	
	public String getSerInfo() {
		StringBuilder buffer = new StringBuilder();
		/* @formatter:off */
		buffer
		.append(SRLZ_MSG).append(LVL).append(game.getLevel()).append("\n").append(CY).append(game.getCycles()).append("\n")
		.append(C).append(game.playerCoins()).append("\n").append(ET).append(String.format("%.2f s", game.elapsedTime() / 1000.0)).append("\n").append(GO)
		.append("\n").append(game.posSertoString());
		/* @formatter:on */
		
		return buffer.toString();
	}
}