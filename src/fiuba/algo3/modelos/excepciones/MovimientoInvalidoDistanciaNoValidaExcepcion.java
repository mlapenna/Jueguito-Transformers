package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoDistanciaNoValidaExcepcion extends RuntimeException{
    public MovimientoInvalidoDistanciaNoValidaExcepcion() {
        super();
    }
    private String title = "Movimiento Inv\u00e1lido";
    private String header = "La distancia solicitada supera la velocidad del Algoformer.";
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
