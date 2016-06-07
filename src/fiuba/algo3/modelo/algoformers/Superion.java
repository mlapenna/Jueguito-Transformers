package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.algoformers.Autobot;
import fiuba.algo3.modelo.MovimientoHumanoide;
import fiuba.algo3.modelo.SuperionNoPuedeTransformarseExcepcion;

public class Superion extends Autobot {
	private static final int DISTANCIA_ATAQUE = 2;
	private static final int ATAQUE = 100;
	private static final int VELOCIDAD = 3;
	private static final int VIDA = 3; // hay que ver el proceso de fusion
	
	public Superion() {
		this.vida = VIDA;
		this.ataque = ATAQUE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE;
		this.velocidad = VELOCIDAD;
		this.movimiento = new MovimientoHumanoide();
	}

	public void transformarHumanoide() {
		throw new SuperionNoPuedeTransformarseExcepcion();
	}
	
	public void transformarAlterno(){
		throw new SuperionNoPuedeTransformarseExcepcion();
	}

}
