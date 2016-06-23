package fiuba.algo3.modelos.algoformers;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Turno;
import fiuba.algo3.modelos.excepciones.AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion;

public abstract class Autobot extends Algoformer {

	public Autobot(Posicion posicion, Tablero tablero, Turno turno) {
		super(posicion, tablero, turno);
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
