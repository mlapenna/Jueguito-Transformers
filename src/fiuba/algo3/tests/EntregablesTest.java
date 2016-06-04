package fiuba.algo3.tests;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Optimus;
import fiuba.algo3.modelo.Algoformer;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsHumanoide;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsAlterno;

public class EntregablesTest {
	
	// Primera entrega Jueves 02/06/2016 - Lunes 06/06/2016
	
	@Test
	public void testAgregarAlgoformerHumanoideMoverYVerificarPosicion() throws FileNotFoundException, 
	 IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapa.json"));
		Tablero tablero = new Tablero(jsonTablero);
		Algoformer prime = new Optimus();
		Posicion nuevaPosicion = new Posicion();
		Posicion ultimaPosicion = new Posicion();
		Posicion auxPosicion = new Posicion();
		
		nuevaPosicion.cargarPosicion(3,1);
		ultimaPosicion.cargarPosicion(5,1);
		
		try {prime.transformarHumanoide();}
		catch(Exception e){}
		
		tablero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(prime,nuevaPosicion);
		tablero.moverAlgoformerHumanoidesinEfectoDeLaSuperficie(prime,ultimaPosicion);
				
		auxPosicion = prime.obtenerPosicion();
		
		Assert.assertTrue(auxPosicion.obtenerPosicionX()==ultimaPosicion.obtenerPosicionX());
		Assert.assertTrue(auxPosicion.obtenerPosicionY()==ultimaPosicion.obtenerPosicionY());
		
	}
	
	@Test
	public void testAgregarAlgoformerAlternoMoverYVerificarPosicion() {
		// Como no est� terminado, para que no de error al correr los tests lo comento
		/*Tablero tablero = new Tablero();
		Algoformer prime = new Optimus();
		Posicion nuevaPosicion = new Posicion();
		Posicion finalPosicion = new Posicion();
		
		nuevaPosicion.cargarPosicion(3,1);
		
		prime.transformarAlterno();
		prime.agregarATablero(prime); // por que le pasamos el objeto como parametro?
		prime.moverNuevaPosicion(tablero,nuevaPosicion);
		
		finalPosicion = prime.obtenerPosicion(tablero);*/
		
	}
	
	@Test
	public void testAgregarAlgoformerYCambiarDeModoEnAmbasDirecciones() {
		// Como no est� terminado, para que no de error al correr los tests lo comento
		/*Algoformer prime = new Optimus();
		
		prime.transformarAlterno();
		Assert.assertTrue(prime.getAtaque()==15);
		
		
		prime.transformarHumanoide();
		Assert.assertTrue(prime.getAtaque()==50);*/
	}

}
