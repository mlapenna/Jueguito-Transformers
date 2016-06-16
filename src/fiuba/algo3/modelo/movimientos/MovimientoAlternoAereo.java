package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;

public class MovimientoAlternoAereo extends Movimiento{

	public MovimientoAlternoAereo(Tablero tablero) {
		super(tablero);
	}

	@Override
	public void afectarAlgoformer(Algoformer algoformer, Posicion posicion) {
		tablero.getCasillero(posicion).getSuperficieAire().afectarAlgoformerAlterno(algoformer);		
	}
	
}
