package fiuba.algo3.modelos.algoformers;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Turno;
import fiuba.algo3.modelos.excepciones.AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion;

public abstract class Decepticon extends Algoformer {

	public Decepticon(Posicion posicion, Tablero tablero, Turno turno) {
		super(posicion, tablero, turno);
	}

	public void validarQueSePuedeAtacar(Algoformer otroAlgoformer) {
		if(otroAlgoformer.esDecepticon()) throw new AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion();
	}

	public boolean esDecepticon() {
		return true;
	}

	public boolean esAutobot() {
		return false;
	}

}
