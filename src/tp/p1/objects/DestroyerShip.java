package tp.p1.objects;

public class DestroyerShip {

	private int posX;
	private int posY;
	private int id;		//Ayuda a identificar cada nave y su proyectil lanzado
	private int resist;
	private int puntos;
	private Boolean bomb;
	private String icono;
	
	public DestroyerShip(int x, int y, int ident) {

		posX = x;
		posY = y;
		id = ident;
		resist = 1;
		puntos = 10;
		bomb = false;
		icono = "D[" + resist + "]";
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
	
	public int getId() {
		
		return id;
	}
	
	public void setId(int ident) {
		
		this.id = ident;
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
	
	public Boolean getBomb() {
		
		return bomb;
	}
	
	public void setBomb(Boolean bomb) {
		
		this.bomb = bomb;
	}
	
	public String getIcono() {
		
		return icono;
	}
	
	public void setIcono(String icono) {
		
		this.icono = icono;
	}
}
