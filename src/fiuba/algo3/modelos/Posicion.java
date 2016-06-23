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

	public boolean sePuedenCombinar(Posicion posicion2, Posicion posicion3) {
		if(this.getX()==posicion2.getX() && this.getX()==posicion3.getX())
			if(this.estanJuntos(posicion2, posicion3))
				return true;
		return false;
	}

	private boolean estanJuntos(Posicion posicion2, Posicion posicion3){
		if((this.getDistancia(posicion2)==1 && posicion2.getDistancia(posicion3)==1) ||
			(this.getDistancia(posicion3)==1 && posicion3.getDistancia(posicion2)==1) ||
			(this.getDistancia(posicion2)==1 && this.getDistancia(posicion3)==1) )
			return true;
		return false;
	}

	public Posicion posicionDelMedioVertical(Posicion posicion2, Posicion posicion3) {
		if((this.getX()<posicion2.getX() && this.getX()>posicion3.getX()) || (this.getX()>posicion2.getX() && this.getX()<posicion3.getX())) 
			return this;
		else
			if((posicion3.getX()<posicion2.getX() && posicion3.getX()>this.getX()) || (posicion3.getX()>posicion2.getX() && posicion3.getX()<this.getX()))
				return posicion3;
			else
				return posicion2;
	}
}
