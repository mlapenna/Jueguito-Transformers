package fiuba.algo3.modelos.algoformers;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Turno;
import fiuba.algo3.modelos.movimientos.Movimiento;
import fiuba.algo3.modelos.movimientos.MovimientoAlternoTerrestre;

public class Frenzy extends Decepticon {
	private static final int ATAQUE_HUMANOIDE = 10;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 5;
	private static final int VELOCIDAD_HUMANOIDE = 2;
	private static final int ATAQUE_ALTERNO = 25;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 2;
	private static final int VELOCIDAD_ALTERNO = 6;
	private static final int VIDA = 400;


	public Frenzy(Posicion posicion, Tablero tablero, Turno turno) {
		super(posicion, tablero, turno);
		this.vida = VIDA;
	}

	public int getAtaqueInicialHumanoide() {
		return ATAQUE_HUMANOIDE;
	}
	public int getDistanciaAtaqueHumanoide() {
		return DISTANCIA_ATAQUE_HUMANOIDE;
	}
	public int getVelocidadHumanoide() {
		return VELOCIDAD_HUMANOIDE;
	}
	public int getAtaqueInicialAlterno() {
		return ATAQUE_ALTERNO;
	}
	public int getDistanciaAtaqueAlterno() {
		return DISTANCIA_ATAQUE_ALTERNO;
	}
	public int getVelocidadAlterno() {
		return VELOCIDAD_ALTERNO;
	}

	@Override
	public Algoformer clonarAlgoformer() {
		Algoformer clon = new Frenzy(this.getPosicion(), this.tablero, this.turno);
		this.copiarA(clon);
		return clon;	
	}

	@Override
	public Movimiento getMovimientoAlterno() {
		return new MovimientoAlternoTerrestre(this.tablero);
	}


}
