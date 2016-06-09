package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;

public class Pantano extends Tierra {
	
	public Pantano(){
		this.superficie = pantano;
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {
		//algoformer.tardarElDoble();		
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		//throw MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion; (ME TIRA ERROR)
	} 


}
