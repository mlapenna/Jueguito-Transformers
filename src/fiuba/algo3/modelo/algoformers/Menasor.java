package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.algoformers.Decepticon;
import fiuba.algo3.modelo.movimientos.MovimientoHumanoide;
import fiuba.algo3.modelo.excepciones.MenasorNoPuedeTransformarseExcepcion;

public class Menasor extends Decepticon {
	private static final int DISTANCIA_ATAQUE = 2;
	private static final int ATAQUE = 115;
	private static final int VELOCIDAD = 2;
	private static final int VIDA = 2;
	
	public Menasor(Posicion posicion, Tablero tablero) {
		super(posicion, tablero);
		this.vida = VIDA;
		this.ataque = ATAQUE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE;
		this.velocidad = VELOCIDAD;
		this.movimiento = new MovimientoHumanoide();
	}

	public void transformarHumanoide() {
		throw new MenasorNoPuedeTransformarseExcepcion();
	}
	
	public void transformarAlterno(){
		throw new MenasorNoPuedeTransformarseExcepcion();
	}
}
