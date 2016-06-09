package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public abstract class Superficie {
	
	protected String superficie;
	
	public String getSuperficie(){
		return this.superficie;
	}
	
	public abstract void afectarAlgoformer(Algoformer algoformer);
}
