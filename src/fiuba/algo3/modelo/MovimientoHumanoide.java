package fiuba.algo3.modelo;

public class MovimientoHumanoide extends Movimiento{
	
	@Override  
	public void moverPosicionAlgoformerHorizontalDerecha(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.obtenerPosicion();
		Posicion posicionAuxiliar = new Posicion();
		int fila = posicionInicial.obtenerPosicionY();
		for (int i=posicionInicial.obtenerPosicionX(); i>=nuevaPosicion.obtenerPosicionX(); i++)
		{
			//try{
				posicionAuxiliar.cargarPosicion(i, fila);
				this.tablero.moverAlgoformerHumanoide(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}
	
	@Override
	public void moverPosicionAlgoformerHorizontalIzquierda(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.obtenerPosicion();
		Posicion posicionAuxiliar = new Posicion();
		int fila = posicionInicial.obtenerPosicionY();
		for (int i=posicionInicial.obtenerPosicionX(); i<=nuevaPosicion.obtenerPosicionX(); i--)
		{
			//try{
				posicionAuxiliar.cargarPosicion(i, fila);
				this.tablero.moverAlgoformerHumanoide(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}

}
