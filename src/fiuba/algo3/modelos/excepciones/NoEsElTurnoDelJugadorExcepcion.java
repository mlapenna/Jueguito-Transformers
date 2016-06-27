package fiuba.algo3.modelos.excepciones;

public class NoEsElTurnoDelJugadorExcepcion extends RuntimeException {
    public NoEsElTurnoDelJugadorExcepcion() {
        super();
    }
	private String title = "No Es El Turno Del Jugador";
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


