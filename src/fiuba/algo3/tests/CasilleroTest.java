package fiuba.algo3.tests;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Algoformer;
import fiuba.algo3.modelo.Optimus;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.MovimientoInvalidoCasilleroOcupado;

public class CasilleroTest {

	@Test	
	public void testAgregarAlgoformerHumanoideSinEfectoDeSuperficieEnCasilleroVacio() {
		// Casillero vacio quiere decir uno nuevo
		
		Casillero casillero = new Casillero();
		Algoformer algoformer = new Optimus();
		Algoformer auxAlgoformer = new Optimus();
		
		casillero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer);
		
		auxAlgoformer = casillero.getAlgoformerContenido();
		
		//Comparo todos los campos de un algoformer
		
		Assert.assertTrue(algoformer.getVida()==auxAlgoformer.getVida());
		Assert.assertTrue(algoformer.getDistanciaDeAtaque()==auxAlgoformer.getDistanciaDeAtaque());
		Assert.assertTrue(algoformer.getAtaque()==auxAlgoformer.getAtaque());
		Assert.assertTrue(algoformer.getVelocidad()==auxAlgoformer.getVelocidad());
	}
	
	@Test(expected=MovimientoInvalidoCasilleroOcupado.class)
	public void testAgregarAlgoformerHumanoideSinEfectoDeSuperficieEnCasilleroOcupado() {
		// Casillero vacio quiere decir uno nuevo
		Casillero casillero = new Casillero();
		Algoformer algoformer = new Optimus();
		Algoformer auxAlgoformer = new Optimus();
		
		casillero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer);
		
		casillero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(auxAlgoformer);
	}
	
	
}
