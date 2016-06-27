package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoCasilleroInvalidoExcepcion extends RuntimeException {
    public MovimientoInvalidoCasilleroInvalidoExcepcion() {
        super();
    }
	private String title = "Movimiento Invalido";
	private String header = "Casillero Invalido";
	private String content = "";
	
    public String getExcepcionTitulo() {
    	return this.title;
    }

    public String getExcepcionHeader() {
    	return this.header;
    }

    public String getExcepcionContent() {
    	return this.content;
    }

}
