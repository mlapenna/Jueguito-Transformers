package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public class Espinas extends Tierra {
	public static String SUPERFICIE = "espinas";
	public static final int DANIO = 5;
	
	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		int vida = algoformer.getVida();
		int vidaAux = ( vida - ( (DANIO / 100) * vida ) );
		algoformer.setVida(vidaAux);
	}
	
	
}
