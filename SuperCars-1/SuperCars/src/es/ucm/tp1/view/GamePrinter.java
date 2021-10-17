package es.ucm.tp1.view;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.StringUtils;

public class GamePrinter {

	private static final String SPACE = " ";
	private static final String ROAD_BORDER_PATTERN = "ï¿½?";
	private static final String LANE_DELIMITER_PATTERN = "â”€";
	private static final int CELL_SIZE = 7;
	private static final int MARGIN_SIZE = 2;
	private Game game;
	private int numRows;
	private int numCols;
	private String indentedRoadBorder;
	private String indentedLlanesSeparator;
	private String margin;
	private String[][] board;
	
	public GamePrinter(Game game, int cols, int rows) {
		this.game = game;
		this.numRows = rows;
		this.numCols = cols;

		this.margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		String roadBorder = ROAD_BORDER_PATTERN + StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) * numCols);
		this.indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE, numCols - 1) + laneDelimiter + SPACE;

		this.indentedLlanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);

	}

	private void encodeGame(Game game) {
		//TODO fill your code
		board = new String[numRows][numCols];
		string str = "Command  >";
		for(int i = 0; i<numRows;i++){
			for(int j = 0;j<numCols;j++){
				board[i][j] = game.getPositiontoString(i,j + game.getPlayer().getY());
			}
		}
		
		System.out.println("[DEBUG] Executing: " + game.());
		System.out.println("Distance : " + this.x - game.getLength());
		System.out.println("Coins : " + game.getCoins());
		System.out.println("Cicle : " + game.getCycles());
		System.out.println("Total Obstacles : " + game.getoList());
		System.out.println("Total Coins : " + game.getcList());
		System.out.println("Ellapsed Time : " + game.getTime());
		System.out.println("Level : " + game.getLevel());
		System.out.println("Seed : " + game.getSeed());
		System.out.println("═══════════════════════════");
		System.out.print(str);
	}

	@Override
	public String toString() {
		encodeGame(game);
		
		StringBuilder str = new StringBuilder();

		// Game Status
		str.append(game.getGameStatus());

		// Paint game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;

		for (int y = 0; y < numRows; y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = 0; x < numCols; x++) {
				str.append(StringUtils.centre(board[y][x], CELL_SIZE))
						.append(verticalDelimiter);
			}
			if (y < numRows - 1) {
				str.append(this.indentedLlanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}
}
