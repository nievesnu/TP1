package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	/* @formatter:off */
	private static final String[] HELP = new String[] {
		"Available commands:",
		"[h]elp: show this help",
		"[i]nfo: prints gameobjet info",
		"[n]one | []: update",
		"[q]: go up",
		"[a]: go down",
		"[e]xit: exit game",
		"[r]eset: reset game",
		"[t]est: enables test mode",	
	};
	/* @formatter:off */
	private static final String[] INFO = new String[] {
		"Available Objects: ",
		"[Car] the racing car",
		"[Coin] gives 1 coin",
		"[Obstacle] hits the car",
	};
	/* @formatter:off */
	
	private Game game;
	private Scanner scanner;
	private GamePrinter printer;
	
	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
	}

	public void printGame() {
		System.out.println(game);
	}

	public void getHelp() {
		for(int i = 0; i<HELP.length;i++) {
			System.out.println(HELP[i]);
		}		
	}
	
	public void getInfo() {
		for(int i = 0; i<INFO.length;i++) {
			System.out.println(INFO[i]);
		}
	}
	
	public void run() {

		boolean refreshDisplay = true;
    	
		while (!game.isFinished()){ 	
			if (refreshDisplay) printGame();
			
		/*UPDATE GAME*/
    	refreshDisplay = false;
       	
    	//System.out.print(printer); 	
    	//String[] cmdTokens = scanner.nextLine().toLowerCase().split(" ");
    	//String cmd = cmdTokens[0];
    	
    	System.out.println(PROMPT);
    	String line = scanner.nextLine();
    	String[] words = line.toLowerCase().trim().split("\\s+");
    	System.out.println("(DEBUG) Executing: " + line);
    		
    		if(words.length== 0) {
    			System.out.println(UNKNOWN_COMMAND_MSG);
    			System.out.print("Command > ");
    			refreshDisplay = false;
    		}else{
    			switch (words[0]){
    			case "h":
    			case "help":
    			this.getHelp();
    				refreshDisplay = false;
    			break;
    			case "i":
    			case "info":
    			this.getInfo();
    				refreshDisplay = false;
    			break;
    			case "n":
    			case "none":
    			case" ":
    				game.update();
    				refreshDisplay = true;
    			break;
    			case "q":
    			case "up":
    				game.goUp();
    				game.update();
    				refreshDisplay = true;
    			break;
    			case "a":
    			case "down":
    				game.goDown();
    				game.update();
    				refreshDisplay = false;
    			break;
    			case "e":
    			case "exit":
    				System.out.println("Good Bye.");
    				game.isFinished();
    				System.out.println("[GAME OVER]"+ game.getEndGameMessage());
    			break;
    			case "r":
    			case "reset":    				
    				System.out.println(game);
    				refreshDisplay = true;  
    			break;
    			case "t":
    			case "test":
    	    		
    				System.out.println(game);
    				refreshDisplay = true;
    			break;
    			}
    		}
    	};
    	
    	System.out.print(printer);
	}
}
