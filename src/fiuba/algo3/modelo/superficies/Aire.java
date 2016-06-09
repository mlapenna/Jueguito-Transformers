package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public abstract class Aire extends Superficie{
	static final String NUBE="nube";
	static final String NEBULOSA_DE_ANDROMEDA ="nebulosaDeAndromeda";
	static final String TORMENTA_PSIONICA="tormentaPsiconica";
	
	public abstract void afectarAlgoformerHumanoide(Algoformer algoformer);

	public abstract void afectarAlgoformerAlterno(Algoformer algoformer);
	
}