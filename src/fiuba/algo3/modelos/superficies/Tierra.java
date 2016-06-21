package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public abstract class Tierra extends Superficie{
	static final String espinas="espinas";
	static final String rocas="rocas";
	static final String pantano="pantano";

	public abstract void afectarAlgoformerHumanoide(Algoformer algoformer);

	public abstract void afectarAlgoformerAlterno(Algoformer algoformer);
}
