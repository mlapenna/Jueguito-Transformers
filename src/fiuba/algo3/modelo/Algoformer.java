package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Movimiento;
import fiuba.algo3.modelo.Posicion;

public abstract class Algoformer {
	static final String modoHumanoide = "humanoide";
	static final String modoAlterno = "alterno";
	static final int MODO_AUTOBOT = 0;
	static final int MODO_DECEPTICON = 1;
	static final int TOTAL_ROBOTS_DISPONIBLES_POR_TIPO = 4;
	
	protected int vida;
	protected Movimiento movimiento;
	protected Posicion posicion;
	
	public abstract void transformarHumanoide(); //redefinida en cada Algoformer
	
	public abstract void transformarAlterno(); //redefinida en cada Algoformer
	
	public void agregarATablero() {

	} 
	
	//public void moverNuevaPosicion(Posicion nuevaPosicion){
	//	this.movimiento.moverPosicionAlgoformer(this,nuevaPosicion);
	//}

	// Patr�n doble dispatch
	public abstract boolean esDelMismoTipoQue(Algoformer unRobot);
	public boolean soyOptimus() { return false; }
	public boolean soyBumbleBee() { return false; }
	public boolean soyRatchet() { return false; }
	public boolean soySuperion() { return false; }
	public boolean soyMegatron() { return false; }
	public boolean soyBonecrusher() { return false; }
	public boolean soyFrenzy() { return false; }
	public boolean soyMenasor() { return false; }

	public Posicion obtenerPosicion(){  //NO PARECE HACER NADA
		return this.posicion;		
	}
	
	public void cargarNuevaPosicion(Posicion posicion){
		this.posicion=posicion;
	}

	public int getVida() {
		return this.vida;
	}

	public void reducirVida(int ataque) {
		this.vida = this.vida - ataque;
		//if (this.getVida()<0)
		//	this.morir();
		
	}

}
