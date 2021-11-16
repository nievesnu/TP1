package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class WaveCommand extends Command{
	
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);

	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
        if(this.matchCommandName(commandWords[0]))
        if(commandWords.length<2)
            return this;
        
        return null;
    }
	
	/*El comando tiene un coste de 5 coins
	 * Empujaremos todos los objetos visibles de la carretera excepto el coche.
	 * No podemos empujar un objeto que tenga algún otro objeto detrás. 
	 * Si hay dos objetos en la misma posición sólo afectará a uno de ellos, el que haya sido introducido antes en el container.
	 * Tras ejecutar un wave, se hace un update del game.
	 * */

}
