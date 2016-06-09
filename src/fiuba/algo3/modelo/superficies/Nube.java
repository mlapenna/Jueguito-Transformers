package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public class Nube extends Aire{
	
	public Nube(){
		this.superficie = NUBE;
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {
		//NO AFECTA
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		//NO AFECTA
	}
	
}
