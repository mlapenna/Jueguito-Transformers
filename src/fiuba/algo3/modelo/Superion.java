package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Superion extends Decepticon {
	
	public Superion(){
		
	}
	
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soySuperion();
    };

    public boolean soySuperion() { return true; }

	@Override
	public void transformarHumanoide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformarAlterno() {
		// TODO Auto-generated method stub
		
	}
}
