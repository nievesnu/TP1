package es.ucm.tp1.supercars.logic;

import java.util.Random;

import java.util . Random;
import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.logic.actions.InstantAction;
import es.ucm.tp1.supercars.logic.GameObjectContainer;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;

public class Game {

	private Level level;
	private Random rand;
	private Player player;
	private GameObjectContainer container;
	private long seed;
	private int cycles;
	private boolean testMode; //test modo
	private long initialTime;
	private boolean exit = false;	
	
	//instancias
	public Game (long seed, Level level) {
		  this.seed = seed;
		  this.level = level;
		 
		  initGame();		
	}
	
	public void initGame() {
		
		this.cycles = 0;
		this.initialTime = System.currentTimeMillis();
		rand = new Random(seed);
		player = new Player(this, level.getWidth()/2, 0);
		testMode = false;
		this.container = new GameObjectContainer();
		GameObjectGenerator.generateGameObjects(this, level);
	}
	
	public boolean isFinished() {
		return player.isCrashed() || this.isExit() || this.hasArrived();
	}

	//COMANDOS:
	public boolean goUp() {
		boolean ok = false;
		if(player.getX() - 1 >= 0) {
			player.playerUp();
			ok = true;
		}
		return ok;		
	}
	
	public boolean goDown() {
		boolean ok =false;
		if(level.getWidth() - 1 > player.getX() ) {  
			player.playerDown();
			ok = true;
		}
		
		return ok;		
	}
	
	//RESET 
	public void reset() {
		initGame();
	}
	
	public int getRandomLane(){
		return (int) (rand.nextDouble()*level.getWidth());
	}
	
	public double getRandomNumber() {
		return rand.nextDouble();
	}
	
	//UPDATE 
	public void update() {
	 player.update();
	 this.cycles++;
	 this.toString();
	}
	
	public boolean emptyPos(int x, int y) {
		boolean empty = false;
		if(oList.isPosEmpty(x, y) || cList.isPosEmpty(x, y) ) {
			empty = true;
			}
		return empty;
	}
	
	public String getPositiontoString(int x, int y) {	//comprueba la pos del player y los objects y coins para printear
		
		String str = " ";
		int relativeY =  player.getY() + y;
		GameObject pos = this.getObjectInPosition(x, relativeY);
		if(pos != null){
		    str = pos.toString();
		}
		return str;
	}
	
	@Override
	
	public String getGameStatus() {
		
		StringBuilder str = new StringBuilder();
		str.append("\nDistance : " + (level.getLenght() - player.getY()));
		str.append("\nCoins : " + player.getCoins() );
		str.append("\nCicle : " + cycles);
		str.append("\nTotal Obstacles : " + Obstacle.getObstacleCounter());
		str.append("\nTotal Coins : " + Coin.getCoinsCount());
		if(!this.isTestMode()) {
			str.append("\nEllapsed Time : " + this.elapsedTime()); 
		}
		return str.toString();
	}

	public String getEndGameMessage(boolean out) {
		String end = " ";
		if(out){
			end = "Player exit!";
		}else if(!player.isCrashed()) { //ha ganado
			end = " Player wins!" + " New record!: " + System.currentTimeMillis() + " s" ;		
		}else {
			end = " Player crashed!\r\n";
		}
		return end;
	}

	public GameObject getObjectInPosition(int x, int y ) {
		return container.getObjectContainer(x, y);
	}
	
	public void sumar(int coins) {
		player.sumar(coins);
	}
	
	public Level getLevel() {
		return level;
	}

	public Random getRand() {
		return rand;
	}

	public Player getPlayer() {
		return player;
	}

	public long getSeed() {
		return seed;
	}

	public int getCycles() {
		return cycles;
	}

	public boolean isExit() {
		return exit;
	}
	public void exit() {
		exit = true;
	}
	
	public boolean isTestMode() {
		return testMode;
	}
	
	public void toggleTest() {
		this.testMode = true;
	}

	public int distanceToGoal() {
		return level.getLenght() - player.getY();
	}

	public int playerCoins() {
		return player.getCoins();
	}

	public long elapsedTime() {
		long e = (System.currentTimeMillis() - initialTime)/1000;
		return e;
	}

	public int getRoadWidth() {		
		return level.getWidth();
	}

	public int getVisibility() {
		return level.getVisibility();
	}
	
	public int getRoadLength() {
		return level.getLenght();
	}

	public boolean hasArrived() {
		return distanceToGoal() == 0;
	}

	public boolean isNewRecord() {
		// TODO Auto-generated method stub
		return false;
	}

	public long getRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void tryToAddObject(GameObject gameO, double frequency) {
		if(getRandomNumber() < frequency){
			if(this.emptyPos(gameO.getX(), gameO.getY())) {
				container.addObject(gameO);
			}
		}
	}

	public void forceAddObject(GameObject o) {
		// TODO Auto-generated method stub
		
	}
}