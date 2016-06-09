package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public abstract class Tierra extends Superficie{
	static final String espinas="espinas";
	static final String rocas="rocas";
	static final String pantano="pantano";

	public abstract void afectarAlgoformer(Algoformer algoformer);

}
