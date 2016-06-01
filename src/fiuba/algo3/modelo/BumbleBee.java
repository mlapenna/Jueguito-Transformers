package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class BumbleBee extends Autobot {
	private static final int ataqueBumbleBeeHumanoide = 40;
	private static final int distanciaAtaqueBumbleBeeHumanoide = 1;
	private static final int velocidadBumbleBeeHumanoide = 2;
	private static final int ataqueBumbleBeeAlterno = 20;
	private static final int distanciaAtaqueBumbleBeeAlterno = 3;
	private static final int velocidadBumbleBeeAlterno = 5;
	private static final int VIDABUMBLEBEE = 350;
	
	public BumbleBee(Posicion posicion){
		this.vida = VIDABUMBLEBEE;
		this.movimiento = new MovimientoHumanoide();
		this.posicion = posicion;
	}
	private int ataque = ataqueBumbleBeeHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueBumbleBeeHumanoide;
	private int velocidad = velocidadBumbleBeeHumanoide;
	
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyBumbleBee();
    };

    public boolean soyBumbleBee() { return true; }

	@Override
	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ataqueBumbleBeeHumanoide;
		this.distanciaDeAtaque=distanciaAtaqueBumbleBeeHumanoide;
		this.velocidad=velocidadBumbleBeeHumanoide;
	}

	@Override
	public void transformarAlterno() {
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque=ataqueBumbleBeeAlterno;
		this.distanciaDeAtaque=distanciaAtaqueBumbleBeeAlterno;
		this.velocidad=velocidadBumbleBeeAlterno;
	}
}
