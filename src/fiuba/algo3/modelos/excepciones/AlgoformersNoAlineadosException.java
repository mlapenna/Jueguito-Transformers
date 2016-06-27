package fiuba.algo3.modelos.excepciones;

public class AlgoformersNoAlineadosException extends RuntimeException {

	   public AlgoformersNoAlineadosException() {
	        super();
	    }
	
	private String title = "Movimiento inválido.";
	private String header = "Casilleros seleccionados incorrectos.";
	private String content = "El algoformer no puede moverse en esa dirección.";
	
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
