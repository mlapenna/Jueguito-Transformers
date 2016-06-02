package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Bonecrusher extends Decepticon {
	private static final int ATAQUE_HUMANOIDE = 30;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 3;
	private static final int VELOCIDAD_HUMANOIDE = 1;
	private static final int ATAQUE_ALTERNO = 30;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 3;
	private static final int VELOCIDAD_ALTERNO = 8;
	private static final int VIDA=200;
	
	public Bonecrusher(Posicion posicion){
		this.vida = VIDA;
		this.movimiento = new MovimientoHumanoide();
		this.posicion = posicion;
	}
	private int ataque = ATAQUE_HUMANOIDE;
	private int distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
	private int velocidad = VELOCIDAD_HUMANOIDE;

    @Override
	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
	}

	@Override
	public void transformarAlterno() {
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque=ATAQUE_ALTERNO;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad=VELOCIDAD_ALTERNO;
	}
}
