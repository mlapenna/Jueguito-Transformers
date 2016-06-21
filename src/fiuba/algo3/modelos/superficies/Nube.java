package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public class Nube extends Aire {
	public static final String NOMBRE_JSON = "Nube";

	public Nube(){
		this.superficie = NOMBRE_JSON;
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
