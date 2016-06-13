package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion;

public abstract class Autobot extends Algoformer {

	public Autobot(Posicion posicion, Tablero tablero) {
		super(posicion, tablero);
	}

	public void validarQueSePuedeAtacar(Algoformer otroAlgoformer) {
		if(otroAlgoformer.esAutobot()) throw new AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion();
	}

	public boolean esAutobot() {
		return true;
	}

	public boolean esDecepticon() {
		return false;
	}

}
