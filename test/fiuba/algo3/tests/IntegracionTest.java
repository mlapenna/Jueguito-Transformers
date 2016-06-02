package fiuba.algo3.tests;

import fiuba.algo3.modelo.Algoformer;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Juego;

public class IntegracionTest {


	/* SE DEJA ESTO NADA MAS PARA MOSTRAR  COMO SE ARRANCA EL JUEGO
	@Test
	public void testJugar() {
		Juego juego = new Juego();
		Tablero tablero = new Tablero();

		Jugador jugador1 = new Jugador('Pedro', Algoformer.MODO_AUTOBOT, tablero);
		Jugador jugador2 = new Jugador('Juan', Algoformer.MODO_DECEPTICON, tablero);

		Juego juego = new Juego(jugador1, jugador2); // El juego crea al azar 3 robots diferentes para cada jugador y los posiciona

		Tablero tablero = juego.obtenerTablero(); // Necesario para dibujar y actualizar la interfaz gráfica

	}

}
