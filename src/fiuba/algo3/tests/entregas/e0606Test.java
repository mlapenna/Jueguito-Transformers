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

import org.junit.Assert;
import org.junit.Test;

public class e0606Test {
	
	// Primera entrega Jueves 02/06/2016 - Lunes 06/06/2016

	@Test
	public void testAgregarAlgoformerHumanoideMoverYVerificarPosicion() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicial = new Posicion(1,1);
		Algoformer prime = new Optimus(posicionInicial,tablero);
		Posicion posicionDestino = new Posicion(3,3);
		
		prime.mover(posicionDestino);

		Assert.assertEquals(prime.getPosicion(), posicionDestino);

	}

	
	@Test
	public void testAgregarAlgoformerAlternoMoverYVerificarPosicion() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicial = new Posicion(1,1);
		Algoformer prime = new Optimus(posicionInicial,tablero);
		Posicion posicionDestino = new Posicion(3,3);

		prime.cambiarModo();
		
		prime.mover(posicionDestino);

		Assert.assertEquals(prime.getPosicion(), posicionDestino);

	}


	@Test(expected=MovimientoInvalidoDistanciaNoValidaExcepcion.class)
	public void testAgregarAlgoformerYCambiarDeModoEnAmbasDirecciones() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicionInicial = new Posicion(1,1);
		Algoformer prime = new Optimus(posicionInicial,tablero);
		Posicion posicionDestino = new Posicion(3,3);
		
		prime.cambiarModo();
		
		prime.mover(posicionDestino);

		Assert.assertEquals(prime.getPosicion(), posicionDestino);
		
		prime.cambiarModo();
		
		Posicion ultimaPosicionHumanoide = new Posicion (6,1);
		prime.mover(ultimaPosicionHumanoide);

		Assert.assertEquals(prime.getPosicion(), ultimaPosicionHumanoide);

		Posicion posicionInvalidaHumanoide = new Posicion (9,1);
		prime.mover(ultimaPosicionHumanoide);

	}


	@Test
	public void testAutobotAtacaDecepticonConDanos() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicialAutobot = new Posicion(0,0);
		Posicion posicionInicialDecepticon = new Posicion(2,2);

		Optimus optimus = new Optimus(posicionInicialAutobot,tablero);
		Frenzy frenzy = new Frenzy(posicionInicialDecepticon,tablero);

		int vidaFrenzyEsperadaLuegoDeAtaque = frenzy.getVida() - optimus.getAtaque();

		optimus.atacar(frenzy);
		
		// El primer ataque esta dentro de la distancia y debe restarle vida
		Assert.assertEquals(vidaFrenzyEsperadaLuegoDeAtaque, frenzy.getVida());
	}
	
	@Test(expected = AtaqueInvalidoDistanciaInsuficienteExcepcion.class)
	public void testAutobotAtacaDecepticonConDanosFueraDeRango() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicialAutobot = new Posicion(0,0);
		Posicion posicionInicialDecepticon = new Posicion(2,3);

		Optimus optimus = new Optimus(posicionInicialAutobot,tablero);
		Frenzy frenzy = new Frenzy(posicionInicialDecepticon,tablero);

		optimus.atacar(frenzy);
	}
	
}
