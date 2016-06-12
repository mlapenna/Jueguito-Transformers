package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.*;

import java.util.ArrayList;
import java.util.Calendar;

import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoCasilleroOcupadoExcepcion;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoCasilleroInvalidoExcepcion;

public abstract class Movimiento {
	
	protected Tablero tablero;
	
//	public abstract void moverPosicionAlgoformerVerticalAbajo(Algoformer algoformer, Posicion nuevaPosicion);
//	public abstract void moverPosicionAlgoformerVerticalArriba(Algoformer algoformer, Posicion nuevaPosicion);
//	public abstract void moverPosicionAlgoformerHorizontalIzquierda(Algoformer algoformer,Posicion nuevaPosicion);
//	public abstract void moverPosicionAlgoformerHorizontalDerecha(Algoformer algoformer,Posicion nuevaPosicion); // VA A DEPENDER DEL MODO
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
		
	
	protected Casillero getCasillero(Posicion nuevaPoscion){
		// TODO: buscar el casillero en el tablero
		return new Casillero();
	}
	
	private void movimientoACasilleroVacio(Casillero casillero){
		
		//Vacio contenidoVacio = Vacio.getInstancia();
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


	public boolean esHorizontalOVerticalPuro(Posicion posicionOrigen, Posicion posicionDestino) {
		return (posicionOrigen.getX() == posicionDestino.getX() || posicionOrigen.getY() == posicionDestino.getY());
	}


	public boolean esDiagonalPuro(Posicion posicionOrigen, Posicion posicionDestino) {
		int distanciaHorizontal = Math.abs(posicionOrigen.getX() - posicionDestino.getX());
		int distanciaVertical = Math.abs(posicionOrigen.getY() - posicionDestino.getY());
		return (distanciaHorizontal == distanciaVertical);
	}


	
	public void mover(Algoformer algoformer, Tablero tablero, Posicion posicionDestino) {
		
		Posicion posicionInicial = algoformer.getPosicion();//POR SI NO PUEDE PASAR
		
		algoformer.validarQueNoEstaInmovilizado();
		
		// Distancia valida? (ni muy grande, ni nula)
		int distancia = algoformer.getPosicion().getDistancia(posicionDestino);
		if (algoformer.getVelocidad() < distancia || distancia == 0) {
			throw new MovimientoInvalidoDistanciaNoValidaExcepcion();
		}

		// Direccion valida?
		if (!this.esHorizontalOVerticalPuro(algoformer.getPosicion(), posicionDestino)
			&& !this.esDiagonalPuro(algoformer.getPosicion(), posicionDestino)) {
			throw new MovimientoInvalidoCasilleroInvalidoExcepcion();
		}

		// Casillero vacio?
		Contenido contenidoDestino = tablero.getContenido(posicionDestino);
		if (contenidoDestino != Vacio.getInstancia()) {
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		}//ME PARECE QUE SEGUN EL PRINCIPIO "TELL DONT ASK" HABRIA Q COMPROBAR ESTO MIENTRAS SE MUEVE

		// Establecer recorrido casilero por casillero
		ArrayList<Posicion> recorrido = this.getRecorrido(algoformer.getPosicion(), posicionDestino);
		
		// Movimiento
		for (int i=0; i < recorrido.size(); i++) 		{
			tablero.quitarContenido(algoformer.getPosicion());
			try {
				this.afectarAlgoformer(algoformer,tablero,recorrido.get(i));
				tablero.setContenido(recorrido.get(i), algoformer);
				//algoformer.mover(recorrido.get(i));
				algoformer.setNuevaPosicion(recorrido.get(i));
			} catch(MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion e) {
				//TODO: regresar a condiciones iniciales
			} 			
		}		
	}


	public abstract void afectarAlgoformer(Algoformer algoformer, Tablero tablero,Posicion posicion);

	// Arma un recorrido (compuesto por cada una de las posiciones intermedias más la final) de acuerdo a las posiciones de origen y destino recibidas
	private ArrayList<Posicion> getRecorrido(Posicion posicionOrigen, Posicion posicionDestino) {
		ArrayList<Posicion> recorrido = new ArrayList<Posicion>();

		Posicion posicionSiguiente = new Posicion(posicionOrigen.getX(), posicionOrigen.getY());
		
		if (this.esHorizontalOVerticalPuro(posicionOrigen, posicionDestino)) {

			if (posicionOrigen.getX() != posicionDestino.getX()) {
				// Horizontal
				
				int sentido = this.getSentidoMovimiento(posicionOrigen.getX(), posicionDestino.getX());
				int coordenadaXsiguiente = posicionOrigen.getX();

				while (!posicionSiguiente.equals(posicionDestino)) {
					coordenadaXsiguiente += sentido;
					posicionSiguiente = new Posicion(coordenadaXsiguiente, posicionOrigen.getY());
					recorrido.add(posicionSiguiente);
				}
			} else {
				// Vertical
				int sentido = this.getSentidoMovimiento(posicionOrigen.getY(), posicionDestino.getY());
				int coordenadaYsiguiente = posicionOrigen.getY();
			
				while (!posicionSiguiente.equals(posicionDestino)) {
					coordenadaYsiguiente += sentido;
					posicionSiguiente = new Posicion(posicionOrigen.getX(), coordenadaYsiguiente);
					recorrido.add(posicionSiguiente);
				}
			}

		} else if (this.esDiagonalPuro(posicionOrigen, posicionDestino)) {
			// Diagonal
			int sentidoHorizontal = this.getSentidoMovimiento(posicionOrigen.getX(), posicionDestino.getX());
			int sentidoVertical = this.getSentidoMovimiento(posicionOrigen.getY(), posicionDestino.getY());
			int coordenadaXsiguiente = posicionOrigen.getX();
			int coordenadaYsiguiente = posicionOrigen.getY();

			while (!posicionSiguiente.equals(posicionDestino)) {
				coordenadaXsiguiente += sentidoHorizontal;
				coordenadaYsiguiente += sentidoVertical;
				posicionSiguiente = new Posicion(coordenadaXsiguiente, coordenadaYsiguiente);
				recorrido.add(posicionSiguiente);
			}
		}

		return recorrido;
	}


	// Devuelve 1 si es hacia la derecha o hacia arriba, -1 en los demás casos
	private int getSentidoMovimiento(int a, int b) {
		return (b - a) / Math.abs(b - a);
	}

}


