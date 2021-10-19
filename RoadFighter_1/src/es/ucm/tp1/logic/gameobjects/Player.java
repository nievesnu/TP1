package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

//Comportamiento: Avanza, va hacia arriba o va hacia abajo.
//Velocidad: 1 casilla por turno.
//Resistencia: Muere automáticamente con una colisión.



public class Player {
	private ObstacleList obsList;
	private CoinList cList;
	private boolean crashed;
	private int coins;
	private int x;
	private int y;
	private String symbol = ">"; //alive 
	private Game game; 
	
	public Player (Game game, int x, int y, int coins) {
		this.x = x;
		this.y = y;
		this.coins = coins;
		this.crashed = false;
		this.game = game;
	}
	
	public ObstacleList getObsList() {
		return obsList;
	}

	public void setObsList(ObstacleList obsList) {
		this.obsList = obsList;
	}

	public CoinList getcList() {
		return cList;
	}


	public void setcList(CoinList cList) {
		this.cList = cList;
	}


	public boolean isCrashed() {
		return crashed;
	}


	public void setCrashed(boolean crashed) {
		this.crashed = crashed;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public void setCoins(int coins) {
		this.coins = coins;
	}

	public boolean isInPosition(int x , int y) {
		return this.x == x && this.y == y;	
	}
	
	public int getCoins(){
		return coins;
	}
	
	public void playerUp() {
		this.y++;
	}
	
	public void playerDown() {
		this.y--;
	}

	public void update() {
		this.x += 1; //x++
	
		if (!cList.isPosEmpty(this.x, this.y) ) {
			cList.CollideInPos(this.x, this.y);// esto devuelve boolean
			this.coins++;
		}
		
		if(!obsList.isPosEmpty(this.x, this.y)) {
			obsList.CollideInPos(this.x, this.y); //esto devuelve boolean 
			this.crashed = true;
			this.symbol = "@";
		}
		
		
	}
	
}
