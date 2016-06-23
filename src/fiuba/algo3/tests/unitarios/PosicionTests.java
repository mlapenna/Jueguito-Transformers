package fiuba.algo3.tests.unitarios;

import fiuba.algo3.modelos.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class PosicionTests {

	@Test
	public void testAgregarTresPosicionesAlineadosYPreguntarSiLoEstan() {
		Posicion posicion1 = new Posicion(0,0);
		Posicion posicion2 = new Posicion(0,1);
		Posicion posicion3 = new Posicion(0,2);
		
		Assert.assertTrue(posicion1.sePuedenCombinar(posicion2, posicion3));
	}

	@Test
	public void testAgregarTresPosicionesNoAlineadosYPreguntarSiLoEstan() {
		Posicion posicion1 = new Posicion(1,0);
		Posicion posicion2 = new Posicion(0,1);
		Posicion posicion3 = new Posicion(0,2);
		
		Assert.assertFalse(posicion1.sePuedenCombinar(posicion2, posicion3));
	}
	
	@Test
	public void testAgregarTresPosicionesNoConsecutivasYPreguntarSiLoSon() {
		Posicion posicion1 = new Posicion(0,0);
		Posicion posicion2 = new Posicion(0,1);
		Posicion posicion3 = new Posicion(0,3);
		
		Assert.assertFalse(posicion1.sePuedenCombinar(posicion2, posicion3));
	}
}
