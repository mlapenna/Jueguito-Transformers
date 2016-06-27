package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion extends RuntimeException {
    public MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion() {
        super();
    }
	private String title = "Movimiento Invalido";
	private String header = "Incapaz De Atravezar Superficie";
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
