package fiuba.algo3.modelos.excepciones;

/**
 * Created by Yo on 09/06/2016.
 */
public class ZonaPantanoProhibidoPasarExcepcion extends RuntimeException {
    public ZonaPantanoProhibidoPasarExcepcion() {
        super();
    }
	private String title = "Zona Pantano";
	private String header = "Prohibido Pasar";
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
