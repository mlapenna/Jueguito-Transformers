package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Movimiento;
import fiuba.algo3.modelo.Posicion;

public abstract class Algoformer {
	static final String modoHumanoide = "humanoide";
	static final String modoAlterno = "alterno";
	static public final int MODO_AUTOBOT = 0;
	static public final int MODO_DECEPTICON = 1;
	static final int TOTAL_ROBOTS_DISPONIBLES_POR_TIPO = 4;
	
	protected int vida;
	protected Movimiento movimiento;
	Posicion posicion;
	protected int distanciaDeAtaque;
	protected int ataque;
	protected int velocidad;
	
	public abstract void transformarHumanoide(); //redefinida en cada Algoformer
	
	public abstract void transformarAlterno(); //redefinida en cada Algoformer

	public abstract boolean puedeAtacarA(Algoformer otroAlgoformer);

	public boolean esDecepticon() {
		return false;
	};

	public boolean esAutobot() {
		return false;
	};

	public void agregarATablero() {

	} 
	
	public Posicion getPosicion(){  
		return this.posicion;		
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public int getAtaque() {
		return this.ataque;
	}
	
	public int getDistanciaDeAtaque() {
		return this.distanciaDeAtaque;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean fueraDelAlcanceDelAlgoformer(Posicion posicionFinal) { 
		if ( (this.posicion.getDistancia(posicionFinal)) > this.velocidad )
			return true;
		return false;
	}

	public void recibirAtaque(Algoformer algoformerQueAtaca) {
		int vidaAux = this.getVida() - algoformerQueAtaca.getAtaque();
		if (vidaAux < 0) vidaAux = 0;
		this.setVida(vidaAux);
	}
}
