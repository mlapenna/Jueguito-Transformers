package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import fiuba.algo3.modelo.Algoformer.*;
import fiuba.algo3.modelo.Tablero;

public class Jugador {

    private String nombre;
    private ArrayList<Algoformer> misRobots;
    private Tablero tablero;


    public Jugador(String nombre, int modo, Tablero tablero) {
        this.nombre = nombre;
        this.tablero = tablero;

        this.generarRobotsAlAzar(modo);

        this.agregarRobotsAlTablero();
    }


    // Agrega a la clase 3 robots diferentes al azar y del tipo correcto
    private void generarRobotsAlAzar(int modo) {
        Random rnd = new Random();

        while (this.misRobots.size() < Juego.CANTIDAD_DE_ROBOTS_INICIAL) {

            // Genero un entero entre 0 y la cantidad de robots existentes por tipo
            int numeAzar = (int) (rnd.nextDouble() * TOTAL_ROBOTS_DISPONIBLES_POR_TIPO);

            switch (modo) {
                case Algoformer.MODO_AUTOBOT:
                    switch (numeAzar) {
                        case 0:
                            Optimus robotNuevo = new Optimus();
                            break;
                        case 1:
                            BumbleBee robotNuevo = new BumbleBee();
                            break;
                        case 2:
                            Ratchet robotNuevo = new Ratchet();
                            break;
                        case 3:
                            Superion robotNuevo = new Superion();
                            break;
                    }
                    break;
                case Algoformer.MODO_DECEPTICON:
                    switch (numeAzar) {
                        case 0:
                            Megatron robotNuevo = new Megatron();
                            break;
                        case 1:
                            Bonecrusher robotNuevo = new Bonecrusher();
                            break;
                        case 2:
                            Frenzy robotNuevo = new Frenzy();
                            break;
                        case 3:
                            Menasor robotNuevo = new Menasor();
                            break;
                    }
            }

            // Ver si el tipo de robot ya existe
            int i = 0;
            boolean elTipoDeRobotYaExiste = false;
            while (i < this.misRobots.size() && !elTipoDeRobotYaExiste) {
                if (this.misRobots[i].esDelMismoTipoQue(robotNuevo)) {
                    elTipoDeRobotYaExiste = true;
                }
                i++;
            }

            if (!elTipoDeRobotYaExiste) {
                this.misRobots.add(unRobot);
            }

        }

    }


    private void agregarRobotsAlTablero() {
        switch (modo) {
            case Algoformer.MODO_AUTOBOT:
                int fila = 0;
                int columna = 0;

                Iterator<Algoformer> algoformersIterator = this.misRobots.iterator();

                while (algoformersIterator.hasNext()) {
                    this.tablero.agregarRobot(algoformersIterator.next(), fila, columna, Superficie.MODO_TIERRA);
                    
                    fila++;
                }
                break;
            case Algoformer.MODO_DECEPTICON:
                int fila = this.tablero.obtenerCantidadFilas() - 1;
                int columna = this.tablero.obtenerCantidadColumnas() - 1;

                Iterator<Algoformer> algoformersIterator = this.misRobots.iterator();
                while (algoformersIterator.hasNext()) {
                    this.tablero.agregarRobot(algoformersIterator.next(), fila, columna, Superficie.MODO_TIERRA);
                    fila--;
                }
                break;
        }
    }
}
