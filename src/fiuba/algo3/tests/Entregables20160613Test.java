package fiuba.algo3.tests;

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


public class Entregables20160613Test {

	// PRIMER TEST
	
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
		// El algoformer en el casillero de la izquierda, la zona rocosa en el medio.
		
		prime.moverAlgoformer(posicionDestino);
		
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
		
		//prime.moverAlgoformer(posicionDestino);
		
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
		
		megatron.moverAlgoformer(posicionDestino);
		
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
		
		megatron.moverAlgoformer(posicionDestino);
		
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
		
		megatron.moverAlgoformer(posicionDestino);
		
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
		
		megatron.moverAlgoformer(posicionDestino);
		
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
		
		megatron.moverAlgoformer(posicionDestino);
		
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
		
		//megatron.moverAlgoformer(posicionDestino);
		
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
		
		megatron.moverAlgoformer(posicionDestino);
		
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
		
		megatron.moverAlgoformer(posicionDestino);
		
		int ataqueAfectado = megatron.getAtaque();
		
		Posicion posicionDestinoDeVuelta = new Posicion(1,1); 
		
		megatron.moverAlgoformer(posicionDestinoDeVuelta);
		
		Assert.assertEquals(megatron.getAtaque(),ataqueAfectado);
	}
	
}
