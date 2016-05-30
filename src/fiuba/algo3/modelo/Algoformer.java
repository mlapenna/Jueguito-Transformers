package fiuba.algo3.modelo;

public abstract class Algoformer {
	static final String modoHumanoide = "humanoide";
	static final String modoAlterno = "alterno";
	
	protected int vida;
	protected String nombre;
	protected String modo;
	
	public abstract void transformarHumanoide();
	
	public abstract void transformarAlterno();
	
	public abstract void agregarATablero();
	
	public void moverNuevaPosicion(Tablero tablero, Posicion posicion){
		
	}
	
	public Posicion obtenerPosicion(Tablero tablero){
		Posicion posicion = new Posicion();
		return posicion;		
	}

	public String getModo() {
		return this.modo;
	}

}
