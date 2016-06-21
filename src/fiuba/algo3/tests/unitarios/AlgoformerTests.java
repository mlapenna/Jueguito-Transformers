package fiuba.algo3.tests.unitarios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.algoformers.BumbleBee;
import fiuba.algo3.modelos.algoformers.Megatron;
import fiuba.algo3.modelos.algoformers.Optimus;
import fiuba.algo3.modelos.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelos.excepciones.AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion;
import org.junit.Assert;
import org.junit.Test;

public class AlgoformerTests {

	@Test(expected=AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion.class)
	public void testValidarQueNoSePuedenAtacarASuMismoEquipo() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posOptimus = new Posicion(1,1);
		Posicion posMegatron = new Posicion (2,1);
		Posicion posBumbleBee = new Posicion (1,2);
		
		Algoformer optimus = new Optimus(posOptimus,tablero);
		Algoformer megatron = new Megatron(posMegatron,tablero);
		Algoformer bumbleBee = new BumbleBee(posBumbleBee,tablero);
		
		optimus.validarQueSePuedeAtacar(megatron);
		optimus.validarQueSePuedeAtacar(bumbleBee);	
	}
	
	@Test(expected=AlgoformerInmovilizadoExcepcion.class)
	public void testValidarQueNoSePuedenMoverCuandoEstaAtrapado() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posDestino = new Posicion(2,1);
		Posicion posOptimus = new Posicion(1,1);
		Algoformer optimus = new Optimus(posOptimus,tablero);
		
		optimus.establecerTurnosAtrapado(3);
		optimus.mover(posDestino);
	}
	

	@Test
	public void testMoverAlgoformer() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
		Tablero tablero = new Tablero(jsonTablero);
		
		Posicion posDestino = new Posicion(2,1);
		Posicion posOptimus = new Posicion(1,1);
		Algoformer optimus = new Optimus(posOptimus,tablero);
		
		optimus.mover(posDestino);
		Assert.assertEquals(optimus.getPosicion(),posDestino);		
	}

}
