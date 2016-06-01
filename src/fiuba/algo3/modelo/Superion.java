package fiuba.algo3.modelo;

public class Superion {
	private static final int distanciaAtaqueSuperion = 2;
	private static final int ataqueSuperion = 100;
	private static final int velocidadSuperion = 3;
	
	public Superion(){
		this.vida = 1; //HACER METODO OBTENER VIDAS TOTALES
		this.movimiento = new MovimientoHumanoide();
	}
	private int vida;
	private Movimiento movimiento;
	private int ataque = ataqueSuperion;
	private int distanciaDeAtaque = distanciaAtaqueSuperion;
	private int velocidad = velocidadSuperion;
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soySuperion();
    };

    public boolean soySuperion() { return true; }
}
