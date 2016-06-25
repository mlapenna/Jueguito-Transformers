package fiuba.algo3.tests.unitarios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelos.Chispa;

public class ChispaTest {

	@Test
	public void testEsChispa() {
		Chispa chispa = new Chispa();
		Assert.assertTrue(chispa.esChispa());
		Assert.assertTrue(chispa.hayAlgo());
	}

}
