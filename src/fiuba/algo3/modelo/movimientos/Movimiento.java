package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.Posicion;

import java.util.Calendar;

import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoCasilleroOcupadoExcepcion;

public abstract class Movimiento {
	
	protected Tablero tablero;
	
	public abstract void moverPosicionAlgoformerVerticalAbajo(Algoformer algoformer, Posicion nuevaPosicion);
	public abstract void moverPosicionAlgoformerVerticalArriba(Algoformer algoformer, Posicion nuevaPosicion);
	public abstract void moverPosicionAlgoformerHorizontalIzquierda(Algoformer algoformer,Posicion nuevaPosicion);
	public abstract void moverPosicionAlgoformerHorizontalDerecha(Algoformer algoformer,Posicion nuevaPosicion); // VA A DEPENDER DEL MODO
		// Acá tiene que preguntar al teclado:
		// está ocupada la posicion final?
		// es movimiento válido?
			// qué efecto tiene la superficie donde está parado el algoformer?
		
		// Ver q la posición que se quiere poner el algoformer, no esté ocupada
		//Casillero nuevoCasillero = this.obtenerCasillero(nuevaPosicion);
		//movimientoACasilleroVacio(nuevoCasillero);
		
		// Hay que ver si le da la distancia/velocidad que quiere
		// Esto se hace con una diferencia entre las posiciones (cantidad de casilleros) y la velocidad 
		// del algoformer. 
		// Si la Posicion que quiero que tenga es mayor a la velocidad (cantidad de casillas máximas de movimiento)
		// entonces no se puede mover.
		//try{
		//	distanciaDeMovimientoValida(algoformer,nuevaPosicion);
		//}
		//catch(Exception e)
		//{
		//	throw new MovimientoInvalidoDistanciaNoValidaExcepcion();
		//}
		
	
	private Casillero obtenerCasillero(Posicion nuevaPoscion){
		// TODO: buscar el casillero en el tablero
		return new Casillero();
	}
	
	private void movimientoACasilleroVacio(Casillero casillero){
		
		//Vacio contenidoVacio = new Vacio();
		try{ //TODO
			// comparacion del contenido del casillero con vacio.
			//if(nuevoCasillero.obtenerContenido() == contenidoVacio) {
			//}
		}
		catch(Exception e)
		{
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		}
	}
	
	private void distanciaDeMovimientoValida(Algoformer algoformer,Posicion destino){
		// TODO
		// Acá tomo la velocidad que tenga el algoformer y me fijo hasta donde puede ir
		
	}

}
