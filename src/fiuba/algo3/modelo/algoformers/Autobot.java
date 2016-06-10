package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;

public abstract class Autobot extends Algoformer {

	public Autobot(Posicion posicion, Tablero tablero) {
		super(posicion, tablero);
	}

	public boolean puedeAtacarA(Algoformer otroAlgoformer) {
		return !otroAlgoformer.esAutobot();
	}

	public boolean esAutobot() {
		return true;
	}

	public boolean esDecepticon() {
		return false;
	}

}
