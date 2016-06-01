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
	}
	
	private int ataque = ataqueBonecrusherHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueBonecrusherHumanoide;
	private int Velocidad = velocidadBonecrusherHumanoide;
	
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyBonecrusher();
    };

    public boolean soyBonecrusher() { return true; }

	@Override
	public void transformarHumanoide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformarAlterno() {
		// TODO Auto-generated method stub
		
	}
}
