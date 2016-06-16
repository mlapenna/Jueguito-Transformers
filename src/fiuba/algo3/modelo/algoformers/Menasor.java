package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.movimientos.MovimientoAlternoTerrestre;

public class Menasor extends Decepticon {
	private static final int DISTANCIA_ATAQUE = 2;
	private static final int ATAQUE = 115;
	private static final int VELOCIDAD = 2;
	private static final int VIDA = 2;
	
	public Menasor(Posicion posicion, Tablero tablero) {
		super(posicion, tablero);
		this.vida = VIDA;
	}


	public int getAtaqueInicialHumanoide() {
		return ATAQUE;
	}
	public int getDistanciaAtaqueHumanoide() {
		return DISTANCIA_ATAQUE;
	}
	public int getVelocidadHumanoide() {
		return VELOCIDAD;
	}
	public int getAtaqueInicialAlterno() {
		return ATAQUE;
	}
	public int getDistanciaAtaqueAlterno() {
		return DISTANCIA_ATAQUE;
	}
	public int getVelocidadAlterno() {
		return VELOCIDAD;
	}

	@Override
	public Algoformer clonarAlgoformer() {
		Algoformer clon = new Menasor(this.getPosicion(),this.tablero);
		this.copiarA(clon);
		return clon;	
	}

	@Override
	public Movimiento getMovimientoAlterno() {
		return new MovimientoAlternoTerrestre(this.tablero);
	}

}
