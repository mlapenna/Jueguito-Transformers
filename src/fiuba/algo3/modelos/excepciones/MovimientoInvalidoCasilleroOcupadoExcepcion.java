package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoCasilleroOcupadoExcepcion extends RuntimeException {
    public MovimientoInvalidoCasilleroOcupadoExcepcion() {
        super();
    }
	private String title = "Movimiento Invalido";
	private String header = "Casillero Ocupado";
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
