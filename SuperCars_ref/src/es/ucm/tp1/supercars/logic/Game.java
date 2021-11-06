package es.ucm.tp1.supercars.logic;

import java.util.Random;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.CoinList;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.ObstacleList;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.view.GamePrinter;

public class Game {

	private Level level;
	private Random rand;
	private Player player;
	//private CoinList cList;
	//private ObstacleList oList;
	private GameObjectContainer container;
	private long seed;
	private int cycles;
	private GamePrinter printer;
	private boolean testMode; //test modo
	private long initialTime;
	
	
	//instancias
	
	public Game (long seed, Level level, boolean testMode) {
		  this.seed = seed;
		  this.level = level;
		  this.container = new GameObjectContainer();
		  this.printer = new GamePrinter(this, level.getVisibility(), level.getWidth() );
		  initGame();		
	}
	
	public void initGame() {
		
		this.cycles = 0;
		this.initialTime = System.currentTimeMillis();
		rand = new Random(seed);
		player = new Player(this, level.getWidth()/2, 0, 0);
		testMode = false;
				
		cList = new CoinList(level.getLenght() - level.getVisibility() /2);
		oList = new ObstacleList(level.getLenght() - level.getVisibility() /2);
		
		for(int i = (level.getVisibility() /2); i < level.getLenght(); i++){
			tryToAddObject(player.getX(), getRandomLine(), level.getObstacleFrequency());
		}

	}
	
	public boolean isFinished() {
		boolean fin = false;
		if(player.isCrashed() || player.getX() == level.getLenght()) { /*si el coche crashed aka dead || */
			fin = true;
		}
		return fin;
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
	
	public void updateClist() {
		if (!cList.isPosEmpty(player.getX(), player.getY()) ) {
			cList.CollideInPos(player.getX(), player.getY());
			player.sumar();
		}
	}
	
	public void updateOlist() { //acabar
		if(!oList.isPosEmpty(player.getX(), player.getY())) {
			oList.CollideInPos(player.getX(), player.getY()); 
			player.crash();
		}		
	}
	
	//RESET 
	public void reset() {
		initGame();
	}			
	private int getRandomLine(){
		return (int) (rand.nextDouble()*level.getWidth());
	}
	public double getRandomNumber() {
		return rand.nextDouble();
	}
	
		
	//UPDATE 
	public void update() {
		//chequear si el player ha muerto aka se ha chocado pero en game rollo un if 
	 player.update();
	 this.updateClist();
	 this.updateOlist();
	 //cList.removeDead();
	// oList.removeDead();
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
	
	/*public void tryToAddObstacle(int x, int y, double frequency) {
		if	(getRandomNumber() < frequency){
			
			if(this.emptyPos(x, y)) {
				oList.add(new Obstacle(x, y, 1));
			}
		}	
	}	
	
	public void tryToAddCoins(int x, int y, double frequency) {
		if	(getRandomNumber() < frequency){
			
			if(this.emptyPos(x, y)) {
				cList.add(new Coin(x, y,1));
			}
		}
	}*/
	
	public String getPositiontoString( int x, int y) {	//comprueba la pos del player y los objects y coins para printear
		
		String str = " ";
		int relativeY =  player.getY() + y;
		
		if(cList.isInPos(x, relativeY)){
		    str = cList.getSymbol();
		}
		else if(oList.isInPos(x, relativeY)){
		    str = oList.getSymbol();
		}
		return str;
	}

	@Override
	public String toString() {
		return printer.toString();
	}

	public String getGameStatus() {
		
		StringBuilder str = new StringBuilder();
		str.append("\nDistance : " + (level.getLenght() - player.getY()));
		str.append("\nCoins : " + player.getCoins() );
		str.append("\nCicle : " + cycles);
		str.append("\nTotal Obstacles : " + oList.getNume());
		str.append("\nTotal Coins : " + cList.getNume() );
		if(!this.isTestMode()) {
			str.append("\nEllapsed Time : " + ((System.currentTimeMillis() - initialTime)/1000)); //wtf hago;
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

	public Collider getObjectInPosition(int x, int y ) {
		return container.getObjectContainer(x, y);
		
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
		return true;
	}

	public GamePrinter getPrinter() {
		return printer;
	}
	
	public boolean isTestMode() {
		return testMode;
	}

	/*public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}*/
	
	public void toggleTest() {
		isTestMode();
	}

	public Object distanceToGoal() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object playerCoins() {
		// TODO Auto-generated method stub
		return null;
	}

	public long elapsedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRoadWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getVisibility() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean hasArrived() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isNewRecord() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getRoadLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getRandomLane() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setExit(boolean b) {
		b = isExit();
		
	}

	public void tryToAddObject(GameObject gameO, double frequency) {
		if	(getRandomNumber() < frequency){
			
			if(this.emptyPos(gameO.getX(), gameO.getY())) {
				
			}
		}
		
	}

	
}