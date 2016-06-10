package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.algoformers.Algoformer;

public abstract class Decepticon extends Algoformer {

	public boolean puedeAtacarA(Algoformer otroAlgoformer) {
		return !otroAlgoformer.esDecepticon();
	}

	public boolean esDecepticon() {
		return true;
	}

}
