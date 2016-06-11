package fiuba.algo3.tests.entregas;

import java.io.FileReader;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.algoformers.*;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsAlternoExcepcion;
import fiuba.algo3.modelo.excepciones.ZonaPantanoProhibidoPasarExcepcion;
import fiuba.algo3.modelo.Posicion;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;


public class e0613Test {

	/*
	@Test
	public void testLlenarZonaRocasYHacerPasarAOptimusHumanoidePorElla() throws FileNotFoundException,
	 IOException, ParseException{

		// El tablero contiene 4 casilleros en distribucion horizontal, todos con superficie terrestre Rocas, el algoformer en el casillero de la izquierda.
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Optimus optimus = new Optimus(posicion, tablero);

		int vidaOriginal = optimus.getVida();

		Posicion posicionDestino = new Posicion(4, 0);

		optimus.mover(posicionDestino);
		
		Assert.assertEquals(posicionDestino, optimus.getPosicion());
		Assert.assertEquals(vidaOriginal, optimus.getVida());
	}
	

	@Test
	public void testLlenarZonaRocasYHacerPasarAOptimusAlternoPorElla () throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Algoformer prime = new Optimus();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {prime.transformarAlterno();}
		catch(Exception e){}
		
		prime.mover(posicionDestino);

		Assert.assertEquals(prime.getPosicion(), posicionDestino);

	}

	/*
	@Test
	public void testLlenarZonaRocasYHacerPasarARatchetHumanoidePorElla() throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer ratchet = new Ratchet();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {ratchet.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona Rocas en el medio.
		
		ratchet.mover(posicionDestino);
		
		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarARatchetAlternoPorElla () throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer ratchet = new Ratchet();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {ratchet.transformarAlterno();}
		catch(Exception e){}
		
		ratchet.mover(posicionDestino);

		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarABumbleBeeHumanoidePorElla() throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer bumblebee = new BumbleBee();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {bumblebee.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona Rocas en el medio.
		
		bumblebee.mover(posicionDestino);
		
		Assert.assertEquals(bumblebee.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarABumbleBeeAlternoPorElla () throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer bumblebee = new BumbleBee();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {bumblebee.transformarAlterno();}
		catch(Exception e){}
		
		bumblebee.mover(posicionDestino);

		Assert.assertEquals(bumblebee.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarASuperionPorElla() throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer Superion = new Superion();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {Superion.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona Rocas en el medio.
		
		Superion.mover(posicionDestino);
		
		Assert.assertEquals(Superion.getPosicion(), posicionDestino);
	}
		
	@Test
	public void testLlenarZonaRocasYHacerPasarAMegatronHumanoidePorElla() throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {megatron.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona Rocas en el medio.
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarAMegatronAlternoPorElla () throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {megatron.transformarAlterno();}
		catch(Exception e){}
		
		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
		
	@Test
	public void testLlenarZonaRocasYHacerPasarABonecrusherHumanoidePorElla() throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer bonecrusher = new Bonecrusher();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {bonecrusher.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona Rocas en el medio.
		
		bonecrusher.mover(posicionDestino);
		
		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarABonecrusherAlternoPorElla () throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer bonecrusher = new Bonecrusher();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {bonecrusher.transformarAlterno();}
		catch(Exception e){}
		
		bonecrusher.mover(posicionDestino);

		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarAFrenzyHumanoidePorElla() throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer frenzy = new Frenzy();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {frenzy.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona Rocas en el medio.
		
		frenzy.mover(posicionDestino);
		
		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarAFrenzyAlternoPorElla () throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer frenzy = new Frenzy();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {frenzy.transformarAlterno();}
		catch(Exception e){}
		
		frenzy.mover(posicionDestino);

		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
	}
	
	
	@Test
	public void testLlenarZonaRocasYHacerPasarAMenasorAlternoPorElla () throws FileNotFoundException,
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer menasor = new Menasor();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3

		try {menasor.transformarAlterno();}
		catch(Exception e){}
		
		menasor.mover(posicionDestino);

		Assert.assertEquals(menasor.getPosicion(), posicionDestino);
	}
	
	
	//     SEGUNDO TEST
	@Test(expected=ZonaPantanoProhibidoPasarExcepcion.class)
	public void testLlenarZonaPantanoYVerificarEnModoHumanoideNoSePuedeAtravasar() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer prime = new Optimus();
		Posicion posicionDestino = new Posicion(1,3); // el destino es la fila 1 columna 3
		
		try {prime.transformarHumanoide();}
		catch(Exception e){}
		
		// El mapa es conocido y simple: 3 casilleros en distribucion horizontal.
		// El algoformer en el casillero de la izquierda, la zona Rocas en el medio.
		
		prime.mover(posicionDestino);
		
	}
	
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoSeTardaElDobleQueEnElRocoso() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer prime = new Optimus();
		Posicion posicionDestino = new Posicion(1,3); 
		
		// hay que ver el criterio para decir que tarda el doble: 
		//     mitad de velocidad (temporalmente) o por cantidad de turnos inmovil (que sería 1)
		// Se podria plantear dos test con este: uno que muestre que en un movimiento no atraviesa 
		// y el otro que en dos movimientos lo atraviesa
		try {prime.transformarAlterno();}
		catch(Exception e){}		
		
		//prime.mover(posicionDestino);
		
		//Assert.assertEquals(prime.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoAereoSeAtraviesaSinProblemas() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); 

		try {megatron.transformarAlterno();} // Megatron alterno es unidad aerea
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaEspinasYVerificarQueLaVidaDeUnidadesTerrestresDiminuyeAlPasarUnCasillero() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); 
		int cantidadDeCasillerosAtravesados = 1;
		
		double vidaInicial = megatron.getVida();
		
		try {megatron.transformarHumanoide();}
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertTrue(megatron.getVida() == (vidaInicial*(1-(cantidadDeCasillerosAtravesados*0.05))));
	}
	
	@Test
	public void testLlenarZonaEspinasYVerificarQueLaVidaDeUnidadesTerrestresDiminuyeAlPasarMasDeUnCasillero() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); 
		int cantidadDeCasillerosAtravesados = 2;
		
		double vidaInicial = megatron.getVida();
		
		try {megatron.transformarHumanoide();}
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertTrue(megatron.getVida() == (vidaInicial*(1-(cantidadDeCasillerosAtravesados*0.05))));
	}
	
	@Test
	public void testLlenarZonaEspinasYVerificarQueUnidadesAereasNoSonAfectadas() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaMuchasEspinas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); 
		int cantidadDeCasillerosAtravesados = 2;
		
		int  vidaInicial = megatron.getVida();
		
		try {megatron.transformarAlterno();}
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getVida(),vidaInicial);
	}
	
	@Test
	public void testLlenarZonaNubesYVerificarEnModoAlternoAereoSeAtraviesaSinProblemas() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNubes.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); 

		try {megatron.transformarAlterno();} // Megatron alterno es unidad aerea
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaNebulosaDeAndromedaYVerificarEnModoAlternoAereoUnaUnidadSeQuedaAtrapadaPorTresTurnosSinMoverse() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNebulosaDeAndromeda.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); 

		try {megatron.transformarAlterno();} // Megatron alterno es unidad aerea
		catch(Exception e){}		
		
		// Acá habrá que hacer 4 test : uno por cada turno inmovil, 
		// en donde se verifica el lanzado de excepcion que impide mover el robot
		
		//megatron.mover(posicionDestino);
		
		//Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}

	@Test
	public void testLlenarZonaTormentaPsionicaYVerificarQueUnidadesAereasDismunyenCapacidadDeAtaque() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaTormentaPsionica.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); 
		
		int  ataqueInicial = megatron.getAtaque();
		
		try {megatron.transformarAlterno();}
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getAtaque(),ataqueInicial);
	}
	
	@Test
	public void testLlenarZonaTormentaPsionicaYVerificarQueUnidadesAereasYPasarDosVecesYVerQueNoDismunyenMasSuCapacidadDeAtaque() throws FileNotFoundException, 
	 IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaTormentaPsionica.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer megatron = new Megatron();
		Posicion posicionDestino = new Posicion(1,3); 
		
		int  ataqueInicial = megatron.getAtaque();
		
		try {megatron.transformarAlterno();}
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		int ataqueAfectado = megatron.getAtaque();
		
		Posicion posicionDestinoDeVuelta = new Posicion(1,1); 
		
		megatron.mover(posicionDestinoDeVuelta);
		
		Assert.assertEquals(megatron.getAtaque(),ataqueAfectado);
	}
	*/
	
}
