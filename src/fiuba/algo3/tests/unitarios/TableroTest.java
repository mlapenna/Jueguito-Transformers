package fiuba.algo3.tests.unitarios;

import fiuba.algo3.modelos.Tablero;

import org.junit.Test;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;


public class TableroTest {

	@Test
	public void testAgregarAlgoformerHumanoide () throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);

	}
	
	
}
