package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.algoformers.*;


public class Jugador {

    private String nombre;
    private ArrayList<Algoformer> misRobots;
    private Tablero tablero;


    public Jugador(String nombre, int modo, Tablero tablero) {
        this.nombre = nombre;
        this.tablero = tablero;
        this.misRobots = new ArrayList<Algoformer>();
        this.agregarRobotsAlTablero(modo);

    }


    private void agregarRobotsAlTablero(int modo) {
        Posicion posicion1;
        Posicion posicion2;
        Posicion posicion3;

        switch (modo) {
            case Algoformer.MODO_AUTOBOT:
                // Esquina superior izquierda
                posicion1 = new Posicion(0, 0);
                posicion2 = new Posicion(0, 1);
                posicion3 = new Posicion(0, 2);

                Optimus optimus = new Optimus();
                BumbleBee bumbleBee = new BumbleBee();
                Ratchet ratchet = new Ratchet();

                this.tablero.agregarAlgoformerHumanoide(optimus, posicion1);
                this.tablero.agregarAlgoformerHumanoide(bumbleBee, posicion2);
                this.tablero.agregarAlgoformerHumanoide(ratchet, posicion3);

                this.misRobots.add(optimus);
                this.misRobots.add(bumbleBee);
                this.misRobots.add(ratchet);

                break;
            case Algoformer.MODO_DECEPTICON:
                // Esquina inferior derecha
                posicion1 = new Posicion(this.tablero.getDimensionX() - 3, this.tablero.getDimensionY() - 3);
                posicion2 = new Posicion(this.tablero.getDimensionX() - 3, this.tablero.getDimensionY() - 2);
                posicion3 = new Posicion(this.tablero.getDimensionX() - 3, this.tablero.getDimensionY() - 1);

                Megatron megatron = new Megatron();
                Bonecrusher bonecrusher = new Bonecrusher();
                Frenzy frenzy = new Frenzy();

                this.tablero.agregarAlgoformerHumanoide(megatron, posicion1);
                this.tablero.agregarAlgoformerHumanoide(bonecrusher, posicion2);
                this.tablero.agregarAlgoformerHumanoide(frenzy, posicion3);

                this.misRobots.add(megatron);
                this.misRobots.add(bonecrusher);
                this.misRobots.add(frenzy);

                break;
        }

    }
}
