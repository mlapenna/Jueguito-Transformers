package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Jugador;

public class Juego {
    private final int CANTIDAD_DE_ROBOTS_INICIAL = 3;

    private Jugador jugador1;
    private Jugador jugador2;


    public Juego(Jugador jugador1, Jugador jugador2, String mapaJson) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

    }

}
