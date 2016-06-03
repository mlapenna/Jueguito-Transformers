package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Ratchet extends Autobot {
	private static final int ATAQUE_HUMANOIDE = 5;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 5;
	private static final int VELOCIDAD_HUMANOIDE = 1;
	private static final int ATAQUE_ALTERNO = 35;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 2;
	private static final int VELOCIDAD_ALTERNO = 8;
	private static final int VIDA = 150;
	
	public Ratchet() {
		this.vida=VIDA;
		this.movimiento = new MovimientoHumanoide();
	}

	private int ataque = ATAQUE_HUMANOIDE;
	private int distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
	private int velocidad = VELOCIDAD_HUMANOIDE;
	
	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad=VELOCIDAD_HUMANOIDE;
	}
	
	public void transformarAlterno(){
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque=ATAQUE_ALTERNO;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad=VELOCIDAD_ALTERNO;
	}

}
