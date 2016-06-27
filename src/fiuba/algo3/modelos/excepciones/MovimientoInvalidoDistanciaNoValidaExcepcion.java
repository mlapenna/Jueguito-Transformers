package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoDistanciaNoValidaExcepcion extends RuntimeException{
    public MovimientoInvalidoDistanciaNoValidaExcepcion() {
        super();
    }
	private String title = "Movimiento Invalido";
	private String header = "Distancia No Valida";
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
