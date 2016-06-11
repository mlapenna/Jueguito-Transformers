package fiuba.algo3.tests.unitarios;

import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Juego;

import java.io.FileReader;
import java.io.IOException;

public class JuegoTest {

	@Test
	public void testJugar() {
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
			Tablero tablero = new Tablero(jsonTablero);
			Jugador jugador1 = new Jugador("Pedro", Algoformer.MODO_AUTOBOT, tablero);
			Jugador jugador2 = new Jugador("Juan", Algoformer.MODO_DECEPTICON, tablero);
			Juego juego = new Juego(jugador1, jugador2); // El juego crea al azar 3 robots diferentes para cada jugador y los posiciona



		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

}
