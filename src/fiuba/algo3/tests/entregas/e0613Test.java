package fiuba.algo3.tests.entregas;

import java.io.FileReader;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.algoformers.*;
import fiuba.algo3.modelo.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;
import fiuba.algo3.modelo.Posicion;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class e0613Test {

	// ENTREGA PUNTO 1
	@Test
	public void testLlenarZonaRocasYHacerPasarAOptimusHumanoidePorElla() throws IOException, ParseException {

		// El tablero contiene 4 casilleros en distribucion horizontal,
		// todos con superficie terrestre Rocas, el algoformer en el casillero
		// de la izquierda.
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Optimus optimus = new Optimus(posicion, tablero);

		int vidaOriginal = optimus.getVida();

		Posicion posicionDestino = new Posicion(2, 0);

		optimus.mover(posicionDestino);

		Assert.assertEquals(posicionDestino, optimus.getPosicion());
		Assert.assertEquals(vidaOriginal, optimus.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAOptimusAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Optimus prime = new Optimus(posicion, tablero);
		int vidaOriginal = prime.getVida();
		Posicion posicionDestino = new Posicion(3, 0);

		prime.cambiarModo();

		prime.mover(posicionDestino);

		Assert.assertEquals(prime.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, prime.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarARatchetHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer ratchet = new Ratchet(posicion, tablero);
		int vidaOriginal = ratchet.getVida();
		Posicion posicionDestino = new Posicion(1, 0);

		ratchet.mover(posicionDestino);

		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, ratchet.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarARatchetAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer ratchet = new Ratchet(posicion, tablero);
		int vidaOriginal = ratchet.getVida();
		Posicion posicionDestino = new Posicion(3, 0);

		ratchet.cambiarModo();

		ratchet.mover(posicionDestino);

		Assert.assertEquals(ratchet.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, ratchet.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarABumbleBeeHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer bumblebee = new BumbleBee(posicion, tablero);
		int vidaOriginal = bumblebee.getVida();
		Posicion posicionDestino = new Posicion(2, 0);

		bumblebee.mover(posicionDestino);

		Assert.assertEquals(bumblebee.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, bumblebee.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarABumbleBeeAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer bumblebee = new BumbleBee(posicion, tablero);
		int vidaOriginal = bumblebee.getVida();
		Posicion posicionDestino = new Posicion(3, 0);

		bumblebee.cambiarModo();

		bumblebee.mover(posicionDestino);

		Assert.assertEquals(bumblebee.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, bumblebee.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarASuperionPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer superion = new Superion(posicion, tablero);
		int vidaOriginal = superion.getVida();
		Posicion posicionDestino = new Posicion(3, 0);

		superion.mover(posicionDestino);

		Assert.assertEquals(superion.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, superion.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAMegatronHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion, tablero);
		int vidaOriginal = megatron.getVida();
		Posicion posicionDestino = new Posicion(2, 0);

		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, megatron.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAMegatronAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion, tablero);
		int vidaOriginal = megatron.getVida();
		Posicion posicionDestino = new Posicion(0, 0);

		megatron.cambiarModo();

		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, megatron.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarABonecrusherHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer bonecrusher = new Bonecrusher(posicion, tablero);
		int vidaOriginal = bonecrusher.getVida();
		Posicion posicionDestino = new Posicion(2, 0);

		bonecrusher.mover(posicionDestino);

		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, bonecrusher.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarABonecrusherAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer bonecrusher = new Bonecrusher(posicion, tablero);
		int vidaOriginal = bonecrusher.getVida();
		Posicion posicionDestino = new Posicion(0, 0);

		bonecrusher.cambiarModo();

		bonecrusher.mover(posicionDestino);

		Assert.assertEquals(bonecrusher.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, bonecrusher.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAFrenzyHumanoidePorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer frenzy = new Frenzy(posicion, tablero);
		int vidaOriginal = frenzy.getVida();
		Posicion posicionDestino = new Posicion(1, 0);

		frenzy.mover(posicionDestino);

		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, frenzy.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAFrenzyAlternoPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer frenzy = new Frenzy(posicion, tablero);
		int vidaOriginal = frenzy.getVida();
		Posicion posicionDestino = new Posicion(0, 0);

		frenzy.cambiarModo();

		frenzy.mover(posicionDestino);

		Assert.assertEquals(frenzy.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, frenzy.getVida());
	}

	@Test
	public void testLlenarZonaRocasYHacerPasarAMenasorPorElla() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer menasor = new Menasor(posicion, tablero);
		int vidaOriginal = menasor.getVida();
		Posicion posicionDestino = new Posicion(2, 0);

		menasor.mover(posicionDestino);

		Assert.assertEquals(menasor.getPosicion(), posicionDestino);
		Assert.assertEquals(vidaOriginal, menasor.getVida());
	}

	// ENTREGA PUNTO 2
	@Test(expected = MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.class)
	public void testLlenarZonaPantanoYVerificarEnModoHumanoideNoSePuedeAtravasar() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer prime = new Optimus(posicion, tablero);
		Posicion posicionDestino = new Posicion(2, 0);

		prime.mover(posicionDestino);

	}

	// ENTREGA PUNTO 3
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoSeTardaElDobleQueEnElRocosoSeRealizaUnMovimiento() throws IOException, ParseException{

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer prime = new Optimus(posicion,tablero);
		Posicion posicionDestino = new Posicion(2,0);

		prime.cambiarModo();

		prime.mover(posicionDestino);

		Posicion posicionEsperda = new Posicion(1,0);
		Assert.assertEquals(posicion,posicionEsperda);
	}

	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoSeTardaElDobleQueEnElRocosoSeRealizaDosMovimientos()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(0, 0);
		Algoformer prime = new Optimus(posicion, tablero);
		Posicion posicionDestino = new Posicion(2, 0);

		prime.cambiarModo();

		prime.mover(posicionDestino);
		prime.nuevoTurno();
		prime.mover(posicionDestino);
		Assert.assertEquals(prime.getPosicion(), posicionDestino);
	}

	// ENTREGA PUNTO 4
	@Test
	public void testLlenarZonaPantanoYVerificarEnModoAlternoAereoSeAtraviesaSinProblemas()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion, tablero);
		Posicion posicionDestino = new Posicion(1, 0);

		// Megatron alterno es unidad aerea
		megatron.cambiarModo();

		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}

	// ENTREGA PUNTO 5
	@Test
	public void testLlenarZonaEspinasYVerificarQueLaVidaDeUnidadesTerrestresDiminuyeAlPasarUnCasillero()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion, tablero);
		Posicion posicionDestino = new Posicion(2, 0);

		int cantidadDeCasillerosAtravesados = posicion.getX() - posicionDestino.getX();

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
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicion = new Posicion(3, 0);
		Algoformer bonecrusher = new Bonecrusher(posicion, tablero);
		Posicion posicionDestino = new Posicion(2, 0);
		int cantidadDeCasillerosAtravesados = posicion.getX() - posicionDestino.getX();

		double vidaInicial = bonecrusher.getVida();
		int vidaEsperada = (int) (vidaInicial * (1 - (cantidadDeCasillerosAtravesados * 0.05)));

		bonecrusher.mover(posicionDestino);

		Assert.assertEquals(bonecrusher.getVida(), vidaEsperada);
	}

	// ENTREGA PUNTO 6
	@Test
	public void testLlenarZonaEspinasYVerificarQueUnidadesAereasNoSonAfectadas() throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaEspinas.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion, tablero);
		Posicion posicionDestino = new Posicion(2, 0);

		int vidaInicial = megatron.getVida();

		megatron.cambiarModo();

		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getVida(), vidaInicial);
	}

	// ENTREGA PUNTO 7
	@Test
	public void testLlenarZonaNubesYVerificarEnModoAlternoAereoSeAtraviesaSinProblemas()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNubes.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion, tablero);
		Posicion posicionDestino = new Posicion(2, 0);

		// Megatron alterno es unidad aerea
		megatron.cambiarModo();

		megatron.mover(posicionDestino);

		Assert.assertEquals(megatron.getPosicion(), posicionDestino);
	}

	// ENTREGA PUNTO 8
	@Test
	public void testLlenarZonaNebulosaDeAndromedaYVerificarEnModoAlternoAereoUnaUnidadSeQuedaAtrapadaPorTresTurnosSinMoverse() throws IOException, ParseException{

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaNebulosaDeAndromeda.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion,tablero);
		Posicion posicionDestino = new Posicion(1,0);

		// Megatron alterno es unidad aerea
		megatron.cambiarModo();


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


	// ENTREGA PUNTO 9
	@Test
	public void testLlenarZonaTormentaPsionicaYVerificarQueUnidadesAereasDismunyenCapacidadDeAtaque()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaTormentaPsionica.json"));
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion, tablero);
		Posicion posicionDestino = new Posicion(2, 0);

		megatron.cambiarModo();

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
		Tablero tablero = new Tablero(jsonTablero);

		Posicion posicion = new Posicion(3, 0);
		Algoformer megatron = new Megatron(posicion, tablero);
		Posicion posicionDestino = new Posicion(2, 0);

		megatron.cambiarModo();

		double ataqueInicial = (double) megatron.getAtaque();
		megatron.mover(posicionDestino);

		int ataqueEsperado = (int) (ataqueInicial * (0.4));

		Posicion posicionDestinoDeVuelta = new Posicion(1, 0);

		Assert.assertEquals(megatron.getAtaque(), ataqueEsperado);

		megatron.mover(posicionDestinoDeVuelta);

		Assert.assertEquals(megatron.getAtaque(), ataqueEsperado);
	}

}
