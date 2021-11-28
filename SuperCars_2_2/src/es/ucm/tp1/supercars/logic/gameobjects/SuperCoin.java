package es.ucm.tp1.supercars.logic.gameobjects;
import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends GameObject{
	
	private static int  superValue = 1000;
	private static final String SYMBOL = "$";
	private static boolean hasIt = false;
	public static final String INFO = "[SUPERCOIN] gives 1000 coins.\n";
	
	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = SYMBOL;		
	}	
	
	public static void reset() {
		hasIt = false;
	}
	
	public static boolean hasSuperCoin() {
		return hasIt;
	}
	
	@Override
	public boolean doCollision() {
		return false;
	}
	
	@Override
	public boolean receiveCollision(Player player) {
		this.onDelete();
		player.sumar(superValue);
		return true; //impacta = true;
	}
	
	@Override
	public boolean receiveShoot(Player player) {
		return false;
	}
	
	@Override
	public void onEnter() {
		hasIt = true;
		this.health = 1;
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void onDelete() {
		hasIt = false;
		this.health = 0;
	}
}