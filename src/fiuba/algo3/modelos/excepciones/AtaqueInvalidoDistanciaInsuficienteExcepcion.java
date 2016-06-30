package fiuba.algo3.modelos.excepciones;

public class AtaqueInvalidoDistanciaInsuficienteExcepcion extends RuntimeException {
	
	private String title ="Ataque Inv\u00e1lido";
	private String header = "La distancia entre ambos robots es excesiva.";
	private String content = "Acerca tu algoformer y ataca al enemigo.";
	
    public AtaqueInvalidoDistanciaInsuficienteExcepcion() {
        super();
    }
    
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
