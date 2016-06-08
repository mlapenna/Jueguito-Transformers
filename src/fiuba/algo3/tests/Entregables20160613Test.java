package fiuba.algo3.tests;

import java.io.FileReader;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.algoformers.*;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsAlternoExcepcion;
import fiuba.algo3.modelo.Posicion;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;


public class Entregables20160613Test {

	@Test
	public void testLlenarZonaRocosaYHacerPasarAOptimusHumanoidePorElla() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer prime = new Optimus();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {prime.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona rocosa en el medio.
		
		prime.moverAlgoformer(posicionDestino);
		
		Assert.assertEquals(prime.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarAOptimusAlternoPorElla () throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer prime = new Optimus();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {prime.transformarAlterno();}
		catch(Exception e){}
		
		prime.moverAlgoformer(posicionDestino);

		Assert.assertEquals(prime.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarARatchetHumanoidePorElla() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer ratchet = new Ratchet();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {ratchet.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona rocosa en el medio.
		
		ratchet.moverAlgoformer(posicionDestino);
		
		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarARatchetAlternoPorElla () throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer ratchet = new Ratchet();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {ratchet.transformarAlterno();}
		catch(Exception e){}
		
		ratchet.moverAlgoformer(posicionDestino);

		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarABumbleBeeHumanoidePorElla() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer bumblebee = new BumbleBee();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {bumblebee.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona rocosa en el medio.
		
		bumblebee.moverAlgoformer(posicionDestino);
		
		Assert.assertEquals(bumblebee.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarABumbleBeeAlternoPorElla () throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer bumblebee = new BumbleBee();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {bumblebee.transformarAlterno();}
		catch(Exception e){}
		
		bumblebee.moverAlgoformer(posicionDestino);

		Assert.assertEquals(bumblebee.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarASuperionPorElla() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer Superion = new Superion();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {Superion.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona rocosa en el medio.
		
		Superion.moverAlgoformer(posicionDestino);
		
		Assert.assertEquals(Superion.getPosicion(), posicionDestino);
	}
		
	@Test
	public void testLlenarZonaRocosaYHacerPasarAMegatronHumanoidePorElla() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {megatron.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona rocosa en el medio.
		
		megatron.moverAlgoformer(posicionDestino);
		
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarAMegatronAlternoPorElla () throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {megatron.transformarAlterno();}
		catch(Exception e){}
		
		megatron.moverAlgoformer(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
		
	@Test
	public void testLlenarZonaRocosaYHacerPasarABonecrusherHumanoidePorElla() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer bonecrusher = new Bonecrusher();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {bonecrusher.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona rocosa en el medio.
		
		bonecrusher.moverAlgoformer(posicionDestino);
		
		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarABonecrusherAlternoPorElla () throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer bonecrusher = new Bonecrusher();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {bonecrusher.transformarAlterno();}
		catch(Exception e){}
		
		bonecrusher.moverAlgoformer(posicionDestino);

		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarAFrenzyHumanoidePorElla() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer frenzy = new Frenzy();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {frenzy.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona rocosa en el medio.
		
		frenzy.moverAlgoformer(posicionDestino);
		
		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarAFrenzyAlternoPorElla () throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer frenzy = new Frenzy();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {frenzy.transformarAlterno();}
		catch(Exception e){}
		
		frenzy.moverAlgoformer(posicionDestino);

		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
	}
	
	
	@Test
	public void testLlenarZonaRocosaYHacerPasarAMenasorAlternoPorElla () throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer menasor = new Menasor();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {menasor.transformarAlterno();}
		catch(Exception e){}
		
		menasor.moverAlgoformer(posicionDestino);

		Assert.assertEquals(menasor.getPosicion(), posicionDestino);
	}
}
