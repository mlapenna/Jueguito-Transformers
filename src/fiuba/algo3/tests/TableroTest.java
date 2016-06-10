package fiuba.algo3.tests;

import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.algoformers.Optimus;
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
	public void testAgregarAlgoformerHumanoideSinEfectoDeSuperficie () throws FileNotFoundException, 
	 IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		/*
		Algoformer algoformer = new Optimus();
		Posicion nuevaPosicion = new Posicion(3,1);

		tablero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer, nuevaPosicion);
		Posicion algoformerPosicion = algoformer.getPosicion();

		Assert.assertEquals(nuevaPosicion, algoformerPosicion);
		*/
	}
	
	
}
