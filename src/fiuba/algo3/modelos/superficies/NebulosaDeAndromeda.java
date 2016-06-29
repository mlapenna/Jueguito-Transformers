package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public class NebulosaDeAndromeda extends Aire {
	public static final String NOMBRE = "NebulosaDeAndromeda";
	public static final String NOMBRE_JSON = "NebulosaDeAndromeda";
	public static final int TURNOS_ATRAPADO = 3;
	
	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {
		algoformer.establecerTurnosAtrapado(TURNOS_ATRAPADO);
		
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		//NO AFECTA
	}


	public String getNombre() {
		return NOMBRE;
	}

	public String getNombreJSON() {
		return NOMBRE_JSON;
	}
}
