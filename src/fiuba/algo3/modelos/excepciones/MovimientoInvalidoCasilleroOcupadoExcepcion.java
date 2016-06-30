package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoCasilleroOcupadoExcepcion extends RuntimeExceptionConMensajes {

	private String title = "Movimiento Inv\u00e1lido";
	private String header = "El recorrido atraviesa al menos un casillero ocupado.";
	private String content = "";

}
