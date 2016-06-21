package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public class Rocas extends Tierra {
	public static final String NOMBRE_JSON = "Rocas";

	public Rocas(){
		this.superficie = NOMBRE_JSON;
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		//NO AFECTA
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {
		//NO AFECTA
		
	}

}
