package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoCasilleroOcupadoExcepcion extends RuntimeException {
    public MovimientoInvalidoCasilleroOcupadoExcepcion() {
        super();
    }
	private String title = "Movimiento Inv\u00e1lido";
	private String header = "El recorrido atraviesa al menos un casillero ocupado.";
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
