package fiuba.algo3.modelos.algoformers;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Turno;
import fiuba.algo3.modelos.movimientos.Movimiento;
import fiuba.algo3.modelos.movimientos.MovimientoAlternoAereo;

public class Megatron extends Decepticon {
	public static final String nombreAlgoformer = "Megatron";
	private static final int ATAQUE_HUMANOIDE = 10;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 3;
	private static final int VELOCIDAD_HUMANOIDE = 1;
	private static final int ATAQUE_ALTERNO = 55;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 2;
	private static final int VELOCIDAD_ALTERNO = 8;
	private static final int VIDA = 550;
	
	public Megatron(Posicion posicion, Tablero tablero, Turno turno) {
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
		Algoformer clon = new Megatron(this.getPosicion(), this.modo.getTablero(), this.turno);
		this.copiarA(clon);
		return clon;	
	}

	@Override
	public Movimiento getMovimientoAlterno() {
		return new MovimientoAlternoAereo(this.modo.getTablero());
	}


}
