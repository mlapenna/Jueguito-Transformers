package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;

public abstract class Algoformer {
	static final String modoHumanoide = "humanoide";
	static final String modoAlterno = "alterno";
	
	protected int vida;
	protected String nombre;
	
	
	public void transformarHumanoide() {
		
	}
	
	public void transformarAlterno(){
		
	}
	
	public void agregarATablero(Algoformer transformer){
		
	}
	
	public void moverNuevaPosicion(Tablero tablero, Posicion posicion){
		
	}
	
	public Posicion obtenerPosicion(Tablero tablero){
		Posicion posicion = new Posicion();
		return posicion;		
	}
	
}
