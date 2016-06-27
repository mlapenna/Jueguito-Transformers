package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public class TormentaPsionica extends Aire {
	public static final String NOMBRE_JSON = "TormentaPsionica";
	public static final double DANIO = 0.40;
	
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

	public String getNombreJSON() {
		return NOMBRE_JSON;
	}

}
