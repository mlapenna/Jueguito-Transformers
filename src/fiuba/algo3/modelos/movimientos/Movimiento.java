package fiuba.algo3.modelos.movimientos;

import fiuba.algo3.modelos.*;

import java.util.ArrayList;

import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoCasilleroOcupadoExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;
import fiuba.algo3.modelos.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoCasilleroInvalidoExcepcion;

public abstract class Movimiento {
	
	protected Tablero tablero;

	public Movimiento(Tablero tablero) {
		this.tablero = tablero;
	}


	private boolean esHorizontalOVerticalPuro(Posicion posicionOrigen, Posicion posicionDestino) {
		return (posicionOrigen.getX() == posicionDestino.getX() || posicionOrigen.getY() == posicionDestino.getY());
	}


	private boolean esDiagonalPuro(Posicion posicionOrigen, Posicion posicionDestino) {
		int distanciaHorizontal = Math.abs(posicionOrigen.getX() - posicionDestino.getX());
		int distanciaVertical = Math.abs(posicionOrigen.getY() - posicionDestino.getY());
		return (distanciaHorizontal == distanciaVertical);
	}


	
	public void mover(Algoformer algoformer, Posicion posicionDestino) {
		boolean caminoDividido = false;
		Algoformer clon = algoformer.clonarAlgoformer();
		
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
		
		// Establecer recorrido casilero por casillero
		ArrayList<Posicion> recorrido = this.getRecorrido(algoformer.getPosicion(), posicionDestino);
		int cantidadPasos = recorrido.size();
		
		for (int j=0; j>cantidadPasos; j++)
			if (!casilleroVacio(recorrido.get(j)))
				throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		
		// Movimiento
		int i = 0;
		Posicion siguientePosicion;
		
		while (i < cantidadPasos) {
			this.tablero.quitarContenido(algoformer.getPosicion());

			try {

				algoformer.validarQueNoEstaInmovilizado();

				siguientePosicion = recorrido.get(i);
				this.afectarAlgoformer(algoformer, siguientePosicion);

				if(algoformer.movimientoDisminuido() && !caminoDividido){
					cantidadPasos = this.dividirRecorrido(i, cantidadPasos);
					caminoDividido = true;
				}

				if (this.tablero.getContenido(siguientePosicion).esChispa() ) {
					algoformer.tieneLaChispa();
					tablero.quitarContenido(siguientePosicion);
				}

				this.tablero.setContenido(siguientePosicion, algoformer);
				algoformer.setNuevaPosicion(siguientePosicion);

			} catch (MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion e) {
				clon.copiarA(algoformer);
				this.tablero.setContenido(algoformer.getPosicion(), algoformer);
				throw new MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion();

			} catch (AlgoformerInmovilizadoExcepcion e) {
				//throw new AlgoformerInmovilizadoExcepcion();
			}
			i++;			
		}

		if (algoformer.movimientoDisminuido()) {
			algoformer.normalizarMovimiento();
		}
	}

	private int dividirRecorrido(int i, int distancia) {
		float mitadRecorrido = ( (i + distancia) /2 );
		if ( mitadRecorrido % 1 != 0 )
			mitadRecorrido = (((i+1) + distancia) /2 );
		return (int)mitadRecorrido;
	}
	
	private boolean casilleroVacio(Posicion posicion){
		Contenido contenidoDestino = this.tablero.getContenido(posicion);
		if (contenidoDestino != Vacio.getInstancia() && !contenidoDestino.esChispa())
			return false;
		return true;
	}

	public abstract void afectarAlgoformer(Algoformer algoformer, Posicion posicion);

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


	// Devuelve 1 si es hacia la derecha o hacia arriba, -1 en los demas casos
	private int getSentidoMovimiento(int a, int b) {
		return (b - a) / Math.abs(b - a);
	}

}


