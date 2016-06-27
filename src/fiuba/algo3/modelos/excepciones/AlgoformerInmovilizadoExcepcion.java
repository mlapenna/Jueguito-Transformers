package fiuba.algo3.modelos.excepciones;

public class AlgoformerInmovilizadoExcepcion extends RuntimeException {

	
    public AlgoformerInmovilizadoExcepcion() {
        super();
    }
	
	private String title = "Movimiento inválido.";
	private String header = "Movimiento de algoformer neutralizado.";
	private String content = "Parece que lo inmovilizaron!!";
	
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
