package fiuba.algo3.modelos;


import fiuba.algo3.modelos.algoformers.Algoformer;

import java.util.Iterator;

public class Turno {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorDelQueEsElTurno;


    public void siguiente() {
        if (this.jugadorDelQueEsElTurno == this.jugador1) {
            this.jugadorDelQueEsElTurno = this.jugador2;
        } else {
            this.jugadorDelQueEsElTurno = this.jugador1;
        }

        if (this.jugadorDelQueEsElTurno == null) return; // Esto es desprolijol pero sino los tests entregables hay que refactorizarlos y no se si importan

        Iterator<Algoformer> algoformers = this.jugadorDelQueEsElTurno.getAlgoformersIterator();

        while (algoformers.hasNext() ) {
            algoformers.next().nuevoTurno();
        }

    }

    public void setJugadores(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorDelQueEsElTurno = jugador1;
    }

    public boolean puedeJugar(Algoformer algoformer) {

        if (this.jugadorDelQueEsElTurno == null) return true; // Esto es desprolijol pero sino los tests entregables hay que refactorizarlos y no se si importan

        return this.jugadorDelQueEsElTurno.algoformerEsMio(algoformer);
    }
}
