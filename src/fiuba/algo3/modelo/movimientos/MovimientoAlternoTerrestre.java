package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;

public class MovimientoAlternoTerrestre extends Movimiento{

	public MovimientoAlternoTerrestre(Tablero tablero) {
		super(tablero);
	}

	@Override
	public void afectarAlgoformer(Algoformer algoformer, Posicion posicion) {
		tablero.getCasillero(posicion).getSuperficieTierra().afectarAlgoformerAlterno(algoformer);
		
	}

}
