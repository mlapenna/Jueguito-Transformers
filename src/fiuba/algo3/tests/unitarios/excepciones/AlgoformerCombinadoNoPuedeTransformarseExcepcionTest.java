package fiuba.algo3.tests.unitarios.excepciones;

import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.algoformers.*;
import fiuba.algo3.modelos.excepciones.AlgoformerCombinadoNoPuedeTransformarseExcepcion;
import fiuba.algo3.modelos.excepciones.NoEsElTurnoDelJugadorExcepcion;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class AlgoformerCombinadoNoPuedeTransformarseExcepcionTest {

	@Test(expected = AlgoformerCombinadoNoPuedeTransformarseExcepcion.class)
	public void testCombinoAlgoformerYLuegoTratoDeTransformarloLanzaExcepcion() {
		try {

			JSONParser parser = new JSONParser();
			JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano2.json"));
			Juego juego = new Juego(jsonTablero, "Pedro", "Juan");

			Optimus optimusJugador1 = (Optimus) juego.getJugador1().getAlgoformers().get(0);
            Ratchet ratchetJugador1 = (Ratchet) juego.getJugador1().getAlgoformers().get(2);
            Megatron megatronJugador2 = (Megatron) juego.getJugador2().getAlgoformers().get(0);

            optimusJugador1.mover(new Posicion(0, 1));
            megatronJugador2.cambiarModo();

            ratchetJugador1.mover(new Posicion(0, 3));
			megatronJugador2.cambiarModo();

            juego.getJugador1().combinarAlgoformers(optimusJugador1.getTurno());
            megatronJugador2.cambiarModo();

            Superion superionJugador1 = (Superion) juego.getJugador1().getAlgoformers().get(0);
            superionJugador1.cambiarModo();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
