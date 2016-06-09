package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public class TormentaPsiconica extends Aire {
	public static final int DANIO = 40;
	
	public TormentaPsiconica(){
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
