package fiuba.algo3.modelos;

import fiuba.algo3.modelos.algoformers.Algoformer;
import org.json.simple.JSONObject;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;
    private String ganador;
    private Tablero tablero;

    public Juego(JSONObject jsonTablero) {

        this.tablero = new Tablero(jsonTablero);
        tablero.setContenido(this.tablero.posicionCentro(), new ChispaSuprema());
        Turno turno = new Turno();
        this.jugador1 = new Jugador("Pedro", Algoformer.MODO_AUTOBOT, turno, this);
        this.jugador2 = new Jugador("Juan", Algoformer.MODO_DECEPTICON, turno, this);
        turno.setJugadores(jugador1, jugador2);
    }


    public Jugador getJugador1() {
        return this.jugador1;
    }

    public Jugador getJugador2() {
        return this.jugador2;
    }

	public void gano(Jugador ganador) {
		System.out.println("GANO JUGADOR:\n");
		System.out.println(ganador.nombre());
		this.ganador = ganador.nombre();
		this.jugador1.eliminar();
		this.jugador2.eliminar();
		this.jugador1 = null;
		this.jugador2 = null;
	}


    public Tablero getTablero() {
        return this.tablero;
    }

	public String ganador() {
		return this.ganador;
	}

}
