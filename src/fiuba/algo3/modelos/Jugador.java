package fiuba.algo3.modelos;

import java.util.ArrayList;

import fiuba.algo3.modelos.algoformers.*;


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

                Optimus optimus = new Optimus(posicion1, tablero);
                BumbleBee bumbleBee = new BumbleBee(posicion2,tablero);
                Ratchet ratchet = new Ratchet(posicion3,tablero);

                this.misRobots.add(optimus);
                this.misRobots.add(bumbleBee);
                this.misRobots.add(ratchet);

                break;
            case Algoformer.MODO_DECEPTICON:
                // Esquina inferior derecha
                posicion1 = new Posicion(this.tablero.getDimensionX() - 3, this.tablero.getDimensionY() - 3);
                posicion2 = new Posicion(this.tablero.getDimensionX() - 3, this.tablero.getDimensionY() - 2);
                posicion3 = new Posicion(this.tablero.getDimensionX() - 3, this.tablero.getDimensionY() - 1);

                Megatron megatron = new Megatron(posicion1,tablero);
                Bonecrusher bonecrusher = new Bonecrusher(posicion2,tablero);
                Frenzy frenzy = new Frenzy(posicion3,tablero);

                this.misRobots.add(megatron);
                this.misRobots.add(bonecrusher);
                this.misRobots.add(frenzy);

                break;
        }

    }
}
