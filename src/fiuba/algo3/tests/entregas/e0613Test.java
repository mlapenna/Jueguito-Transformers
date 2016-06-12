package fiuba.algo3.tests.entregas;

import java.io.FileReader;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.algoformers.*;
import fiuba.algo3.modelo.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsAlternoExcepcion;
import fiuba.algo3.modelo.Posicion;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


public class e0613Test {

	
	@Test
	public void testLlenarZonaRocasYHacerPasarAOptimusHumanoidePorElla() throws IOException, ParseException{

		// El tablero contiene 4 casilleros en distribucion horizontal, 
		// todos con superficie terrestre Rocas, el algoformer en el casillero de la izquierda.
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Optimus optimus = new Optimus(posicion, tablero);

		int vidaOriginal = optimus.getVida();

		Posicion posicionDestino = new Posicion(1, 0);

		optimus.mover(posicionDestino);
		
		Assert.assertEquals(posicionDestino, optimus.getPosicion());
		Assert.assertEquals(vidaOriginal, optimus.getVida());
	}
	

	@Test
	public void testLlenarZonaRocasYHacerPasarAOptimusAlternoPorElla () throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(0, 0);
		Optimus prime = new Optimus(posicion, tablero);
		Posicion posicionDestino = new Posicion(1,0); 

		try {prime.transformarAlterno();}
		catch(Exception e){}
		
		prime.mover(posicionDestino);

