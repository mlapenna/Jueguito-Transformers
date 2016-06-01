package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Ratchet extends Autobot {
	private static final int ataqueRatchetHumanoide = 5;
	private static final int distanciaAtaqueRatchetHumanoide = 5;
	private static final int velocidadRatchetHumanoide = 1;
	private static final int ataqueRatchetAlterno = 35;
	private static final int distanciaAtaqueRatchetAlterno = 2;
	private static final int velocidadRatchetAlterno = 8;
	private static final int VIDARATCHET = 150;
	
	public Ratchet(Posicion posicion){
		this.vida=VIDARATCHET;
		this.movimiento = new MovimientoHumanoide();
		this.posicion = posicion;
	}
	private int ataque = ataqueRatchetHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueRatchetHumanoide;
	private int velocidad = velocidadRatchetHumanoide;
	
	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ataqueRatchetHumanoide;
		this.distanciaDeAtaque=distanciaAtaqueRatchetHumanoide;
		this.velocidad=velocidadRatchetHumanoide;
	}
	
	public void transformarAlterno(){
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque=ataqueRatchetAlterno;
		this.distanciaDeAtaque=distanciaAtaqueRatchetAlterno;
		this.velocidad=velocidadRatchetAlterno;
	}

	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyRatchet();
    };

    public boolean soyRatchet() { return true; }

}
