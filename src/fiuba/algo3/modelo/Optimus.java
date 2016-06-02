package fiuba.algo3.modelo;

public class Optimus extends Autobot {
	private static final int ATAQUE_HUMANOIDE = 50;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 2;
	private static final int VELOCIDAD_HUMANOIDE = 2;
	private static final int ATAQUE_ALTERNO = 15;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 4;
	private static final int VELOCIDAD_ALTERNO = 2;
	private static final int VIDA = 500;
	
	public Optimus(Posicion posicion){
		this.vida = VIDA;
		this.movimiento = new MovimientoHumanoide(); 
		this.posicion = posicion;
	}
	
	private int ataque = ATAQUE_HUMANOIDE;
	private int distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
	private int velocidad = VELOCIDAD_HUMANOIDE;
	
	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
	}
	
	public void transformarAlterno(){
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque = ATAQUE_ALTERNO;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad = VELOCIDAD_ALTERNO;
	}

}
