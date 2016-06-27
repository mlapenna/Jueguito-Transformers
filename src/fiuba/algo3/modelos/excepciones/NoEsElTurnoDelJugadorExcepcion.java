package fiuba.algo3.modelos.excepciones;

public class NoEsElTurnoDelJugadorExcepcion extends RuntimeException {
    public NoEsElTurnoDelJugadorExcepcion() {
        super();
    }
	private String title = "No es su turno";
	private String header = "El turno es de los robots del otro jugador.";
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


