package fiuba.algo3.modelo;

public class Posicion {
	
	private int x;
	private int y;
	
	public void cargarPosicion(int posX,int posY) {
		this.x = posX;
		this.y = posY;
	}

	public Posicion obtenerPosicion() {
		return this;
	}
}
