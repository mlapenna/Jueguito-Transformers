package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public class TormentaPsionica extends Aire {
	public static final String NOMBRE_JSON = "TormentaPsionica";
	public static final double DANIO = 0.40;
	
	public TormentaPsionica(){
		this.superficie = TORMENTA_PSIONICA;
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {		
		if(!algoformer.afectadoPorTormentaPsionica()) {
			double ataque = (double) algoformer.getAtaque();
			int ataqueAux = (int) (  DANIO * ataque  );
			algoformer.afectarAtaque(ataqueAux);
			algoformer.afectarPorTormentaPsionica();
		}
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		//NO AFECTA		
	}

}
