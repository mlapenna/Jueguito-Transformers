package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.algoformers.Autobot;
import fiuba.algo3.modelo.MovimientoHumanoide;
import fiuba.algo3.modelo.MovimientoAlternoTerrestre;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsAlternoExcepcion;

public class Ratchet extends Autobot {
	private static final int ATAQUE_HUMANOIDE = 5;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 5;
	private static final int VELOCIDAD_HUMANOIDE = 1;
	private static final int ATAQUE_ALTERNO = 35;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 2;
	private static final int VELOCIDAD_ALTERNO = 8;
	private static final int VIDA = 150;
	
	public Ratchet() {
		this.vida = VIDA;
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.movimiento = new MovimientoHumanoide();
		this.modo = "humanoide";
	}
	
	public void transformarHumanoide() {
		this.validarQueNoSoyHumanoide();
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad=VELOCIDAD_HUMANOIDE;
		this.modo = "humanoide";
	}
	
	public void transformarAlterno(){
		this.validarQueNoSoyAlterno();
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque=ATAQUE_ALTERNO;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad=VELOCIDAD_ALTERNO;
		this.modo = "alterno";
	}

}
