package fiuba.algo3.modelos.excepciones;

public class AlgoformerInmovilizadoExcepcion extends RuntimeException {

	
    public AlgoformerInmovilizadoExcepcion() {
        super();
    }
	
	private String title = "Movimiento Inv\u00e1lido";
	private String header = "El algoformer se encuentra inmovilizado a causa de un movimiento previo.";
	private String content = "Los turnos que queda atrapado son 3 en total.";
	
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
