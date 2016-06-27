package fiuba.algo3.modelos.excepciones;

public class SuperionNoPuedeTransformarseExcepcion extends RuntimeException {
    public SuperionNoPuedeTransformarseExcepcion() {
        super();
    }
	private String title = "Superion No Puede Transformarse";
	private String header = "";
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
