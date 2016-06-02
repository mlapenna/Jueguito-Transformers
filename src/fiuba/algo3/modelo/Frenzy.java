package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Frenzy extends Decepticon {
	private static final int ATAQUE_HUMANOIDE = 10;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 5;
	private static final int VELOCIDAD_HUMANOIDE = 2;
	private static final int ATAQUE_ALTERNO = 25;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 2;
	private static final int VELOCIDAD_ALTERNO = 6;
	private static final int VIDA = 400;
	
	public Frenzy(Posicion posicion){
		this.vida = VIDA;
		this.movimiento = new MovimientoHumanoide();
		this.posicion = posicion;
	}
	private int ataque = ATAQUE_HUMANOIDE;
	private int distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
	private int velocidad = this.VELOCIDAD_HUMANOIDE;

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
