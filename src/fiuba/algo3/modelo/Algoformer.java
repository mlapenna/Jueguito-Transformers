package fiuba.algo3.modelo;

public abstract class Algoformer {
	static final String modoHumanoide = "humanoide";
	static final String modoAlterno = "alterno";
	
	protected int vida;
	protected String nombre;
	protected String modo;
	
	public abstract void transformarHumanoide(); //redefinida en cada Algoformer
	
	public abstract void transformarAlterno(); //redefinida en cada Algoformer
	
	public abstract void agregarATablero(); //redefinida en Autobot y Decepticon
	
	public void moverNuevaPosicion(Tablero tablero, Posicion posicion){
		
	}
	
	public Posicion obtenerPosicion(Tablero tablero){  //NO PARECE HACER NADA
		Posicion posicion = new Posicion();
		return posicion;		
	}

	public String getModo() {
		return this.modo;
	}

}
