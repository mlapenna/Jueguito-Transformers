package fiuba.algo3.modelos;

import fiuba.algo3.modelos.algoformers.*;

import java.util.ArrayList;
import java.util.Iterator;


public class Jugador {

    private String nombre;
    private ArrayList<Algoformer> misAlgoformers;
    private Tablero tablero;

    public Jugador(String nombre, int modo, Tablero tablero, Turno turno) {
        this.nombre = nombre;
        this.tablero = tablero;
        this.misAlgoformers = new ArrayList<Algoformer>();
        this.agregarAlgoformersAlTablero(modo, turno);
    }


    private void agregarAlgoformersAlTablero(int modo, Turno turno) {
        Posicion posicion1;
        Posicion posicion2;
        Posicion posicion3;

        switch (modo) {
            case Algoformer.MODO_AUTOBOT:
                // Esquina superior izquierda
                posicion1 = new Posicion(0, 0);
                posicion2 = new Posicion(0, 2);
                posicion3 = new Posicion(0, 4);

                Optimus optimus = new Optimus(posicion1, tablero, turno);
                BumbleBee bumbleBee = new BumbleBee(posicion2, tablero, turno);
                Ratchet ratchet = new Ratchet(posicion3, tablero, turno);

                this.misAlgoformers.add(optimus);
                this.misAlgoformers.add(bumbleBee);
                this.misAlgoformers.add(ratchet);

                break;
            case Algoformer.MODO_DECEPTICON:
                // Esquina inferior derecha
                posicion1 = new Posicion(this.tablero.getDimensionX() - 1, this.tablero.getDimensionY() - 5);
                posicion2 = new Posicion(this.tablero.getDimensionX() - 1, this.tablero.getDimensionY() - 3);
                posicion3 = new Posicion(this.tablero.getDimensionX() - 1, this.tablero.getDimensionY() - 1);

                Megatron megatron = new Megatron(posicion1, tablero, turno);
                Bonecrusher bonecrusher = new Bonecrusher(posicion2 ,tablero, turno);
                Frenzy frenzy = new Frenzy(posicion3, tablero, turno);

                this.misAlgoformers.add(megatron);
                this.misAlgoformers.add(bonecrusher);
                this.misAlgoformers.add(frenzy);

                break;
        }

    }


    public Iterator<Algoformer> getAlgoformers() {
        return this.misAlgoformers.iterator();
    }


    public boolean algoformerEsMio(Algoformer algoformer) {
        boolean esMio = false;

        Iterator<Algoformer> misAlgoformers = this.misAlgoformers.iterator();

        while (misAlgoformers.hasNext() && !esMio) {
            esMio = misAlgoformers.next() == algoformer;
        }

        return esMio;
    }
}
