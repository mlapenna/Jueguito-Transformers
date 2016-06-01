package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Ratchet extends Autobot {
	private static final int ataqueRatchetHumanoide = 5;
	private static final int distanciaAtaqueRatchetHumanoide = 5;
	private static final int VelocidadRatchetHumanoide = 1;
	private static final int ataqueRatchetAlterno = 35;
	private static final int distanciaAtaqueRatchetAlterno = 2;
	private static final int VelocidadRatchetAlterno = 8;
	private static final int VIDARATCHET = 150;
	
	public Ratchet(){
		this.vida=VIDARATCHET;
	}
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyRatchet();
    };

    public boolean soyRatchet() { return true; }

	@Override
	public void transformarHumanoide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformarAlterno() {
		// TODO Auto-generated method stub
		
	}
}
