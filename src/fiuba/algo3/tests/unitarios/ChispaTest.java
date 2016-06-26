package fiuba.algo3.tests.unitarios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelos.ChispaSuprema;

public class ChispaTest {

	@Test
	public void testEsChispa() {
		ChispaSuprema chispa = new ChispaSuprema();
		Assert.assertTrue(chispa.esChispa());
		Assert.assertTrue(chispa.hayAlgo());
	}

}
