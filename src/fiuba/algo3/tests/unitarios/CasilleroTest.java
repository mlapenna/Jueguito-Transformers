package fiuba.algo3.tests.unitarios;

import fiuba.algo3.modelos.*;
import fiuba.algo3.modelos.algoformers.Optimus;
import fiuba.algo3.modelos.superficies.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;


public class CasilleroTest {

	@Test
	public void testCrearCasilleroVerificarQueElContenidoEsVacio() {
		Casillero casillero = new Casillero();
		Assert.assertEquals(casillero.getContenido(), Vacio.getInstancia());
	}


	@Test
	public void testCrearCasilleroVerificarSuperficiesRocasYNube() {
		Casillero casillero = new Casillero();
		JSONObject superficies = new JSONObject();

		superficies.put("tierra", "Rocas");
		superficies.put("aire", "Nube");

		casillero.setSuperficies(superficies);

		Assert.assertTrue(casillero.getSuperficieTierra() instanceof Rocas);
		Assert.assertTrue(casillero.getSuperficieAire() instanceof Nube);
	}


	@Test
	public void testCrearCasilleroVerificarSuperficiesPantanoYNebulosaDeAndromeda() {
		Casillero casillero = new Casillero();
		JSONObject superficies = new JSONObject();

		superficies.put("tierra", "Pantano");
		superficies.put("aire", "NebulosaDeAndromeda");

		casillero.setSuperficies(superficies);

		Assert.assertTrue(casillero.getSuperficieTierra() instanceof Pantano);
		Assert.assertTrue(casillero.getSuperficieAire() instanceof NebulosaDeAndromeda);
	}


	@Test
	public void testCrearCasilleroVerificarSuperficiesEspinasYTormentaPsionica() {
		Casillero casillero = new Casillero();
		JSONObject superficies = new JSONObject();

		superficies.put("tierra", "Espinas");
		superficies.put("aire", "TormentaPsionica");

		casillero.setSuperficies(superficies);

		Assert.assertTrue(casillero.getSuperficieTierra() instanceof Espinas);
		Assert.assertTrue(casillero.getSuperficieAire() instanceof TormentaPsionica);
	}


	@Test
	public void testCrearCasilleroPonerAlgoformer()  throws IOException, ParseException {
		Casillero casillero = new Casillero();
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Posicion posicion = new Posicion(0,2);

		Assert.assertEquals(casillero.getContenido(), Vacio.getInstancia());

		Optimus optimus = new Optimus(posicion, tablero, new Turno());

		casillero.setContenido(optimus);

		// Los setters y getters creo que no deberían testearse, lo dejamos?
		Assert.assertEquals(casillero.getContenido(), optimus);
	}
}
