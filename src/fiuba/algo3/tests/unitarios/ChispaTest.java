package fiuba.algo3.tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelos.Chispa;
import junit.framework.Assert;

public class ChispaTest {

	@Test
	public void testEsChispa() {
		Chispa chispa = new Chispa();
		Assert.assertTrue(chispa.esChispa());
		Assert.assertTrue(chispa.hayAlgo());
	}

}
