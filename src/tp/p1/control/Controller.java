package tp.p1.control;

import java.util.Scanner;

import tp.p1.logic.*;

public class Controller {

	private Game game;
	private Scanner in;
	private GamePrinter printer;
	final static int numF = 8;
	final static int numC = 9;
	
	public Controller(Game game, Scanner scanner) {
		
		this.game = game;
		in = scanner;
		game.initGame();
	}

	public void run() {

		while ((game.getEnd() == false) && (game.getReset() == false))
		{
			draw();
			game.userCommand(comandoMenu());
			
			if(game.getEnd() == false) {
				game.computerAction();
				game.update();
				game.setCiclos(game.getCiclos() + 1);
			}
		}

		if (game.getReset())
		{
			game.initGame();
			run();
		}
		else if (game.getEnd())
		{
			draw();

			if (game.getdList().getContador() + game.getrList().getContador() == 0)
			{
				System.out.println("YOU WIN! POINTS OBTAINED: " + game.getPuntuacion());
			}
			else
			{
				System.out.println("GAME OVER");
			}
		}
	}

	public void draw() {
		
		System.out.println("Life: " + game.getUCMShip().getResist());
		System.out.println("Number of cycles: " + game.getCiclos());
		System.out.println("Points: " + game.getPuntuacion());
		System.out.println("Remaining aliens: " + (game.getdList().getContador() + game.getrList().getContador()));
		
		if (game.getUCMShip().getShockwave())
		{
			System.out.println("Shockwave: YES");
		}
		else
		{
			System.out.println("Shockwave: NO");
		}
		
		printer = new GamePrinter(game, numF, numC);
		
		System.out.println(printer.toString());
	}
	
	public String comandoMenu()
	{
		String comando;
		
		System.out.print("Command > ");
		comando = this.in.nextLine();
		System.out.println();

		return comando;
	}
}
