package fiuba.algo3.tests.entregas;

import java.io.FileReader;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.algoformers.Frenzy;
import fiuba.algo3.modelo.algoformers.Optimus;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoDistanciaInsuficienteExcepcion;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsAlternoExcepcion;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class e0606Test {
	
	// Primera entrega Jueves 02/06/2016 - Lunes 06/06/2016

	

	@Test
	public void testAgregarAlgoformerHumanoideMoverYVerificarPosicion() throws FileNotFoundException, 
	 IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicial = new Posicion(1,1);
		Algoformer prime = new Optimus(posicionInicial,tablero);
		Posicion posicionDestino = new Posicion(3,3);
		
		try {prime.transformarHumanoide();}
		catch(Exception e){}
		
		System.out.println(prime.getPosicion().getX());
		System.out.println(prime.getPosicion().getY());

		prime.mover(posicionDestino);
		
		System.out.println(prime.getPosicion().getX());
		System.out.println(prime.getPosicion().getY());

		Assert.assertTrue(prime.getPosicion().iguales(posicionDestino));

	}

	
	@Test
	public void testAgregarAlgoformerAlternoMoverYVerificarPosicion() throws FileNotFoundException, 
	 IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicial = new Posicion(1,1);
		Algoformer prime = new Optimus(posicionInicial,tablero);
		Posicion posicionDestino = new Posicion(3,3);

		try {prime.transformarAlterno();}
		catch(Exception e){}
		
		prime.mover(posicionDestino);

		Assert.assertTrue(prime.getPosicion().iguales(posicionDestino));

	}


	@Test(expected=MovimientoInvalidoDistanciaNoValidaExcepcion.class)
	public void testAgregarAlgoformerYCambiarDeModoEnAmbasDirecciones() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicionInicial = new Posicion(1,1);
		Algoformer prime = new Optimus(posicionInicial,tablero);
		Posicion posicionDestino = new Posicion(3,3);
		
		try {prime.transformarAlterno();} //Optimus alterno tiene velocidad 5
		catch(Exception e){}
		
		prime.mover(posicionDestino);

		Assert.assertTrue(prime.getPosicion().iguales(posicionDestino));
		
		try {prime.transformarHumanoide();}
		catch(Exception e){}
		
		Posicion ultimaPosicionHumanoide = new Posicion (6,1);
		prime.mover(ultimaPosicionHumanoide);

		Assert.assertTrue(prime.getPosicion().iguales(ultimaPosicionHumanoide));

		Posicion posicionInvalidaHumanoide = new Posicion (9,1);
		prime.mover(ultimaPosicionHumanoide);

	}


	@Test(expected=TransformacionIncorresctaYaEsHumanoideExcepcion.class)
	public void testCrearAlgoformerHumanoideYCambiarAlMismoModo() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicial = new Posicion(1,1);
		Algoformer prime = new Optimus(posicionInicial,tablero);
		prime.transformarHumanoide();
	}

	@Test(expected=TransformacionIncorresctaYaEsAlternoExcepcion.class)
	public void testCrearAlgoformerTransformarAAlternoYCambiarAlMismoModo() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicial = new Posicion(1,1);
		Algoformer prime = new Optimus(posicionInicial,tablero);
		prime.transformarAlterno();
		prime.transformarAlterno();
	}

	@Test
	public void testAutobotAtacaDecepticonConDanos() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
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
	public void testAutobotAtacaDecepticonConDanosFueraDeRango() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicionInicialAutobot = new Posicion(0,0);
		Posicion posicionInicialDecepticon = new Posicion(2,3);

		Optimus optimus = new Optimus(posicionInicialAutobot,tablero);
		Frenzy frenzy = new Frenzy(posicionInicialDecepticon,tablero);

		int vidaFrenzyEsperadaLuegoDeAtaque = frenzy.getVida() - optimus.getAtaque();

		optimus.atacar(frenzy);

	}
	
}
