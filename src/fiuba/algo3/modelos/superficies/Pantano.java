package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;

public class Pantano extends Tierra {
	public static final String NOMBRE = "Pantano";
	public static final String NOMBRE_JSON = "Pantano";

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {
		//if(!algoformer.movimientoDisminuido())
			algoformer.disminuirMovimientoEsteTurno();
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		throw new MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion();
	}


	public String getNombre() {
		return NOMBRE;
	}

	public String getNombreJSON() {
		return NOMBRE_JSON;
	}



}
