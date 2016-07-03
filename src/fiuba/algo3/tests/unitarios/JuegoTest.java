package fiuba.algo3.tests.unitarios;

import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.Tablero;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelos.Juego;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JuegoTest {

	@Test
	public void testMostrarGanadorCorrectamente() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano2.json"));
		Juego juego = new Juego(jsonTablero, "Pedro", "Juan");
		Assert.assertFalse(juego.hayGanador());
		juego.gano(juego.getJugador1());
		Assert.assertTrue(juego.hayGanador());
		Assert.assertEquals(juego.ganador(), "Pedro");
	}

}
