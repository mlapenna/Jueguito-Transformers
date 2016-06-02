package fiuba.algo3.modelo;

public class MovimientoAlternoTerrestre extends Movimiento{

	@Override  
	public void moverPosicionAlgoformerHorizontalDerecha(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.obtenerPosicion();
		Posicion posicionAuxiliar = new Posicion();
		int fila = posicionInicial.obtenerPosicionY();
		for (int i=posicionInicial.obtenerPosicionX(); i<=nuevaPosicion.obtenerPosicionX(); i++)
		{
			//try{
				posicionAuxiliar.cargarPosicion(i, fila);
				this.tablero.moverAlgoformerAlternoTerrestre(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}
	
	@Override
	public void moverPosicionAlgoformerHorizontalIzquierda(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.obtenerPosicion();
		Posicion posicionAuxiliar = new Posicion();
		int columna = posicionInicial.obtenerPosicionY();
		for (int i=posicionInicial.obtenerPosicionX(); i>=nuevaPosicion.obtenerPosicionX(); i--)
		{
			//try{
				posicionAuxiliar.cargarPosicion(i, columna);
				this.tablero.moverAlgoformerAlternoTerrestre(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}

	@Override
	public void moverPosicionAlgoformerVerticalArriba(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.obtenerPosicion();
		Posicion posicionAuxiliar = new Posicion();
		int fila = posicionInicial.obtenerPosicionX();
		for (int i=posicionInicial.obtenerPosicionY(); i<=nuevaPosicion.obtenerPosicionY(); i++)
		{
			//try{
				posicionAuxiliar.cargarPosicion(fila, i);
				this.tablero.moverAlgoformerAlternoTerrestre(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}
	
	@Override
	public void moverPosicionAlgoformerVerticalAbajo(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.obtenerPosicion();
		Posicion posicionAuxiliar = new Posicion();
		int fila = posicionInicial.obtenerPosicionX();
		for (int i=posicionInicial.obtenerPosicionY(); i>=nuevaPosicion.obtenerPosicionY(); i--)
		{
			//try{
				posicionAuxiliar.cargarPosicion(fila, i);
				this.tablero.moverAlgoformerAlternoTerrestre(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}


}
