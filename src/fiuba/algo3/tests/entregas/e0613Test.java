package fiuba.algo3.tests.entregas;

import java.io.FileReader;

import fiuba.algo3.modelos.*;
import fiuba.algo3.modelos.algoformers.*;
import fiuba.algo3.modelos.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;
import fiuba.algo3.modelos.Posicion;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class e0613Test {

	// ENTREGA PUNTO 1
	@Test
	public void testLlenarZonaRocasYHacerPasarAOptimusHumanoidePorElla() throws IOException, ParseException {

		// El tablero contiene 4 casilleros en distribucion horizontal,
		// todos con superficie terrestre Rocas, el algoformer en el casillero
		// de la izquierda.
		//9x9 el mapa
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
		Algoformer optimus = algoformers.get(0); //en (0,0) esta
		
		int vidaOriginal = optimus.getVida();
		Posicion posicionDestino = new Posicion(1,0);

		optimus.mover(posicionDestino);

		Assert.assertEquals(optimus.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, optimus.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAOptimusAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
		Algoformer optimus = algoformers.get(0); //en (0,0) esta
		
		int vidaOriginal = optimus.getVida();
		Posicion posicionDestino = new Posicion(3,0);

		optimus.cambiarModo();
		juego.getJugador2().getAlgoformers().get(0).cambiarModo();
		optimus.mover(posicionDestino);

		Assert.assertEquals(optimus.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, optimus.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarARatchetHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
		Algoformer ratchet = algoformers.get(2); //en (0,4) esta
		
		int vidaOriginal = ratchet.getVida();
		Posicion posicionDestino = new Posicion(1,4);

		ratchet.cambiarModo();
		juego.getJugador2().getAlgoformers().get(0).cambiarModo();
		ratchet.mover(posicionDestino);

		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, ratchet.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarARatchetAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
		Algoformer ratchet = algoformers.get(2); //en (0,4) esta
		
		int vidaOriginal = ratchet.getVida();
		Posicion posicionDestino = new Posicion(1,4);

		ratchet.mover(posicionDestino);

		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, ratchet.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarABumbleBeeHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
		Algoformer bumbleBee = algoformers.get(1); //en (0,2) esta
		
		int vidaOriginal = bumbleBee.getVida();
		Posicion posicionDestino = new Posicion(2,2);

		bumbleBee.mover(posicionDestino);

		Assert.assertEquals(bumbleBee.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, bumbleBee.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarABumbleBeeAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
		Algoformer bumbleBee = algoformers.get(1); //en (0,2) esta
		
		int vidaOriginal = bumbleBee.getVida();
		Posicion posicionDestino = new Posicion(5,2);
		
		bumbleBee.cambiarModo();
		juego.getJugador2().getAlgoformers().get(0).cambiarModo();
		bumbleBee.mover(posicionDestino);

		Assert.assertEquals(bumbleBee.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, bumbleBee.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarASuperionPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
		
		algoformers.get(0).mover(new Posicion(0,1));
		juego.getJugador2().getAlgoformers().get(0).cambiarModo();
		algoformers.get(2).mover(new Posicion(0,3));
		juego.getJugador2().getAlgoformers().get(0).cambiarModo();
		
		jugador1.combinarAlgoformers(algoformers.get(0).getTurno()); //SUPERION EN (0,2)
		
		Algoformer superion = jugador1.getAlgoformers().get(0);
		Posicion posicionDestino = new Posicion(2,2);
		int vidaOriginal = superion.getVida();
		superion.mover(posicionDestino);
 
		Assert.assertEquals(superion.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, superion.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAMegatronHumanoidePorElla() throws IOException, ParseException {
		
		//9x9 el mapa
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer megatron = algoformers.get(0); //en (8,4) esta
		
		int vidaOriginal = megatron.getVida();
		Posicion posicionDestino = new Posicion(8,3);

		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, megatron.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAMegatronAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		// Turno 1
		Algoformer unRobotJugador1 = juego.getJugador1().getAlgoformers().get(0);
		unRobotJugador1.cambiarModo();

		Algoformer megatron = juego.getJugador2().getAlgoformers().get(0); //en (8,4) esta
		int vidaOriginal = megatron.getVida();
		Posicion posicionDestino = new Posicion(6, 4);
		megatron.cambiarModo();

		// TURNO 2
		unRobotJugador1.cambiarModo();
		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, megatron.getVida());
	}


	@Test
	public void testLlenarZonaRocasYHacerPasarABonecrusherHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer bonecrusher = algoformers.get(1);
		Posicion posicionDestino = new Posicion(8,7);
		int vidaOriginal = bonecrusher.getVida(); 
		
		bonecrusher.mover(posicionDestino);

		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, bonecrusher.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarABonecrusherAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer bonecrusher = algoformers.get(1);
		Posicion posicionDestino = new Posicion(1,6);
		int vidaOriginal = bonecrusher.getVida(); 
		
		bonecrusher.cambiarModo();
		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		
		bonecrusher.mover(posicionDestino);

		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, bonecrusher.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAFrenzyHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer frenzy = algoformers.get(2);
		Posicion posicionDestino = new Posicion(6,8);
		int vidaOriginal = frenzy.getVida(); 

		frenzy.mover(posicionDestino);

		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, frenzy.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAFrenzyAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer frenzy = algoformers.get(2);
		Posicion posicionDestino = new Posicion(2,8);
		int vidaOriginal = frenzy.getVida(); 

		frenzy.cambiarModo();
		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		frenzy.mover(posicionDestino);

		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, frenzy.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAMenasorPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		
		algoformers.get(0).mover(new Posicion(8,5));
		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		algoformers.get(2).mover(new Posicion(8,7));
		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		
		jugador2.combinarAlgoformers(algoformers.get(0).getTurno()); //MENASOR EN (8,6)
		
		Algoformer menasor = jugador2.getAlgoformers().get(0);
		Posicion posicionDestino = new Posicion(6,6);
		int vidaOriginal = menasor.getVida();
		menasor.mover(posicionDestino);
 
		Assert.assertEquals(menasor.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, menasor.getVida());
	}

	// ENTREGA PUNTO 2
	@Test(expected = MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.class)
	public void testLlenarZonaPantanoYVerificarEnModoHumanoideNoSePuedeAtravasar() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer frenzy = algoformers.get(2);
		Posicion posicionDestino = new Posicion(6,8);
		
		frenzy.mover(posicionDestino);
	}

	// ENTREGA PUNTO 3
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoSeTardaElDobleQueEnElRocosoSeRealizaUnMovimiento() throws IOException, ParseException{

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
		Algoformer optimus = algoformers.get(0);
		Posicion posicionDestino = new Posicion(2,0);
		Posicion posicionEsperada = new Posicion(1,0);
		
		optimus.cambiarModo();
		juego.getJugador2().getAlgoformers().get(0).cambiarModo();
		optimus.mover(posicionDestino);

		Assert.assertEquals(optimus.getPosicion(), posicionEsperada);
	}

	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoSeTardaElDobleQueEnElRocosoSeRealizaDosMovimientos()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano2.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Iterator<Algoformer> robotsJugador1 = jugador1.getAlgoformersIterator();
		Algoformer unRobotJugador1 = robotsJugador1.next();

		Jugador jugador2 = juego.getJugador2();
		Iterator<Algoformer> robotsJugador2 = jugador2.getAlgoformersIterator();
		Algoformer unRobotJugador2 = robotsJugador2.next();

		Posicion posicionDestino = new Posicion(2, 0);

		unRobotJugador1.cambiarModo();

		unRobotJugador2.mover(new Posicion(8, 3));

		unRobotJugador1.mover(posicionDestino);

		unRobotJugador2.mover( new Posicion(9,3) );

		unRobotJugador1.mover(posicionDestino);

		Assert.assertEquals(unRobotJugador1.getPosicion(), posicionDestino);

	}

	// ENTREGA PUNTO 4
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoAereoSeAtraviesaSinProblemas()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer megatron = algoformers.get(0);
		Posicion posicionDestino = new Posicion(7,4);
		
		megatron.cambiarModo();

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		
		megatron.mover(posicionDestino);
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}

	// ENTREGA PUNTO 5
	@Test
	public void testLlenarZonaEspinasYVerificarQueLaVidaDeUnidadesTerrestresDiminuyeAlPasarUnCasillero()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer megatron = algoformers.get(0);
		Posicion posicionDestino = new Posicion(7,4);

		int cantidadDeCasillerosAtravesados = 1;

		double vidaInicial = megatron.getVida();
		int vidaEsperada = (int) (vidaInicial * (1 - (cantidadDeCasillerosAtravesados * 0.05)));

		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getVida(), vidaEsperada);
	}

	@Test
	public void testLlenarZonaEspinasYVerificarQueLaVidaDeUnidadesTerrestresDiminuyeAlPasarMasDeUnCasillero()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer frenzy = algoformers.get(1);
		Posicion posicionDestino = new Posicion(6,8);

		frenzy.cambiarModo();
		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		
		int cantidadDeCasillerosAtravesados = 2;

		double vidaInicial = frenzy.getVida();
		int vidaEsperada = (int) (vidaInicial * (1 - (cantidadDeCasillerosAtravesados * 0.05)));

		frenzy.mover(posicionDestino);

		Assert.assertEquals(frenzy.getVida(), vidaEsperada);
	}

	// ENTREGA PUNTO 6
	@Test
	public void testLlenarZonaEspinasYVerificarQueUnidadesAereasNoSonAfectadas() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer megatron = algoformers.get(0);
		Posicion posicionDestino = new Posicion(6,4);
		int vidaInicial = megatron.getVida();
		megatron.cambiarModo();

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		
		megatron.mover(posicionDestino);
		Assert.assertEquals(megatron.getVida(), vidaInicial);
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}

	// ENTREGA PUNTO 7
	@Test
	public void testLlenarZonaNubesYVerificarEnModoAlternoAereoSeAtraviesaSinProblemas()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNubes.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer megatron = algoformers.get(0);
		Posicion posicionDestino = new Posicion(6,4);
		int vidaInicial = megatron.getVida();
		megatron.cambiarModo();

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		
		megatron.mover(posicionDestino);
		Assert.assertEquals(megatron.getVida(), vidaInicial);
		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}

	// ENTREGA PUNTO 8
	@Test
	public void testLlenarZonaNebulosaDeAndromedaYVerificarEnModoAlternoAereoUnaUnidadSeQuedaAtrapadaPorTresTurnosSinMoverse() throws IOException, ParseException{

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNebulosaDeAndromeda.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Iterator<Algoformer> robotsJugador1 = jugador1.getAlgoformersIterator();
		Algoformer unRobotJugador1 = robotsJugador1.next();

		Jugador jugador2 = juego.getJugador2();
		Iterator<Algoformer> robotsJugador2 = jugador2.getAlgoformersIterator();
		Megatron megatronJugador2 = (Megatron) robotsJugador2.next();
		Bonecrusher bonecrusherJugador2 = (Bonecrusher) robotsJugador2.next();

		// TURNO 1
		unRobotJugador1.mover( new Posicion(2, 0) );

		megatronJugador2.cambiarModo();

		// TURNO 2
		unRobotJugador1.mover(new Posicion(1, 0));

		megatronJugador2.mover(new Posicion(7, 3)); // ATRAVIESA LA NEBULOSA Y QUEDA ATRAPADO 3 TURNOS

		// TURNO 3
		unRobotJugador1.mover( new Posicion(0, 0) );
		try {
			megatronJugador2.mover(new Posicion(6, 3));
			Assert.fail();
		} catch(AlgoformerInmovilizadoExcepcion e) {
		};
		bonecrusherJugador2.mover( new Posicion(9, 6) ); // Se mueve otro robot del mismo jugador nada más para que pase el turno

		// TURNO 4
		unRobotJugador1.mover( new Posicion(2, 0) );
		try {
			megatronJugador2.mover(new Posicion(6, 3));
			Assert.fail();
		} catch(AlgoformerInmovilizadoExcepcion e) {
		};
		bonecrusherJugador2.mover( new Posicion(9, 5) ); // Se mueve otro robot del mismo jugador nada más para que pase el turno

		// TURNO 5
		unRobotJugador1.mover( new Posicion(0, 0) );
		try {
			megatronJugador2.mover(new Posicion(6, 3));
			Assert.fail();
		} catch(AlgoformerInmovilizadoExcepcion e) {
		};
		bonecrusherJugador2.mover( new Posicion(9, 6) ); // Se mueve otro robot del mismo jugador nada más para que pase el turno

		// TURNO 6 - MEGATRON LIBRE
		unRobotJugador1.mover( new Posicion(2, 0) );
		try {
			megatronJugador2.mover(new Posicion(6, 3));  // Ahora se vuelve a mover sin problemas
		} catch(AlgoformerInmovilizadoExcepcion e) {
			Assert.fail();
		};

	}


	// ENTREGA PUNTO 9
	@Test
	public void testLlenarZonaTormentaPsionicaYVerificarQueUnidadesAereasDismunyenCapacidadDeAtaque()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaTormentaPsionica.json"));
		Juego juego = new Juego(jsonTablero);

		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformers = jugador2.getAlgoformers();
		Algoformer megatron = algoformers.get(0);
		Posicion posicionDestino = new Posicion(6,4);
		
		megatron.cambiarModo();
		juego.getJugador1().getAlgoformers().get(0).cambiarModo();
		
		double ataqueInicial = (double) megatron.getAtaque();
		megatron.mover(posicionDestino);

		int ataqueEsperado = (int) (ataqueInicial * 0.4);

		Assert.assertEquals(megatron.getAtaque(), ataqueEsperado);
	}

	// ENTREGA PUNTO 10
	@Test
	public void testLlenarZonaTormentaPsionicaYVerificarQueUnidadesAereasYPasarDosVecesYVerQueNoDismunyenMasSuCapacidadDeAtaque()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaTormentaPsionica.json"));
		Juego juego = new Juego(jsonTablero);

		// Turno 1
		Algoformer unRobotJugador1 = juego.getJugador1().getAlgoformers().get(0);
		unRobotJugador1.cambiarModo();
		Jugador jugador2 = juego.getJugador2();
		ArrayList<Algoformer> algoformersJugador2 = jugador2.getAlgoformers();
		Algoformer megatron = algoformersJugador2.get(0);

		megatron.cambiarModo();

		// Turno 2
		unRobotJugador1.cambiarModo();
		
		double ataqueInicial = (double) megatron.getAtaque();
		megatron.mover(new Posicion(6, 4));

		int ataqueEsperado = (int) (ataqueInicial * 0.4);

		// Turno 3
		unRobotJugador1.cambiarModo();

		Assert.assertEquals(megatron.getAtaque(), ataqueEsperado);
	}

}
