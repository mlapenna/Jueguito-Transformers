package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.algoformers.Autobot;
import fiuba.algo3.modelo.MovimientoHumanoide;
import fiuba.algo3.modelo.MovimientoAlternoTerrestre;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsAlternoExcepcion;

public class BumbleBee extends Autobot {
	private static final int ATAQUE_HUMANOIDE = 40;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 1;
	private static final int VELOCIDAD_HUMANOIDE = 2;
	private static final int ATAQUE_ALTERNO = 20;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 3;
	private static final int VELOCIDAD_ALTERNO = 5;
	private static final int VIDA = 350;
	
	public BumbleBee() {
		this.vida = VIDA;
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.movimiento = new MovimientoHumanoide();
		this.modo = "humanoide";
	}
	
  	@Override
	public void transformarHumanoide() {
  		this.validarQueNoSoyHumanoide();
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad=VELOCIDAD_HUMANOIDE;
		this.modo = "humanoide";
	}

	@Override
	public void transformarAlterno() {
		this.validarQueNoSoyAlterno();
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque=ATAQUE_ALTERNO;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad=VELOCIDAD_ALTERNO;
		this.modo = "alterno";
	}
}
