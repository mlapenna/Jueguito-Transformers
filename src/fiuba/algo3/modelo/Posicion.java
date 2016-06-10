package fiuba.algo3.modelo;
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

	public Posicion getPosicion() {
		return this;
	}
	
	public void mayorA(Posicion posicion)
	{
		// TODO
		// hacer bien: un metod para X otro Y 
	//	if(((Math.abs(this.x) - posicion.obtenerPosicionX())>0) || ((Math.abs(this.y) - posicion.obtenerPosicionY())>0))
	//	{
	//		throw new DistanciasMuyGrandesExcepcion();
	//	}
	}
	
	public int obtenerPosicionX()
	{
		return this.x;
	}
	
	public int obtenerPosicionY()
	{
		return this.y;
	}

	public int getDistancia(Posicion posicionDestino) {
		int distanciaX = Math.abs( this.obtenerPosicionX() - posicionDestino.obtenerPosicionX() );
		int distanciaY = Math.abs( this.obtenerPosicionY() - posicionDestino.obtenerPosicionY() );
		int resultado;

		if (distanciaX >= distanciaY) {
			resultado = distanciaX;
		} else {
			resultado = distanciaY;
		}
		return resultado;
	}
	
	public boolean mismaPosicion(Posicion posicionDestino) {
		if((this.obtenerPosicionX()==posicionDestino.obtenerPosicionX()) && 
				 (this.obtenerPosicionY()==posicionDestino.obtenerPosicionY()))
			return true;
		return false;
	}
	
	public boolean formaSegmento(Posicion posicionDestino) {
		if( (this.obtenerPosicionX() != posicionDestino.obtenerPosicionX()) 
				|| ( this.obtenerPosicionY() != posicionDestino.obtenerPosicionY() ))
			return false;
		return true;
	}
	
	public boolean formaDiagonal(Posicion posicionDestino){
		int diffX = this.obtenerPosicionX() - posicionDestino.obtenerPosicionX();
		int diffY = this.obtenerPosicionY() - posicionDestino.obtenerPosicionY();
		
		if(diffX != diffY)
			return false;
		return true;
	}
}
