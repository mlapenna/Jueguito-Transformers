package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public abstract class Superficie {

	public abstract void afectarAlgoformerHumanoide(Algoformer algoformer);
	
	public abstract void afectarAlgoformerAlterno(Algoformer algoformer);

	public abstract String getNombreJSON();
	public abstract String getNombre();
}
