package fiuba.algo3.modelos.algoformers;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.movimientos.Movimiento;
import fiuba.algo3.modelos.movimientos.MovimientoAlternoTerrestre;

public class Superion extends Autobot {
	private static final int DISTANCIA_ATAQUE = 2;
	private static final int ATAQUE = 100;
	private static final int VELOCIDAD = 3;
	private static final int VIDA = 3; // hay que ver el proceso de fusion
	
	public Superion(Posicion posicion, Tablero tablero) {
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
		Algoformer clon = new Superion(this.getPosicion(),this.tablero);
		this.copiarA(clon);
		return clon;	
	}

	@Override
	public Movimiento getMovimientoAlterno() {
		return new MovimientoAlternoTerrestre(this.tablero);
	}
}
