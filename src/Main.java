/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import java.util.Random;
import java.util.Scanner;
import pr2.game.Game;
import pr2.game.Level;
import pr2.game.control.Controller;
import pr2.game.exceptions.CommandParseException;

public class Main {

	public static void main(String[] args) throws CommandParseException {
		
		int semilla;
		Game game;
		Controller controlador;
		Scanner scanner;
		Random rand;
		Level nivel = null;
		String nivelStr;
		
		//Parametros erroneos?
		if (args.length < 1 || args.length > 2)
		{
			System.out.println("Los parametros establecidos son erroneos.");
		}
		else
		{
			//Obtener nivel
			nivelStr = args[0].toLowerCase();
			//Comprueba si es el nivel correcto
			if (nivelStr.equals("difficult"))
			{
				throw new CommandParseException("Usage: Main <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
			}
			if ((!nivelStr.equals("easy")) && (!nivelStr.equals("hard")) && (!nivelStr.equals("insane")))
			{
				//System.out.println("Los parametros establecidos son erroneos.");
				throw new CommandParseException("Usage: Main <EASY|HARD|INSANE> [seed]");
			}
			else
			{
				//Asignar nivel al enumerado
				if (nivelStr.equals("easy"))
				{
					nivel = Level.EASY;
				}
				else if (nivelStr.equals("hard"))
				{
					nivel = Level.HARD;
				}
				else if (nivelStr.equals("insane"))
				{
					nivel = Level.INSANE;
				}
				//Comprueba semilla
				if (args.length > 1)
				{
					semilla = Integer.parseInt(args[1]);
				}
				else
				{
					semilla = new Random().nextInt((int)System.currentTimeMillis()*(-1));
				}
				//Crea un objeto aleatorio
				rand = new Random(semilla);
				//Crea un objeto de game
				game = new Game(nivel, rand);
				//Crea un objeto de scanner para leer lo que pone el usuario
				scanner = new Scanner(System.in);
				//Crea un objeto de controlador
				controlador = new Controller(game, scanner);
				//Ejecuta el juego
				controlador.run();
			}
		}
	}
}