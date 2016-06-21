package fiuba.algo3.modelos.movimientos;

import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;

public class MovimientoAlternoTerrestre extends Movimiento{

	public MovimientoAlternoTerrestre(Tablero tablero) {
		super(tablero);
	}

	@Override
	public void afectarAlgoformer(Algoformer algoformer, Posicion posicion) {
		tablero.getCasillero(posicion).getSuperficieTierra().afectarAlgoformerAlterno(algoformer);
		
	}

}
