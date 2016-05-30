package fiuba.algo3.tests;

import fiuba.algo3.modelo.Algoformer;
import fiuba.algo3.modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Juego;

public class IntegracionTest {
	
	@Test
	public void testJugar() {
		Jugador jugador1 = new Jugador('Pedro', Algoformer.MODO_AUTOBOT);
		Jugador jugador2 = new Jugador('Juan', Algoformer.MODO_DECEPTICON);
		Juego juego = new Juego(jugador1, jugador2); // El juego crea al azar 3 robots diferentes para cada jugador y los posiciona

		Tablero tablero = juego.obtenerTablero(); // Necesario para dibujar y actualizar la interfaz gráfica

		// Recorro el tablero para ver si efectivamente están los 3 autobots a la izquierda, 3 decepticons a la derecha
		// y la chispa suprema en el centro


		// En la columna 0, primeras 3 filas, debe haber 3 autobots
		// Preguntar de qué forma legal puedo chequear que hay un autobot en cada casilla y que cada uno es diferente
		Autobot robot1 = tablero.obtenerCasillero(0, 0);
		Autobot robot1 = tablero.obtenerCasillero(1, 0);
		Autobot robot1 = tablero.obtenerCasillero(2, 0);

		//Assert.assertEquals();

		// En la última columna, últimas 3 filas debe haber 3 decepticons
		// Preguntar de qué forma legal puedo chequear que hay un decepticon en cada casilla y que cada uno es diferente
		Autobot robot1 = tablero.obtenerCasillero( tablero.obtenerFilas() - 2, tablero.obtenerColumnas() );
		Autobot robot1 = tablero.obtenerCasillero( tablero.obtenerFilas() - 1, tablero.obtenerColumnas() );
		Autobot robot1 = tablero.obtenerCasillero( tablero.obtenerFilas() - 2, tablero.obtenerColumnas() );

		//Assert.assertEquals();

		// Preguntar de qué forma legal puedo chequear que está la chispa suprema... como las filas y columnas son cantidad
		// impar empezando por 0, la mitad de cada una da el centro
		ChispaSuprema chispaSuprema = tablero.obtenerCasillero( tablero.obtenerFilas() / 2, tablero.obtenerColumnas() / 2);

		// El resto debe estar vacío
		for (var fila = 0; fila < tablero.obtenerFilas(); fila ++) {
			for (var columna = 0; fila < tablero.obtenerColumnas(); fila ++) {

				// Chequear que tenga una superficie ...

				// Si no es una casilla de las 7 donde debe haber robots o chispa suprema, debe haber vacío
				if ( !( (fila >=0 || fila <=2) && columna == 0)
					&& !( (fila >= tablero.obtenerFilas() - 2 && columna == tablero.obtenerColumnas() ) ) ) {

					// Preguntar de qué forma legal...
					Vacio vacio = tablero.obtenerCasillero(fila, columna);
					//Assert.assertEquals();
		}

	}
	

}
