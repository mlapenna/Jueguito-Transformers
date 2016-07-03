package fiuba.algo3.tests.unitarios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.modelos.Turno;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.algoformers.BumbleBee;
import fiuba.algo3.modelos.algoformers.Megatron;
import fiuba.algo3.modelos.algoformers.Menasor;
import fiuba.algo3.modelos.algoformers.Optimus;
import fiuba.algo3.modelos.algoformers.Superion;
import fiuba.algo3.modelos.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelos.excepciones.AlgoformersNoAlineadosExcepcion;
import fiuba.algo3.modelos.excepciones.AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion;
import fiuba.algo3.modelos.excepciones.CantidadDeAlgoformersInsuficienteExcepcion;

import org.junit.Assert;
import org.junit.Test;

public class AlgoformerTests {

	@Test(expected=AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion.class)
	public void testValidarQueNoSePuedenAtacarASuMismoEquipo() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posOptimus = new Posicion(1,1);
		Posicion posMegatron = new Posicion (2,1);
		Posicion posBumbleBee = new Posicion (1,2);
		
		Algoformer optimus = new Optimus(posOptimus, tablero, new Turno() );
		Algoformer megatron = new Megatron(posMegatron, tablero, new Turno() );
		Algoformer bumbleBee = new BumbleBee(posBumbleBee, tablero, new Turno() );
		
		optimus.validarQueSePuedeAtacar(megatron);
		optimus.validarQueSePuedeAtacar(bumbleBee);	
	}
	
	@Test(expected=AlgoformerInmovilizadoExcepcion.class)
	public void testValidarQueNoSePuedenMoverCuandoEstaAtrapado() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posDestino = new Posicion(2,1);
		Posicion posOptimus = new Posicion(1,1);
		Algoformer optimus = new Optimus(posOptimus, tablero, new Turno() );
		
		optimus.establecerTurnosAtrapado(3);
		optimus.mover(posDestino);
	}
	

	@Test
	public void testMoverAlgoformer() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero, "Pedro", "Juan");

		Jugador jugador1 = juego.getJugador1();
		Iterator<Algoformer> robotsJugador1 = jugador1.getAlgoformersIterator();
		Algoformer unRobotJugador1 = robotsJugador1.next();
		
		Posicion posDestino = new Posicion(2,0);
		
		unRobotJugador1.mover(posDestino);
		Assert.assertEquals(unRobotJugador1.getPosicion(),posDestino);		
	}
	
	@Test
	public void testPreguntarSiEsDecepticonOAutobot() throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));

		Algoformer optimus = new Optimus(new Posicion(0,0),new Tablero(jsonTablero),new Turno());
		Algoformer megatron = new Megatron(new Posicion(0,0),new Tablero(jsonTablero),new Turno());
		
		Assert.assertTrue(optimus.esAutobot());
		Assert.assertFalse(megatron.esAutobot());
		Assert.assertFalse(optimus.esDecepticon());
		Assert.assertTrue(megatron.esDecepticon());
	}
	
	@Test
	public void testMatarAlgoformer() throws IOException, ParseException, AlgoformersNoAlineadosExcepcion,
			CantidadDeAlgoformersInsuficienteExcepcion {
	
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero, "Pedro", "Juan");
	
		Jugador jugador1 = juego.getJugador1();
		Jugador jugador2 = juego.getJugador2();
		String nombre = jugador1.nombre();
	    ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
	    Algoformer rival = jugador2.getAlgoformers().get(1);
	    Algoformer ratchet = algoformers.get(2);//(0,4)
	    ratchet.cambiarModo();
	    rival.cambiarModo();
	    ratchet.mover(new Posicion(3,4));//esquivo la chispa en (4,4)
	    rival.cambiarModo();
	    ratchet.mover(new Posicion(3,7));
	    rival.cambiarModo();
	    ratchet.mover(new Posicion(7,7));
	    
	    for(int i=0; i<6; i++){
	    	rival.cambiarModo();
	    	ratchet.atacar(rival);
	    }
	    Assert.assertTrue(!rival.estaVivo());
	    
	}
	
	@Test(expected = NullPointerException.class)
	public void testEliminarAlgoformer() throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		
		Algoformer optimus = new Optimus(new Posicion(0,0),new Tablero(jsonTablero),new Turno());
		optimus.eliminar();
		optimus.mover(new Posicion(0,0));
	}
	
	@Test
	public void agarrarLaChispa() throws IOException, ParseException, AlgoformersNoAlineadosExcepcion,
			CantidadDeAlgoformersInsuficienteExcepcion {
	
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero, "Pedro", "Juan");
	    //LA CHISPA ESTA EN (4,4)
		Jugador jugador1 = juego.getJugador1();
		Jugador jugador2 = juego.getJugador2();
		String nombre = jugador1.nombre();
	    ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
	    Algoformer rival = jugador2.getAlgoformers().get(1);
	    Algoformer ratchet = algoformers.get(2);//(0,4)
	    ratchet.cambiarModo();
	    rival.cambiarModo();
	    ratchet.mover(new Posicion(4,4));
	    
	    Assert.assertTrue(ratchet.tieneLaChispa());
	}
	
	@Test
	public void testPreguntarSiEsUnRobotCombinado() throws FileNotFoundException, IOException, ParseException{
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));

		Algoformer megatron = new Megatron(new Posicion(0,0),new Tablero(jsonTablero),new Turno());
		Algoformer menasor = new Menasor(new Posicion(0,0),new Tablero(jsonTablero),new Turno());
		Algoformer superion = new Superion(new Posicion(0,0),new Tablero(jsonTablero),new Turno());
		
		Assert.assertTrue(menasor.esUnRobotCombinado());
		Assert.assertFalse(megatron.esUnRobotCombinado());
		Assert.assertTrue(superion.esUnRobotCombinado());
	}
}
