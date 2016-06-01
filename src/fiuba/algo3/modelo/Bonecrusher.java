package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Bonecrusher extends Decepticon {
	private static final int ataqueBonecrusherHumanoide = 30;
	private static final int distanciaAtaqueBonecrusherHumanoide = 3;
	private static final int velocidadBonecrusherHumanoide = 1;
	private static final int ataqueBonecrusherAlterno = 30;
	private static final int distanciaAtaqueBonecrusherAlterno = 3;
	private static final int velocidadBonecrusherAlterno = 8;
	private static final int VIDABONECRUSHER=200;
	
	public Bonecrusher(){
		this.vida = VIDABONECRUSHER;
		this.movimiento = new MovimientoHumanoide();
	}
	private int ataque = ataqueBonecrusherHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueBonecrusherHumanoide;
	private int velocidad = velocidadBonecrusherHumanoide;
	
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyBonecrusher();
    };

    public boolean soyBonecrusher() { return true; }

	@Override
	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ataqueBonecrusherHumanoide;
		this.distanciaDeAtaque=distanciaAtaqueBonecrusherHumanoide;
		this.velocidad=velocidadBonecrusherHumanoide;
	}

	@Override
	public void transformarAlterno() {
		this.movimiento = new MovimientoAlterno();
		this.ataque=ataqueBonecrusherAlterno;
		this.distanciaDeAtaque=distanciaAtaqueBonecrusherAlterno;
		this.velocidad=velocidadBonecrusherAlterno;
	}
}
