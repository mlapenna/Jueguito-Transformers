package fiuba.algo3.modelos.excepciones;

public class NoEsElTurnoDelJugadorExcepcion extends RuntimeExceptionConMensajes {
    public NoEsElTurnoDelJugadorExcepcion() {
		super();

		this.title = "No es su turno";
		this.header = "El turno es de los robots del otro jugador.";
		this.content = "";
	}

}


