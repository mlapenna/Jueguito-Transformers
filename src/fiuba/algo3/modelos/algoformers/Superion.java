package fiuba.algo3.modelos.algoformers;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Turno;
import fiuba.algo3.modelos.movimientos.Movimiento;
import fiuba.algo3.modelos.movimientos.MovimientoAlternoTerrestre;

public class Superion extends Autobot {
	public static final String nombreAlgoformer = "Superion";
	private static final int DISTANCIA_ATAQUE = 2;
	private static final int ATAQUE = 100;
	private static final int VELOCIDAD = 3;
	private static final int VIDA = 3; // hay que ver el proceso de fusion
	
	public Superion(Posicion posicion, Tablero tablero, Turno turno) {
		super(posicion, tablero, turno);
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
	
	public int getVidaInicial() {
		return VIDA;
	}

	@Override
	public Algoformer clonarAlgoformer() {
		Algoformer clon = new Superion(this.getPosicion(), this.modo.getTablero(), this.turno);
		this.copiarA(clon);
		return clon;	
	}

	@Override
	public Movimiento getMovimientoAlterno() {
		return new MovimientoAlternoTerrestre(this.modo.getTablero());
	}
	
	public String getNombre() {
		return this.nombreAlgoformer;
	}

	public boolean esUnRobotCombinado() {
		return true;
	}
}
