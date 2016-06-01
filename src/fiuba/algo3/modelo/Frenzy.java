package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Frenzy extends Decepticon {
	private static final int ataqueFrenzyHumanoide = 10;
	private static final int distanciaAtaqueFrenzyHumanoide = 5;
	private static final int VelocidadFrenzyHumanoide = 2;
	private static final int ataqueFrenzyAlterno = 25;
	private static final int distanciaAtaqueFrenzyAlterno = 2;
	private static final int VelocidadFrenzyAlterno = 6;
	private static final int VIDAFRENZY = 400;
	
	public Frenzy(){
		this.vida = VIDAFRENZY;
	}
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyFrenzy();
    };

    public boolean soyFrenzy() { return true; }

	@Override
	public void transformarHumanoide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformarAlterno() {
		// TODO Auto-generated method stub
		
	}
}
