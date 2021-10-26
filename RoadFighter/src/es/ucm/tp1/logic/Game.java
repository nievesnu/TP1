package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;

import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.CoinList;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.gameobjects.ObstacleList;

//import es.ucm.tp1.logic.gameobjects.Objects
//import es.ucm.tp1.logic.gameobjects.ObjectList

import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.view.GamePrinter;

public class Game {

	private Level level;
	private Random rand;
	private Player player;
	private CoinList cList;
	private ObstacleList oList;
	private long seed;
	private int cycles;
	private GamePrinter printer;
	private int x;
	private int y;
	private long initialTime = System.currentTimeMillis();
	

	private boolean testMode;
	//instancias
	
	public Game (long seed, Level level, boolean testMode) {
		
		  this.cycles = 0;
		  this.seed = seed;
		  this.level = level;
		  this.testMode = testMode; 
		  this.printer = new GamePrinter(this, level.getVisibility(), level.getWidth() );
		  initGame();		
	}
	
	public void initGame() {
		
		this.x = y;
		this.y = this.level.getWidth();
		this.cycles = 0;
		rand = new Random(seed);
		player = new Player(this, x, y, 0);
				
		cList = new CoinList(level.getLenght() - level.getVisibility() /2);
		oList = new ObstacleList(level.getLenght() - level.getVisibility() /2);
		
		for(int i = (level.getVisibility() /2); i < level.getLenght(); i++){
			//tryToAddObject(x, getRandomLine(), level.getObstacleFrequency());
			
			tryToAddObstacle(getRandomLine(), i, level.getObstacleFrequency());
			tryToAddCoins(getRandomLine(), i, level.getCoinFrequency());
		}

	}
	
 	public int getX (Game game) {
		
		return x;
	}
	
	public int getY (Game game) {

		return y;
	}
	
	public boolean isFinished() {
		boolean fin = false;
		if(player.isCrashed() || player.getX() == this.x - 1) { /*si el coche crashed aka dead || */
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
		if(level.getWidth() - player.getX() > 0 ) {  
			player.playerDown();
			ok = true;
		}
		
		return ok;		
	}
	
	public void updateClist() {
		
		if (!cList.isPosEmpty(this.x, this.y) ) {
			cList.CollideInPos(this.x, this.y);
			player.sumar();
		}
	}
	
	public void updateOlist() { //acabar
		if(!oList.isPosEmpty(this.x, this.y)) {
			oList.CollideInPos(this.x, this.y); 
			
		}
		
	}
		
	public CoinList getcList() {
		return cList;
	}

	public void setcList(CoinList cList) {
		this.cList = cList;
	}

	public ObstacleList getoList() {
		return oList;
	}

	public void setoList(ObstacleList oList) {
		this.oList = oList;
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
	
	/*private int getRoadWidth() {
		
		return level.getWidth();
	}*/
	
	
	//UPDATE 
	public void update() {
	 player.update();
	 this.updateClist();
	 this.updateOlist();
	 cList.removeDead();
	 oList.removeDead();
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
	
	public void tryToAddObstacle(int x, int y, double frequency) {
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
	}
	
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
		str.append("\nEllapsed Time : " + ((System.currentTimeMillis() - initialTime)/1000)); //wtf hago;
			
		return str.toString();
	}

	public String getEndGameMessage() {
		String end = " ";
		if(!player.isCrashed()) { //ha ganado
			end = " Player wins!" + " New record!: " + System.currentTimeMillis() + " s" ;		
		}else {
			end = " Player crashed!\r\n";
		}
		return end;
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

	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}
	
	public void toggleTest() {
	boolean mode = false;
	
		if(!isTestMode()){
			mode=true;
			setTestMode(mode);
			this.level = Level.TEST;
			this.initialTime = 0;
			initGame();
		}
	}
}

	
