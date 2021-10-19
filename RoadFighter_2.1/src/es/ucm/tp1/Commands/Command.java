package es.ucm.tp1.Commands;

import es.ucm.tp1.logic.Game;


public abstract class Command {
	
	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	private static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
	private static final String incorrectArgsMsg = "Incorrect arguments format";
	
	private final String name;
	private final String shortcut;
	private final String details ;
	private final String help;
	
	public Command(String name, String shortcut, String details, String help) {
		this. name = name;
		this. shortcut = shortcut;
		this. details = details;
		this. help = help;
		}

	private static Command[] availableCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new MoveUpCommand(),
			new MoveDownCommand(),
	};
	
	public static Command getCommand(String[] commandWords) {
		boolean command_found = false;
		Command command = null;
		for(int i  = 0; i < availableCommands.length && !command_found; i++) 
		{
			command = availableCommands[i].parse(commandWords);
			if(command != null){
				command_found = true;
			}
		}
		return command;
	}

	public abstract boolean execute(Game game);
	
	public abstract Command parse(String[] commandWords);
	
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);		    
	}
	
	protected Command parseNoParamsCommand(String[] words) {
	
			if (matchCommandName(words[0])) {
				if (words.length != 1) {
					System.err.println(incorrectArgsMsg);
					return null;
				}
				return this;
			}
			
			return null;
	  }
	
	protected Command parse1(String[] words) {
		Command co = null;
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s %n %n", name, incorrectNumberOfArgsMsg);
				co = null;
			} else {
				co = this;
			}
		}
		return co;
	}

	
	public static String commandHelp() {
		String s = "";
		for(int i  = 0; i < availableCommands.length; i++) 
			s += availableCommands[i].helpText();
		
		return s;
	}
	
	public StringBuilder helpText(){
		  StringBuilder str = new StringBuilder();
		  str.append("Available commands:");
		  str.append("[h]elp: show this help");
		  str.append("[i]nfo: prints gameobjet info");
		  str.append("[i]nfo: prints gameobjet info");
		  str.append("[n]one | []: update");
		  str.append("[q]: go up");
		  str.append( "[a]: go down");
		  str.append("[e]xit: exit game");
		  str.append("[r]eset: reset game");
		  str.append("[t]est: enables test mode");
		  return str;
	  }
	  
	  
}
