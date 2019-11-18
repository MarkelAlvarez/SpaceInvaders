package pr2.game.control.commands;

import pr2.game.Game;
import pr2.game.control.Command;

public class ResetCommand extends Command {

	public ResetCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	public boolean execute(Game game) {

		game.reset();
		
		if(game.isFinished() == false)
		{
			game.update();
		}
		
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {

		if (matchCommandName(commandWords[0]))
		{
			return this;
		}

		return null;
	}
}
