package es.ucm.tp1.supercars.control;

import java.util.Scanner;

import es.ucm.tp1.supercars.control.commands.Command;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GamePrinter;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String DEBUG_MSG = "[DEBUG] Executing: %s%n";
	
	private Game game;
	private Scanner scanner;
	private GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.printer = new GamePrinter(game);

	}

	public void printGame() {
		System.out.println(printer);
	}

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

	public void run() {
		boolean refreshDisplay = true;

		while (!game.isFinished()) {
			if (refreshDisplay) {
				printGame();
			}
			refreshDisplay = false;

			System.out.println(PROMPT); //cambiar el ln si me molesta mucho escribir en la sig. linea
			String s = scanner.nextLine();

			String[] parameters = s.toLowerCase().trim().split(" ");
			System.out.format(DEBUG_MSG, s);
			Command command = Command.getCommand(parameters);
			if (command != null) {
				refreshDisplay = command.execute(game);
			}
		}
		if (refreshDisplay) {
			printGame();
		}
		printEndMessage();

	}
}