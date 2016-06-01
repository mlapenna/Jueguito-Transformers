package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Frenzy extends Decepticon {
	private static final int ataqueFrenzyHumanoide = 10;
	private static final int distanciaAtaqueFrenzyHumanoide = 5;
	private static final int velocidadFrenzyHumanoide = 2;
	private static final int ataqueFrenzyAlterno = 25;
	private static final int distanciaAtaqueFrenzyAlterno = 2;
	private static final int velocidadFrenzyAlterno = 6;
	private static final int VIDAFRENZY = 400;
	
	public Frenzy(){
		this.vida = VIDAFRENZY;
	}
	private int ataque = ataqueFrenzyHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueFrenzyHumanoide;
	private int velocidad = velocidadFrenzyHumanoide;
	
	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ataqueFrenzyHumanoide;
		this.distanciaDeAtaque=distanciaAtaqueFrenzyHumanoide;
		this.velocidad=velocidadFrenzyHumanoide;
	}
	
	public void transformarAlterno(){
		this.movimiento = new MovimientoAlterno();
		this.ataque=ataqueFrenzyAlterno;
		this.distanciaDeAtaque=distanciaAtaqueFrenzyAlterno;
		this.velocidad=velocidadFrenzyAlterno;
	}

	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyFrenzy();
    };

    public boolean soyFrenzy() { return true; }


}
