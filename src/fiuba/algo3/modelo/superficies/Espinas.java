package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.algoformers.Algoformer;

public class Espinas extends Tierra {
	public static String SUPERFICIE = "espinas";
	public static final String NOMBRE_JSON = "Espinas";
	public static final double DANIO = 0.05;
	
	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		
		double vida = (double) algoformer.getVida();
		int vidaAux = (int) ( vida - ( DANIO * vida ) );
		algoformer.afectarVida(vidaAux);
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) { //FUNCIION PRIVADA!!!
		double vida = (double) algoformer.getVida();
		int vidaAux = (int) ( vida - ( DANIO * vida ) );
		algoformer.afectarVida(vidaAux);
	}
	
}
