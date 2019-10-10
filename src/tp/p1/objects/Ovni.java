package tp.p1.objects;

public class Ovni {

	private int posX;
	private int posY;
	private int resist;
	private int puntos;
	private String icono;
	
	public Ovni() {

		posX = 0;
		posY = 8;
		resist = 1;
		puntos = 25;
		icono = "O[" + resist + "]";
	}

	/*GETS y SETS*/

	public int getPosX() {

		return posX;
	}

	public void setPosX(int posX) {

		this.posX = posX;
	}
	
	public int getPosY() {

		return posY;
	}
	
	public void setPosY(int posY) {

		this.posY = posY;
	}
	
	public int getResist() {

		return resist;
	}
	
	public void setResist(int resist) {

		this.resist = resist;
	}
	
	public int getPuntos() {

		return puntos;
	}
	
	public void setPuntos(int puntos) {

		this.puntos = puntos;
	}
	
	public String getIcono() {

		return icono;
	}

	public void setIcono(String icono) {

		this.icono = icono;
	}
}
