package fiuba.algo3.tests;

import java.io.FileReader;

import fiuba.algo3.modelo.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class EntregablesTest {
	
	// Primera entrega Jueves 02/06/2016 - Lunes 06/06/2016
	
	@Test
	public void testAgregarAlgoformerHumanoideMoverYVerificarPosicion() throws FileNotFoundException, 
	 IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer prime = new Optimus();

		Posicion nuevaPosicion = new Posicion(3, 1);
		Posicion ultimaPosicion = new Posicion(5, 1);
		
		try {prime.transformarHumanoide();}
		catch(Exception e){}
		
		tablero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(prime, nuevaPosicion);
		tablero.moverAlgoformerHumanoidesinEfectoDeLaSuperficie(prime,ultimaPosicion);

		Posicion auxPosicion = prime.getPosicion();
		
		Assert.assertEquals(ultimaPosicion.obtenerPosicionX(), auxPosicion.obtenerPosicionX());
		Assert.assertEquals(ultimaPosicion.obtenerPosicionY(), auxPosicion.obtenerPosicionY());
		
	}
	
	@Test
	public void testAgregarAlgoformerAlternoMoverYVerificarPosicion() throws FileNotFoundException, 
	 IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer prime = new Optimus();
		Posicion nuevaPosicion = new Posicion(3, 1);
		Posicion ultimaPosicion = new Posicion(5,1);

		try {prime.transformarAlterno();}
		catch(Exception e){}
		
		tablero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(prime,nuevaPosicion);
		tablero.moverAlgoformerHumanoidesinEfectoDeLaSuperficie(prime,ultimaPosicion);

		Posicion auxPosicion = prime.getPosicion();
		
		Assert.assertEquals(ultimaPosicion.obtenerPosicionX(), auxPosicion.obtenerPosicionX());
		Assert.assertEquals(ultimaPosicion.obtenerPosicionY(), auxPosicion.obtenerPosicionY());
		
	}
	
	@Test
	public void testAgregarAlgoformerYCambiarDeModoEnAmbasDirecciones() {
		Algoformer prime = new Optimus();
		
		try {prime.transformarAlterno();}
		catch(Exception e){}
		Assert.assertEquals(15, prime.getAtaque());
		
		try {prime.transformarHumanoide();}
		catch(Exception e){}
		Assert.assertEquals(50, prime.getAtaque());
	}


	@Test
	public void testAutobotAtacaDecepticonConDanos() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Optimus optimus = new Optimus();
		Frenzy frenzy = new Frenzy();

		Posicion posicion1 = new Posicion(0, 0);
		Posicion posicion2 = new Posicion(2, 2);

		tablero.agregarAlgoformerHumanoide(optimus, posicion1);
		tablero.agregarAlgoformerHumanoide(frenzy, posicion2);

		int vidaFrenzyEsperadaLuegoDeAtaque = frenzy.getVida() - optimus.getAtaque();

		Ataque ataque = new Ataque(tablero, posicion1, posicion2);

		// El primer ataque está dentro de la distancia y debe restarle vida
		Assert.assertEquals(vidaFrenzyEsperadaLuegoDeAtaque, frenzy.getVida());

		posicion2.setCoordenadas(2, 3);
		tablero.moverAlgoformerHumanoide(frenzy, posicion2);
		vidaFrenzyEsperadaLuegoDeAtaque = frenzy.getVida();
		ataque = new Ataque(tablero, posicion1, posicion2);

		Assert.assertEquals(vidaFrenzyEsperadaLuegoDeAtaque, frenzy.getVida()); // Este está fuera de la distancia y no debe restarle

		posicion2.setCoordenadas(7, 7);
		tablero.moverAlgoformerHumanoide(frenzy, posicion2);
		vidaFrenzyEsperadaLuegoDeAtaque = frenzy.getVida();
		ataque = new Ataque(tablero, posicion1, posicion2);

		Assert.assertEquals(vidaFrenzyEsperadaLuegoDeAtaque, frenzy.getVida()); // Este está fuera de la distancia y no debe restarle

		posicion2.setCoordenadas(1, 1);
		tablero.moverAlgoformerHumanoide(frenzy, posicion2);
		vidaFrenzyEsperadaLuegoDeAtaque = frenzy.getVida() - optimus.getAtaque();;
		ataque = new Ataque(tablero, posicion1, posicion2);

		Assert.assertEquals(vidaFrenzyEsperadaLuegoDeAtaque, frenzy.getVida()); // Este está dentro de la distancia y debe restarle

	}
}