		Assert.assertEquals(prime.getPosicion(), posicionDestino);

	}

	@Test
	public void testLlenarZonaRocasYHacerPasarARatchetHumanoidePorElla() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer ratchet = new Ratchet(posicion, tablero);
		Posicion posicionDestino = new Posicion(1,0);
		
		try {ratchet.transformarHumanoide();}
		catch(Exception e){}
		
		ratchet.mover(posicionDestino);
		
		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarARatchetAlternoPorElla () throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer ratchet = new Ratchet(posicion, tablero);
		Posicion posicionDestino = new Posicion(1,0); 

		try {ratchet.transformarAlterno();}
		catch(Exception e){}
		
		ratchet.mover(posicionDestino);

		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarABumbleBeeHumanoidePorElla() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(0, 0);
		Algoformer bumblebee = new BumbleBee(posicion, tablero);
		Posicion posicionDestino = new Posicion(1,0); 
		
		try {bumblebee.transformarHumanoide();}
		catch(Exception e){}
		
		bumblebee.mover(posicionDestino);
		
		Assert.assertEquals(bumblebee.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarABumbleBeeAlternoPorElla () throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(0, 0);
		Algoformer bumblebee = new BumbleBee(posicion, tablero);
		Posicion posicionDestino = new Posicion(1,0); 

		try {bumblebee.transformarAlterno();}
		catch(Exception e){}
		
		bumblebee.mover(posicionDestino);

		Assert.assertEquals(bumblebee.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarASuperionPorElla() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(0, 0);
		Algoformer Superion = new Superion(posicion, tablero);
		Posicion posicionDestino = new Posicion(1,0); 

		Superion.mover(posicionDestino);
		
		Assert.assertEquals(Superion.getPosicion(), posicionDestino);
	}
		
	@Test
	public void testLlenarZonaRocasYHacerPasarAMegatronHumanoidePorElla() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 
		
		try {megatron.transformarHumanoide();}
		catch(Exception e){}
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarAMegatronAlternoPorElla () throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0);

		try {megatron.transformarAlterno();}
		catch(Exception e){}
		
		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
		
	@Test
	public void testLlenarZonaRocasYHacerPasarABonecrusherHumanoidePorElla() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);			
		Algoformer bonecrusher = new Bonecrusher(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 
		
		try {bonecrusher.transformarHumanoide();}
		catch(Exception e){}
		
		bonecrusher.mover(posicionDestino);
		
		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarABonecrusherAlternoPorElla () throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer bonecrusher = new Bonecrusher(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 

		try {bonecrusher.transformarAlterno();}
		catch(Exception e){}
		
		bonecrusher.mover(posicionDestino);

		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarAFrenzyHumanoidePorElla() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer frenzy = new Frenzy(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 
		
		try {frenzy.transformarHumanoide();}
		catch(Exception e){}

		frenzy.mover(posicionDestino);
		
		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaRocasYHacerPasarAFrenzyAlternoPorElla () throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer frenzy = new Frenzy(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 

		try {frenzy.transformarAlterno();}
		catch(Exception e){}
		
		frenzy.mover(posicionDestino);

		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
	}
	
	
	@Test
	public void testLlenarZonaRocasYHacerPasarAMenasorAlternoPorElla () throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer menasor = new Menasor(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); // el destino es la fila 1 columna 3

		try {menasor.transformarAlterno();}
		catch(Exception e){}
		
		menasor.mover(posicionDestino);

		Assert.assertEquals(menasor.getPosicion(), posicionDestino);
	}
	

	//     SEGUNDO TEST
	@Test(expected=MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.class)
	public void testLlenarZonaPantanoYVerificarEnModoHumanoideNoSePuedeAtravasar() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(0, 0);	
		Algoformer prime = new Optimus(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0);
		
		try {prime.transformarHumanoide();}
		catch(Exception e){}

		prime.mover(posicionDestino);
		
	}
	
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoSeTardaElDobleQueEnElRocosoSeRealizaUnMovimiento() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(0, 0);	
		Algoformer prime = new Optimus(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 

		try {prime.transformarAlterno();}
		catch(Exception e){}		
		
		prime.mover(posicionDestino);
		
		Posicion posicionEsperda = new Posicion(1,0);
		Assert.assertEquals(posicion,posicionEsperda);
	}
	
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoSeTardaElDobleQueEnElRocosoSeRealizaDosMovimientos() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(0, 0);	
		Algoformer prime = new Optimus(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 
		
		try {prime.transformarAlterno();}
		catch(Exception e){}		
		
		prime.mover(posicionDestino);
		prime.nuevoTurno();
		prime.mover(posicionDestino);
		Assert.assertEquals(prime.getPosicion(), posicionDestino);
	}
		
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoAereoSeAtraviesaSinProblemas() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(1,0); 

		try {megatron.transformarAlterno();} // Megatron alterno es unidad aerea
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaEspinasYVerificarQueLaVidaDeUnidadesTerrestresDiminuyeAlPasarUnCasillero() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 
		
		int cantidadDeCasillerosAtravesados = posicion.getX()-posicionDestino.getX();
		
		double vidaInicial = megatron.getVida();
		
		try {megatron.transformarHumanoide();}
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertTrue(megatron.getVida() == ((int)(vidaInicial*(1-(cantidadDeCasillerosAtravesados*0.05)))));
	}

	@Test
	public void testLlenarZonaEspinasYVerificarQueLaVidaDeUnidadesTerrestresDiminuyeAlPasarMasDeUnCasillero() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicion = new Posicion(3, 0);	
		Algoformer bonecrusher = new Bonecrusher(posicion,tablero);
		Posicion posicionDestino = new Posicion(1,0); 
		int cantidadDeCasillerosAtravesados = posicion.getX()-posicionDestino.getX();
		
		double vidaInicial = bonecrusher.getVida();
		
		try {bonecrusher.transformarAlterno();}
		catch(Exception e){}		
		
		bonecrusher.mover(posicionDestino);
		
		Assert.assertTrue(bonecrusher.getVida() == (vidaInicial*(1-(cantidadDeCasillerosAtravesados*0.05))));
	}
	
	@Test
	public void testLlenarZonaEspinasYVerificarQueUnidadesAereasNoSonAfectadas() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0); 
		
		int  vidaInicial = megatron.getVida();
		
		try {megatron.transformarAlterno();}
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getVida(),vidaInicial);
	}
	
	@Test
	public void testLlenarZonaNubesYVerificarEnModoAlternoAereoSeAtraviesaSinProblemas() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNubes.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0);

		try {megatron.transformarAlterno();} // Megatron alterno es unidad aerea
		catch(Exception e){}		
		
		megatron.mover(posicionDestino);
		
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}
	
	@Test
	public void testLlenarZonaNebulosaDeAndromedaYVerificarEnModoAlternoAereoUnaUnidadSeQuedaAtrapadaPorTresTurnosSinMoverse() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNebulosaDeAndromeda.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(1,0);

		try {megatron.transformarAlterno();} // Megatron alterno es unidad aerea
		catch(Exception e){}		

		megatron.nuevoTurno();
		megatron.mover(posicionDestino);
		megatron.nuevoTurno();
		try{megatron.mover(posicionDestino);} catch(AlgoformerInmovilizadoExcepcion e) {};
		megatron.nuevoTurno();
		try{megatron.mover(posicionDestino);} catch(AlgoformerInmovilizadoExcepcion e) {};
		megatron.nuevoTurno();
		try{megatron.mover(posicionDestino);} catch(AlgoformerInmovilizadoExcepcion e) {};
		
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}

	@Test
	public void testLlenarZonaTormentaPsionicaYVerificarQueUnidadesAereasDismunyenCapacidadDeAtaque() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaTormentaPsionica.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0);
		
		try {megatron.transformarAlterno();}
		catch(Exception e){}
		
		double ataqueInicial = (double) megatron.getAtaque();
		megatron.mover(posicionDestino);
		
		int ataqueEsperado = (int)(ataqueInicial*(0.4));
		
		Assert.assertEquals(megatron.getAtaque(),ataqueEsperado);
	}

	@Test
	public void testLlenarZonaTormentaPsionicaYVerificarQueUnidadesAereasYPasarDosVecesYVerQueNoDismunyenMasSuCapacidadDeAtaque() throws IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaTormentaPsionica.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posicion = new Posicion(3, 0);	
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0);
		
		try {megatron.transformarAlterno();}
		catch(Exception e){}		
		
		double ataqueInicial = (double) megatron.getAtaque();
		megatron.mover(posicionDestino);
		
		int ataqueEsperado = (int)(ataqueInicial*(0.4));
		
		Posicion posicionDestinoDeVuelta = new Posicion(1,0); 
		
		megatron.mover(posicionDestinoDeVuelta);
		
		Assert.assertEquals(megatron.getAtaque(),ataqueEsperado);
	}
	
}
