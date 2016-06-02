package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Menasor {
	private static final int DISTANCIA_ATAQUE = 2;
	private static final int ATAQUE = 115;
	private static final int VELOCIDAD = 2;
	
	public Menasor(Posicion posicion){
		this.vida = 1; //HACER METODO OBTENER VIDAS TOTALES
		this.movimiento = new MovimientoHumanoide();
		this.posicion = posicion;
	}
	private Posicion posicion;
	private int vida;
	private Movimiento movimiento;
	private int ataque = ATAQUE;
	private int distanciaDeAtaque = DISTANCIA_ATAQUE;
	private int velocidad = VELOCIDAD;

}
