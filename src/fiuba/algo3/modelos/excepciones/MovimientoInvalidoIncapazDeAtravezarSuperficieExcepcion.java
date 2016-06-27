package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion extends RuntimeException {
    public MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion() {
        super();
    }
	private String title ="Movimiento Inv\u00e1lido";
	private String header = "El Algoformer en el modo actual no es capaz de atravesar todas las superficies del recorrido.";
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
