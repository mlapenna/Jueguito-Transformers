package fiuba.algo3.modelos;

import fiuba.algo3.modelos.algoformers.Algoformer;
import org.json.simple.JSONObject;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;

    public Juego(JSONObject jsonTablero) {

        Tablero tablero = new Tablero(jsonTablero);
        Turno turno = new Turno();
        this.jugador1 = new Jugador("Pedro", Algoformer.MODO_AUTOBOT, tablero, turno);
        this.jugador2 = new Jugador("Juan", Algoformer.MODO_DECEPTICON, tablero, turno);
        turno.setJugadores(jugador1, jugador2);

    }


    public Jugador getJugador1() {
        return this.jugador1;
    }

    public Jugador getJugador2() {
        return this.jugador2;
    }

}
