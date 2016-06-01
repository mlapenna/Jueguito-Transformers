package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Megatron extends Decepticon {
	private static final int ataqueMegatronHumanoide = 10;
	private static final int distanciaAtaqueMegatronHumanoide = 3;
	private static final int velocidadMegatronHumanoide = 1;
	private static final int ataqueMegatronAlterno = 55;
	private static final int distanciaAtaqueMegatronAlterno = 2;
	private static final int velocidadMegatronAlterno = 8;
	private static final int VIDAMEGATRON = 550;
	
	public Megatron(){
		this.vida=VIDAMEGATRON;
	}
	private int ataque = ataqueMegatronHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueMegatronHumanoide;
	private int velocidad = velocidadMegatronHumanoide;
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyMegatron();
    };

    public boolean soyMegatron() { return true; }

	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque = ataqueMegatronHumanoide;
		this.distanciaDeAtaque = distanciaAtaqueMegatronHumanoide;
		this.velocidad = velocidadMegatronHumanoide;
	}
	
	public void transformarAlterno(){
		this.movimiento = new MovimientoAlterno();
		this.ataque = ataqueMegatronAlterno;
		this.distanciaDeAtaque = distanciaAtaqueMegatronAlterno;
		this.velocidad = velocidadMegatronAlterno;
	}
}
