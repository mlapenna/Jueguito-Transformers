package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.algoformers.Algoformer;

public abstract class Decepticon extends Algoformer {

	public Decepticon(Posicion posicion, Tablero tablero) {
		super(posicion, tablero);
	}

	public boolean puedeAtacarA(Algoformer otroAlgoformer) {
		return !otroAlgoformer.esDecepticon();
	}

	public boolean esDecepticon() {
		return true;
	}

}
