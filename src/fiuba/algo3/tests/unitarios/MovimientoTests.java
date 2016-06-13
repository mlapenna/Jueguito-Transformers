package fiuba.algo3.tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.movimientos.MovimientoHumanoide;

public class MovimientoTests {

	@Test
	public void testPasoUnMovimientoDiagonalYOtroNoDiagonalYPreguntoSiEsDiagonalPuro() {
		Movimiento movimiento = new MovimientoHumanoide();
		Posicion posOrigen = new Posicion(1,1);
		Posicion posDestinoDiagonal = new Posicion(3,3);
		Posicion posDestinoNoDiagonal = new Posicion(3,4);
		
		Assert.assertTrue(movimiento.esDiagonalPuro(posOrigen, posDestinoDiagonal));
		Assert.assertFalse(movimiento.esDiagonalPuro(posOrigen, posDestinoNoDiagonal));
	}
	
	@Test
	public void testPasoUnMovimientoRectoYOtroNoRectoYPreguntoSiEsHorizontalOVerticalPuro() {
		Movimiento movimiento = new MovimientoHumanoide();
		Posicion posOrigen = new Posicion(1,1);
		Posicion posDestinoVertical = new Posicion(3,1);
		Posicion posDestinoHorizontal = new Posicion(1,3);
		Posicion posDestinoDiagonal = new Posicion(3,3);
		
		Assert.assertTrue(movimiento.esHorizontalOVerticalPuro(posOrigen,posDestinoVertical));
		Assert.assertTrue(movimiento.esHorizontalOVerticalPuro(posOrigen, posDestinoHorizontal));
		Assert.assertFalse(movimiento.esHorizontalOVerticalPuro(posOrigen, posDestinoDiagonal));
	}
	
}
