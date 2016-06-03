package fiuba.algo3.modelo;

public class Superion {
	private static final int DISTANCIA_ATAQUE = 2;
	private static final int ATAQUE = 100;
	private static final int VELOCIDAD = 3;
	
	public Superion() {
		this.vida = 1; //HACER METODO OBTENER VIDAS TOTALES
		this.movimiento = new MovimientoHumanoide();
	}

	private Posicion posicion;
	private int vida;
	private Movimiento movimiento;
	private int ataque = ATAQUE;
	private int distanciaDeAtaque = DISTANCIA_ATAQUE;
	private int velocidad = VELOCIDAD;

}
