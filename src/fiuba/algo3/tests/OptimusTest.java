package fiuba.algo3.tests;


import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Optimus;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsHumanoide;

public class OptimusTest {
	
	@Test(expected=TransformacionIncorresctaYaEsHumanoide.class)
	public void testOptimusTransformarHumanoide () {
		
		Optimus prime = new Optimus();
		
		prime.transformarHumanoide();
		
		prime.transformarHumanoide();
		
	}

}
