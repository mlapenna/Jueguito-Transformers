package fiuba.algo3.modelo;
import java.lang.Math;

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
	
	public void mayorA(Posicion posicion)
	{
		// TODO
		// hacer bien: un metod para X otro Y 
	//	if(((Math.abs(this.x) - posicion.obtenerPosicionX())>0) || ((Math.abs(this.y) - posicion.obtenerPosicionY())>0))
	//	{
	//		throw new DistanciasMuyGrandes();
	//	}
	}
	
	private int obtenerPosicionX()
	{
		return this.x;
	}
	
	private int obtenerPosicionY()
	{
		return this.y;
	}
}
