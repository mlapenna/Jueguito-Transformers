package fiuba.algo3.tests.entregas;

import java.io.FileReader;

import fiuba.algo3.modelos.*;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.algoformers.Frenzy;
import fiuba.algo3.modelos.algoformers.Optimus;
import fiuba.algo3.modelos.excepciones.AtaqueInvalidoDistanciaInsuficienteExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class e0606Test {
	
	// Primera entrega Jueves 02/06/2016 - Lunes 06/06/2016

	@Test
	public void testAgregarAlgoformerHumanoideMoverYVerificarPosicion() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNebulosaDeAndromeda.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Iterator<Algoformer> robotsJugador1 = jugador1.getAlgoformersIterator();
		Algoformer unRobotJugador1 = robotsJugador1.next();
		
		Posicion posicionDestino = new Posicion(0,2);
		
		unRobotJugador1.mover(posicionDestino);

		Assert.assertEquals(unRobotJugador1.getPosicion(), posicionDestino);

	}

	
	@Test
	public void testAgregarAlgoformerAlternoMoverYVerificarPosicion() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Iterator<Algoformer> robotsJugador1 = jugador1.getAlgoformersIterator();

		Algoformer unRobotJugador1 = robotsJugador1.next();
		
		Posicion posicionDestino = new Posicion (2,0);
		unRobotJugador1.mover(posicionDestino);

		Assert.assertEquals(unRobotJugador1.getPosicion(), posicionDestino);

	}


	@Test(expected=MovimientoInvalidoDistanciaNoValidaExcepcion.class)
	public void testAgregarAlgoformerYCambiarDeModoEnAmbasDirecciones() throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Algoformer optimusJugador1 = juego.getJugador1().getAlgoformers().get(0); // En 0,0
		Algoformer unRobotJugador2 = juego.getJugador2().getAlgoformers().get(0);
		
		Posicion posicionDestino = new Posicion(2,0); // Máxima distancia válida
		
		// Turno 1
		optimusJugador1.mover(posicionDestino);
		unRobotJugador2.cambiarModo(); // Este no importa

		Assert.assertEquals(optimusJugador1.getPosicion(), posicionDestino);

		// Siguiente turno
		optimusJugador1.cambiarModo(); // Paso a alterno
		unRobotJugador2.cambiarModo(); // Este no importa

		// Siguiente turno
		posicionDestino.setCoordenadas(7, 0);  // Máxima distancia válida
		optimusJugador1.mover(posicionDestino);
		unRobotJugador2.cambiarModo(); // Este no importa

		Assert.assertEquals(optimusJugador1.getPosicion(), posicionDestino);

		// Siguiente turno
		optimusJugador1.cambiarModo(); // Paso a humanoide
		unRobotJugador2.cambiarModo(); // Este no importa

		// Siguiente turno
		posicionDestino.setCoordenadas(7, 3);
		optimusJugador1.mover(posicionDestino); // Trato de moverlo 3 casilleros en humanoide, pero su velocidad es 2
	}


	@Test
	public void testAutobotAtacaDecepticonConDanos() throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestAtaques.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Iterator<Algoformer> robotsJugador1 = jugador1.getAlgoformersIterator();
		robotsJugador1.next();
		robotsJugador1.next();
		Algoformer unRobotJugador1 = robotsJugador1.next();
		
		Jugador jugador2 = juego.getJugador2();
		Iterator<Algoformer> robotsJugador2 = jugador2.getAlgoformersIterator();
		Algoformer unRobotJugador2 = robotsJugador2.next();

		int vidaEsperadaLuegoDeAtaque = unRobotJugador2.getVida() - unRobotJugador1.getAtaque();

		unRobotJugador1.atacar(unRobotJugador2);
		
		// El primer ataque esta dentro de la distancia y debe restarle vida
		Assert.assertEquals(vidaEsperadaLuegoDeAtaque, unRobotJugador2.getVida());
	}
	
	@Test(expected = AtaqueInvalidoDistanciaInsuficienteExcepcion.class)
	public void testAutobotAtacaDecepticonConDanosFueraDeRango() throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestAtaques.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Iterator<Algoformer> robotsJugador1 = jugador1.getAlgoformersIterator();
		Algoformer unRobotJugador1 = robotsJugador1.next();
		
		Jugador jugador2 = juego.getJugador2();
		Iterator<Algoformer> robotsJugador2 = jugador2.getAlgoformersIterator();
		Algoformer unRobotJugador2 = robotsJugador2.next();

		unRobotJugador1.atacar(unRobotJugador2);
	}
	
}
