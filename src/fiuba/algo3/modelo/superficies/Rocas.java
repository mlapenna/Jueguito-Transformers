package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public class Rocas extends Tierra {
	public static final string NOMBRE_JSON = "Rocas";

	public Rocas(){
		this.superficie = rocas;
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
