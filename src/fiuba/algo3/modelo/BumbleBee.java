package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class BumbleBee extends Autobot {
	private static final int ataqueBumbleBeeHumanoide = 40;
	private static final int distanciaAtaqueBumbleBeeHumanoide = 1;
	private static final int VelocidadBumbleBeeHumanoide = 2;
	private static final int ataqueBumbleBeeAlterno = 20;
	private static final int distanciaAtaqueBumbleBeeAlterno = 3;
	private static final int VelocidadBumbleBeeAlterno = 5;
	private static final int VIDABUMBLEBEE = 350;
	
	public BumbleBee(){
		this.vida = VIDABUMBLEBEE;
	}
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyBumbleBee();
    };

    public boolean soyBumbleBee() { return true; }

	@Override
	public void transformarHumanoide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformarAlterno() {
		// TODO Auto-generated method stub
		
	}
}
