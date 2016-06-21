package fiuba.algo3.modelos.superficies;

import fiuba.algo3.modelos.algoformers.Algoformer;

public class Espinas extends Tierra {
	public static String SUPERFICIE = "espinas";
	public static final String NOMBRE_JSON = "Espinas";
	public static final double DANIO = 0.05;
	
	public Espinas(){
		this.superficie = NOMBRE_JSON;
	}

	private void afectarAlgoformerAmbosModos(Algoformer algoformer) {
		double vida = (double) algoformer.getVida();
		int vidaAux = (int) ( vida - ( DANIO * vida ) );
		algoformer.afectarVida(vidaAux);
	}

	@Override
	public void afectarAlgoformerHumanoide(Algoformer algoformer) {
		this.afectarAlgoformerAmbosModos(algoformer);
	}

	@Override
	public void afectarAlgoformerAlterno(Algoformer algoformer) { //FUNCIION PRIVADA!!!
		this.afectarAlgoformerAmbosModos(algoformer);
	}
	
}
