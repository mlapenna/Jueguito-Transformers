package fiuba.algo3.modelos;
import java.lang.Math;

public class Posicion {
	
	private int x = 0;
	private int y = 0;

	public Posicion(int posX, int posY) {
		this.x = posX;
		this.y = posY;
	}

	public void setCoordenadas(int posX, int posY) {
		this.x = posX;
		this.y = posY;
	}


	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public int getDistancia(Posicion posicionDestino) {
		int distanciaX = Math.abs( this.getX() - posicionDestino.getX() );
		int distanciaY = Math.abs( this.getY() - posicionDestino.getY() );
		int resultado;

		if (distanciaX >= distanciaY) {
			resultado = distanciaX;
		} else {
			resultado = distanciaY;
		}
		return resultado;
	}


	public boolean equals(Object obj) {
		boolean resultado = false;

		if (obj instanceof Posicion) {
			Posicion posicionAComparar = (Posicion) obj;
			resultado = (this.getX() == posicionAComparar.getX() && this.getY() == posicionAComparar.getY());
		}

		return resultado;
	}

}