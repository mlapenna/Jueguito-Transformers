package fiuba.algo3.tests.unitarios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelos.ChispaSuprema;
import fiuba.algo3.modelos.Posicion;

public class ChispaTest {

	@Test
	public void testEsChispa() {
		ChispaSuprema chispa = new ChispaSuprema(new Posicion(4,4));
		Assert.assertTrue(chispa.esChispa());
		Assert.assertTrue(chispa.hayAlgo());
	}
	
	//TEST GANAR POR CHISPA EN INTEGRADORES

}
