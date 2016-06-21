package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public abstract class Superficie {
	
	protected String superficie;
	
	public String getSuperficie(){
		return this.superficie;
	}
	
	public abstract void afectarAlgoformerHumanoide(Algoformer algoformer);
	
	public abstract void afectarAlgoformerAlterno(Algoformer algoformer);
}
