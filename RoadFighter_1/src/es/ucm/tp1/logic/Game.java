package es.ucm.tp1.logic;

import java.util.Random;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.CoinList;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.gameobjects.ObstacleList;
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
	private boolean exit;
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
		 // this.printer = new GamePrinter(this, level.getVisibility(), level.getWidth() );
		  initGame();
		
	}
	
	public void initGame() {
		
		this.x = this.level.getLenght();
		this.y = this.level.getWidth();
		this.cycles = 0;
		rand = new Random(seed);
		player = new Player(this, x, y, 0);
				
		cList = new CoinList(level.getLenght() - level.getVisibility() /2);
		oList = new ObstacleList(level.getLenght() - level.getVisibility() /2);
		
		for(int i = (level.getVisibility() /2); i < level.getLenght(); i++){
			tryToAddObstacle(x, getRandomLine(), level.getObstacleFrequency());
			tryToAddCoins(x, getRandomLine(), level.getCoinFrequency());
		}

		printer = new GamePrinter(this, level.getVisibility(), getRoadWidth());
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
		boolean ok =false;
		if(player.getY() <this.y-2) { //si no es menos dos es menos uno 
			player.playerUp();
			ok = true;
		}
		
		return ok;		
	}
	
	public boolean goDown() {
		boolean ok =false;
		if(player.getY() > 0 ) {  
			player.playerDown();
			ok = true;
		}
		
		return ok;		
	}

	//RESET 
	public void reset() {
		initGame();
	}			
	private int getRandomLine(){
		return (int) rand.nextDouble()*level.getWidth();
	}
	public int getRandomNumber() {
		return (int) rand.nextDouble();
	}
	private int getRoadWidth() {
		
		return level.getWidth();
	}

	//UPDATE 
	public void update() {
	 player.update();
	 cList.removeDead();
	 oList.removeDead();
	 this.cycles++;
	}

	//OBJETIVOS -> FUNCION Y VER LO QUE HAY -> IR PROBANDO comentando codigo
	//aaÃ±adir obs y coins +player
	//aparezcan en la carretera -> imprimir y se vea
	//usar comando up y down -> comprobar que funciona
	//comando avanzar
	//el coche empieza en pos x=0 y segun avanza se muestra (el player) la ventanaa a partir de la pos del player _visibility_
	//probar mas comandos y al final el rst
	
	public void tryToAddObstacle(int x, int y, double frequency) {
		if	(getRandomNumber() < frequency){
			
			if(oList.isPosEmpty(x, y)) {
				oList.add(new Obstacle(x, y, 1));
			}
		}	
	}	
	public void tryToAddCoins(int x, int y, double frequency) {
		if	(getRandomNumber() < frequency){
			
			if(cList.isPosEmpty(x, y)) {
				cList.add(new Coin(x, y,1));
			}
		}
	}	
	
	public String getPositiontoString( int x, int y) {	//comprueba la pos del player y los objects y coins para printear
		
		String str = " ";
		int relativeX =  player.getX() + level.getVisibility();
		
		if(player.isInPosition(x,y)){
			str = player.toString();
		}
		else if(cList.isInPos(relativeX,y)){
		    str = cList.toString();
		}
		else if(oList.isInPos(relativeX,y)){
		    str = oList.toString();
		}
		return str;
	}

	@Override
	public String toString() {
		return printer.toString();
	}

	public String getGameStatus() {
		
		StringBuilder str = new StringBuilder();
		String stc = "Command  >";
		str.append(stc);		
		str.append("[DEBUG] Executing: "   ); //como concha le a;ado el ult command
		str.append("Distance : " + (this.getX(this) - level.getLenght()));
		str.append("Coins : " + player.getCoins() );
		str.append("Cicle : " + this.getCycles());
		str.append("Total Obstacles : " + this.getoList() );
		str.append("Total Coins : " + this.getcList() );
		str.append("Ellapsed Time : " + (System.currentTimeMillis() - initialTime)); //wtf hago;
		str.append("Level : " + this.getLevel());
		str.append("Seed : " + this.getSeed());
		str.append("â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?â•?");
		
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

	public void setLevel(Level level) {
		this.level = level;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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

	public long getSeed() {
		return seed;
	}

	public void setSeed(long seed) {
		this.seed = seed;
	}

	public int getCycles() {
		return cycles;
	}

	public void setCycles(int cycles) {
		this.cycles = cycles;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public GamePrinter getPrinter() {
		return printer;
	}

	public void setPrinter(GamePrinter printer) {
		this.printer = printer;
	}

	public boolean isTestMode() {
		return testMode;
	}

	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}
	
	public void toggleTest() {
		
		
	}
}

	
