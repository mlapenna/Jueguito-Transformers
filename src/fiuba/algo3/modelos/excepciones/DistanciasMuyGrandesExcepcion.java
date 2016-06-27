package fiuba.algo3.modelos.excepciones;

public class DistanciasMuyGrandesExcepcion extends RuntimeException{
    public DistanciasMuyGrandesExcepcion() {
        super();
    }
	private String title = "Movimiento inválido.";
	private String header = "Casilleros muy alejados.";
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
