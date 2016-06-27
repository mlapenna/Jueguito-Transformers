package fiuba.algo3.modelos.excepciones;

public class CantidadDeAlgoformersInsuficienteException extends RuntimeException {

	
	private String title = "";
	private String header = "Parece que algo sucedió con tus algoformers!!!";
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
