package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public class TormentaPsionica extends Aire {
	public static final String NOMBRE_JSON = "TormentaPsionica";
	public static final int DANIO = 40;
	
	public TormentaPsionica(){
		this.superficie = TORMENTA_PSIONICA;
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) {
		int vida = algoformer.getVida();
		int vidaAux = ( vida - ( DANIO / 100) * vida );
		algoformer.setVida(vidaAux);
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		//NO AFECTA		
	}

}
