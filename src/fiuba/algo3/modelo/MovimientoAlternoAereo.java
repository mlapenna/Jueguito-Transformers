package fiuba.algo3.modelo;

import fiuba.algo3.modelo.MovimientoAlterno;

public class MovimientoAlternoAereo extends MovimientoAlterno{

	@Override  
	public void moverPosicionAlgoformerHorizontalDerecha(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.getPosicion();
		Posicion posicionAuxiliar = new Posicion(0, 0);
		int fila = posicionInicial.obtenerPosicionY();
		for (int i=posicionInicial.obtenerPosicionX(); i<=nuevaPosicion.obtenerPosicionX(); i++)
		{
			//try{
				posicionAuxiliar.setCoordenadas(i, fila);
				this.tablero.moverAlgoformerAlternoAereo(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}
	
	@Override
	public void moverPosicionAlgoformerHorizontalIzquierda(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.getPosicion();
		Posicion posicionAuxiliar = new Posicion(0, 0);
		int columna = posicionInicial.obtenerPosicionY();
		for (int i=posicionInicial.obtenerPosicionX(); i>=nuevaPosicion.obtenerPosicionX(); i--)
		{
			//try{
				posicionAuxiliar.setCoordenadas(i, columna);
				this.tablero.moverAlgoformerAlternoAereo(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}

	@Override
	public void moverPosicionAlgoformerVerticalArriba(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.getPosicion();
		Posicion posicionAuxiliar = new Posicion(0, 0);
		int fila = posicionInicial.obtenerPosicionX();
		for (int i=posicionInicial.obtenerPosicionY(); i<=nuevaPosicion.obtenerPosicionY(); i++)
		{
			//try{
				posicionAuxiliar.setCoordenadas(fila, i);
				this.tablero.moverAlgoformerAlternoAereo(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}
	
	@Override
	public void moverPosicionAlgoformerVerticalAbajo(Algoformer algoformer, Posicion nuevaPosicion) {
		Posicion posicionInicial = algoformer.getPosicion();
		Posicion posicionAuxiliar = new Posicion(0, 0);
		int fila = posicionInicial.obtenerPosicionX();
		for (int i=posicionInicial.obtenerPosicionY(); i>=nuevaPosicion.obtenerPosicionY(); i--)
		{
			//try{
				posicionAuxiliar.setCoordenadas(fila, i);
				this.tablero.moverAlgoformerAlternoAereo(algoformer,posicionAuxiliar);
			//}catch Exception SI NO SE PUDO MOVER AGREGAR DENUEVO A POSICION INICIAL
		}
		
	}

}
