package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;

public class MovimientoAlternoTerrestre extends Movimiento{

	@Override
	public void afectarAlgoformer(Algoformer algoformer, Tablero tablero, Posicion posicion) {
		tablero.getCasillero(posicion).getSuperficieTierra().afectarAlgoformerAlterno(algoformer);
		
	}

}
