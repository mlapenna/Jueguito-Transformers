package fiuba.algo3.modelos.excepciones;

public class AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion extends RuntimeException {
    public AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion() {
        super();
    }
    private String title ="Ataque Inv\u00e1lido";
	private String header = "No puedes atacar a los miembros de tu equipo.";
	private String content = ":)";
	
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
