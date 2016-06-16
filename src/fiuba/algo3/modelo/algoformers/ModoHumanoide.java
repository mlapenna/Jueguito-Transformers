package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Tablero;

public class ModoHumanoide extends Modo {

    public ModoHumanoide(Algoformer algoformer, Tablero tablero) {
        super(algoformer, tablero);
        this.movimiento = algoformer.getMovimientoHumanoide();
    }

    public int getAtaqueInicial() {
        return this.algoformer.getAtaqueInicialHumanoide();
    }

    public int getDistanciaAtaque() {
        return this.algoformer.getDistanciaAtaqueHumanoide();
    }

    public int getVelocidad() {
        return this.algoformer.getVelocidadHumanoide();
    }

    public boolean esHumanoide() {
        return true;
    }
}
