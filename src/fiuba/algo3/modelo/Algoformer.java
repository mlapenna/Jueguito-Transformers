package fiuba.algo3.modelo;

public abstract class Algoformer {
	static final String modoHumanoide = "humanoide";
	static final String modoAlterno = "alterno";
	static final int MODO_AUTOBOT = 0;
	static final int MODO_DECEPTICON = 1;
	static final int TOTAL_ROBOTS_DISPONIBLES_POR_TIPO = 4;
	
	protected int vida;
	protected String nombre;
	protected String modo;
	
	public abstract void transformarHumanoide(); //redefinida en cada Algoformer
	
	public abstract void transformarAlterno(); //redefinida en cada Algoformer
	
	public abstract void agregarATablero(); //redefinida en Autobot y Decepticon
	
	public void moverNuevaPosicion(Tablero tablero, Posicion posicion){
		
	}

	// Patrón doble dispatch
	public abstract boolean esDelMismoTipoQue(Algoformer unRobot);
	public boolean soyOptimus() { return false; }
	public boolean soyBumbleBee() { return false; }
	public boolean soyRatchet() { return false; }
	public boolean soySuperion() { return false; }
	public boolean soyMegatron() { return false; }
	public boolean soyBonecrusher() { return false; }
	public boolean soyFrenzy() { return false; }
	public boolean soyMenasor() { return false; }


	public Posicion obtenerPosicion(Tablero tablero){  //NO PARECE HACER NADA
		Posicion posicion = new Posicion();
		return posicion;		
	}

	public String getModo() {
		return this.modo;
	}

}
