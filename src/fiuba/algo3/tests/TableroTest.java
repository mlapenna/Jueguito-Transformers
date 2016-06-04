package fiuba.algo3.tests;

import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.Algoformer;
import fiuba.algo3.modelo.Optimus;
import fiuba.algo3.modelo.Posicion;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileNotFoundException;


public class TableroTest {

	@Test
	public void testAgregarAlgoformerHumanoideSinEfectoDeSuperficie ()  throws FileNotFoundException, 
	 IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer algoformer = new Optimus();

		Posicion nuevaPosicion = new Posicion();

		nuevaPosicion.cargarPosicion(3,1);

		tablero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer, nuevaPosicion);
		Posicion algoformerPosicion = algoformer.obtenerPosicion();

		System.out.println(algoformer.obtenerPosicion().obtenerPosicionX());
		System.out.println(algoformer.obtenerPosicion().obtenerPosicionY());
		
		Assert.assertTrue( nuevaPosicion.obtenerPosicionX() == algoformerPosicion.obtenerPosicionX() );
		Assert.assertTrue( nuevaPosicion.obtenerPosicionY() == algoformerPosicion.obtenerPosicionY() );
	}
	
	
}
