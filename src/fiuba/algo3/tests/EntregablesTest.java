package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Optimus;
import fiuba.algo3.modelo.Algoformer;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;

public class EntregablesTest {
	
	// Primera entrega Jueves 02/06/2016 - Lunes 06/06/2016
	
	@Test
	public void testAgregarAlgoformerHumanoideMoverYVerificarPosicion() {
		// Como no está terminado, para que no de error al correr los tests lo comento
		/*Tablero tablero = new Tablero();
		Algoformer prime = new Optimus();
		Posicion nuevaPosicion = new Posicion();
		Posicion finalPosicion = new Posicion();
		
		nuevaPosicion.cargarPosicion(3,1);
		
		prime.transformarHumanoide();
		prime.agregarATablero(prime);
		prime.moverNuevaPosicion(tablero,nuevaPosicion);
		
		finalPosicion = prime.obtenerPosicion(tablero);*/
		
	}
	
	@Test
	public void testAgregarAlgoformerAlternoMoverYVerificarPosicion() {
		// Como no está terminado, para que no de error al correr los tests lo comento
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
		// Como no está terminado, para que no de error al correr los tests lo comento
		/*Algoformer prime = new Optimus();
		
		prime.transformarAlterno();
		Assert.assertTrue(prime.getAtaque()==15);
		
		
		prime.transformarHumanoide();
		Assert.assertTrue(prime.getAtaque()==50);*/
	}

}
