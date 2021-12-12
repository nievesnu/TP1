package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public abstract class Command {
	protected static final String UNKNOWN_COMMAND_MSG = "Unknown command";
	protected static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
	protected static final String incorrectArgsMsg = "Incorrect arguments format";
	
	private final String name;
	private final String shortcut;
	private final String details ;
	private final String help;
	
	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	private static Command[] availableCommands = {
			
			new HelpCommand(),
			new InfoCommand(),
			new UpdateCommand(),
			new MoveUpCommand(),
			new MoveDownCommand(),
			new ExitCommand(),
			new ResetCommand(),
			new TestCommand(),
			new ShootCommand(),
			new GrenadeCommand(),
			new WaveCommand(),
			new SerializeCommand(),
			new SaveCommand(),
			new DumpCommand(),
			new ShowRecordCommand(),
			new ClearCommand(),
			new CheatCommand(),				
	};
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	
	public static Command getCommmand(String[] commandWords) throws CommandParseException{
		boolean command_found = false;
		Command command = null;
			for(int i  = 0; i < availableCommands.length && !command_found; i++) {
			command = availableCommands[i].parse(commandWords);
			if(command != null) {
				command_found = true;
				}
			}if (!command_found) {
				throw new CommandParseException(String.format("[ERROR]: %s", UNKNOWN_COMMAND_MSG), null);
			}
		return command;
	}
		
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
		
	protected Command parse(String[] words) throws CommandParseException {
		
		Command co = null;
		
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				throw new CommandParseException(String.format("[ERROR]: Command %s: %s %n %n", name, incorrectNumberOfArgsMsg), null);
			} else {
				co = this;
			}
		}
		return co;
	}

	public static String commandHelp() {
		String s = "";
		for(int i  = 0; i < availableCommands.length; i++) 
			s += availableCommands[i].help + "\n";
		
		return s;
	}
	
	public String getDetails() {
		return this.details;
	}
}