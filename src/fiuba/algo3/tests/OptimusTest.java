package fiuba.algo3.tests;


import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.algoformers.Optimus;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;

public class OptimusTest {
	
	@Test(expected=TransformacionIncorresctaYaEsHumanoideExcepcion.class)
	public void testOptimusTransformarHumanoide () {
		
		Optimus prime = new Optimus();
		
		prime.transformarHumanoide();
		
		prime.transformarHumanoide();
		
	}

}
