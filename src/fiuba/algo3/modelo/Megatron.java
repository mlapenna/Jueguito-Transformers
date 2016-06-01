package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Megatron extends Decepticon {
	private static final int ataqueMegatronHumanoide = 10;
	private static final int distanciaAtaqueMegatronHumanoide = 3;
	private static final int VelocidadMegatronHumanoide = 1;
	private static final int ataqueMegatronAlterno = 55;
	private static final int distanciaAtaqueMegatronAlterno = 2;
	private static final int VelocidadMegatronAlterno = 8;
	private static final int VIDAMEGATRON = 550;
	
	public Megatron(){
		this.vida=VIDAMEGATRON;
	}
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyMegatron();
    };

    public boolean soyMegatron() { return true; }

	@Override
	public void transformarHumanoide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformarAlterno() {
		// TODO Auto-generated method stub
		
	}
}
