package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Menasor {
	private static final int distanciaAtaqueMenasor = 2;
	private static final int ataqueMenasor = 115;
	private static final int velocidadMenasor = 2;
	
	public Menasor(){
		this.vida = 1; //HACER METODO OBTENER VIDAS TOTALES
		this.movimiento = new MovimientoHumanoide();
	}
	private int vida;
	private Movimiento movimiento;
	private int ataque = ataqueMenasor;
	private int distanciaDeAtaque = distanciaAtaqueMenasor;
	private int velocidad = velocidadMenasor;
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyMenasor();
    };

    public boolean soyMenasor() { return true; }
}
