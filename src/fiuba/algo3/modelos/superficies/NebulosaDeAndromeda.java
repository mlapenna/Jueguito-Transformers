package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public class NebulosaDeAndromeda extends Aire {
	public static final String NOMBRE_JSON = "NebulosaDeAndromeda";
	public static final int TURNOS_ATRAPADO = 3;
	
	public NebulosaDeAndromeda(){
		this.superficie = NEBULOSA_DE_ANDROMEDA;
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {
		algoformer.establecerTurnosAtrapado(TURNOS_ATRAPADO);
		
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		//NO AFECTA
	}
}
