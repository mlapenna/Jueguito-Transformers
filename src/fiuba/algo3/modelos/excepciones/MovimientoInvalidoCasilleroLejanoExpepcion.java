package fiuba.algo3.modelos.excepciones;

/**
 * Created by Yo on 10/06/2016.
 */
public class MovimientoInvalidoCasilleroLejanoExpepcion extends RuntimeException {
    public MovimientoInvalidoCasilleroLejanoExpepcion() {
        super();
    }
	private String title = "Movimiento Invalido";
	private String header = "Casillero Lejano";
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
