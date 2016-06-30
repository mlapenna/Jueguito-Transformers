package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoCasilleroInvalidoExcepcion extends RuntimeExceptionConMensajes {
    
	public MovimientoInvalidoCasilleroInvalidoExcepcion() {
        super();
		this.title = "Movimiento Invalido";
		this.header = "No puede realizar el movimiento solicitado.";
		this.content = "";
    }

}
