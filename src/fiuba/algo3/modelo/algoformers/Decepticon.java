package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoFriendlyFireNoEstaHabilitado;

public abstract class Decepticon extends Algoformer {

	public Decepticon(Posicion posicion, Tablero tablero) {
		super(posicion, tablero);
	}

	public void validarQueSePuedeAtacar(Algoformer otroAlgoformer) {
		if(otroAlgoformer.esDecepticon()) throw new AtaqueInvalidoFriendlyFireNoEstaHabilitado();
	}

	public boolean esDecepticon() {
		return true;
	}

	public boolean esAutobot() {
		return false;
	}
}
