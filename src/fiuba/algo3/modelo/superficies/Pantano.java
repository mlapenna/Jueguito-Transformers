package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;

public class Pantano extends Tierra {
	public static final String NOMBRE_JSON = "Pantano";
	static final int TURNOS_ATRAPADO = 1;

	public Pantano(){
		this.superficie = pantano;
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {
		algoformer.establecerTurnosAtrapado(TURNOS_ATRAPADO);
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		throw new MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion();
	} 


}
