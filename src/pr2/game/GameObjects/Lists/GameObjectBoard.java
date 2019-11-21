package pr2.game.GameObjects.Lists;

/*
* Juan Pablo Corella y Markel Alvarez (2ºB)
*/

import pr2.game.GameObjects.*;
import pr2.game.GameObjects.objects.*;

public class GameObjectBoard {

	private GameObject[] objects;
	private int currentObjects;

	public GameObjectBoard (int width, int height)
	{
		objects = new GameObject[width * height];

		for (int i = 0; i < width * height; i++)
		{
			objects[i] = null;
		}
		currentObjects = 0;
	}

	private int getCurrentObjects () {

		return currentObjects;
	}

	public void add (GameObject object) {

		objects[currentObjects] = object;
		currentObjects++;
	}

	private GameObject getObjectInPosition (int x, int y) {

		int i = 0;

		while (i < currentObjects)
		{
			if (objects[i].isOnPosition(x, y))
			{
				return objects[i];
			}
			i++;
		}

		return null;
	}

	private int getIndex(int x, int y) {

		int i = 0;

		while (i < currentObjects)
		{
			if (objects[i].isOnPosition(x, y))
			{
				return i;
			}
			i++;
		}

		return -1;
	}

	private void remove (GameObject object) {

		int i = 0;

		while (i < currentObjects)
		{
			if (objects[i] == object)
			{
				for (int j = i + 1; j < currentObjects; j++)
				{
					objects[i] = objects[j];
					i++;
				}
				objects[currentObjects - 1] = null;
				currentObjects--;
				i = currentObjects;
			}
			i++;
		}
	}

	public void update() {
		
		for (int i = 0; i < currentObjects; i++) {
			if(objects[i].isAlive() && objects[i] instanceof Weapon) {
				checkAttacks(objects[i]);
			}
		}
		
		removeDead();
		
		for (int i = 0; i < currentObjects; i++) {
			if(objects[i].isAlive() && objects[i] instanceof Weapon) {
				objects[i].move();
				checkAttacks(objects[i]);
			}
		}
		
		removeDead();
	}

	private void checkAttacks(GameObject object) {
		//GameObject aux = getObjectInPosition(object.getX(), object.getY());
		//if(aux != null) {
		// El problema de esto es que puede encontrarse a sí mismo y parar la busqueda
		//Lo dejo de forma jincha para revisar más adelante (sustituir el objects[i] por aux)
		if(!(object instanceof ShockWave)) {
			int i = 0;
			while (i < currentObjects) {
				if(objects[i].isOnPosition(object.getX(), object.getY()) && objects[i].isAlive()
						 && objects[i] != object) {
					if(((Weapon) object).performAttack(objects[i])) {	//si este weapon afecta a la nave
						object.getDamage(object.getLive());
						i = currentObjects;
					}
				}
				i++;
			}
		}
		else {
			for (int i = 0; i < currentObjects; i++) {
				((Weapon) object).performAttack(objects[i]);
			}
			object.getDamage(object.getLive());
		}
	}

	public void computerAction() {
		for (int i = 0; i < currentObjects; i++) {
			if(objects[i] instanceof AlienShip) {
				objects[i].move();
			}
			else if(objects[i] instanceof Ovni) {
				if(((Ovni) objects[i]).getActive()) {
					objects[i].move();
				}
			}
		}
		
		for (int i = 0; i < currentObjects; i++) {
			objects[i].computerAction();
		}
	}

	private void removeDead() {

		for (int i = 0; i < currentObjects; i++)
		{
			if (!(objects[i] instanceof ShockWave)) {	//para no borrar el shockwave
				if(!objects[i].isAlive() || objects[i].isOut())	
				{
					
					if(objects[i] instanceof Ovni) {
						if(!objects[i].isAlive()) {
							if(((Ovni) objects[i]).getActive()) {
								objects[i].onDelete();
							}
						}
						else {
							((Ovni) objects[i]).deactivate();
						}
					}
					else {
						objects[i].onDelete();
						if(!(objects[i] instanceof UCMShip)) {
							remove(objects[i]);
							i--;
						}
					}
				}
			}
			else if(!objects[i].isAlive()) {
				objects[i].onDelete();
				remove(objects[i]);
			}
		}
	}

	public String toString(int i, int j) {

		for (int aux = 0; aux < currentObjects; aux++)
		{
			if (objects[aux].isOnPosition(i, j))
			{
				return objects[aux].toString();
			}
		}

		return "";
	}
}
