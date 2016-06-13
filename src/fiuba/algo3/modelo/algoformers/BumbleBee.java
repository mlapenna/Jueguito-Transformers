package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.algoformers.Autobot;
import fiuba.algo3.modelo.movimientos.MovimientoHumanoide;
import fiuba.algo3.modelo.movimientos.MovimientoAlternoTerrestre;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsAlternoExcepcion;

public class BumbleBee extends Autobot {
	private static final int ATAQUE_HUMANOIDE = 40;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 1;
	private static final int VELOCIDAD_HUMANOIDE = 2;
	private static final int ATAQUE_ALTERNO = 20;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 3;
	private static final int VELOCIDAD_ALTERNO = 5;
	private static final int VIDA = 350;
	
	public BumbleBee(Posicion posicion, Tablero tablero) {
		super(posicion, tablero);
		this.vida = VIDA;
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.movimiento = new MovimientoHumanoide();
	}
	
  	@Override
	public void transformarHumanoide() {
  		this.validarQueNoSoyHumanoide();
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad=VELOCIDAD_HUMANOIDE;
		this.modo = MODO_HUMANOIDE;
	}

	@Override
	public void transformarAlterno() {
		this.validarQueNoSoyAlterno();
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque=ATAQUE_ALTERNO;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad=VELOCIDAD_ALTERNO;
		this.modo = 1;
	}
	
	@Override
	public Algoformer clonarAlgoformer() {
		Algoformer clon = new BumbleBee(this.getPosicion(),this.tablero);
		this.copiarA(clon);
		return clon;	
	}

}
