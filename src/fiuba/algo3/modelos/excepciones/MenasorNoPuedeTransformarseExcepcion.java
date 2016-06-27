package fiuba.algo3.modelos.excepciones;

public class MenasorNoPuedeTransformarseExcepcion extends RuntimeException {
    public MenasorNoPuedeTransformarseExcepcion() {
        super();
    }
	private String title = "";
	private String header = "Menasor no puede transformarse.";
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
