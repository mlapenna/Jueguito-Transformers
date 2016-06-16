package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Tablero;

public class ModoAlterno extends Modo {

    public ModoAlterno(Algoformer algoformer, Tablero tablero) {
        super(algoformer, tablero);
        this.movimiento = algoformer.getMovimientoAlterno();
    }

    public int getAtaqueInicial() {
        return this.algoformer.getAtaqueInicialAlterno();
    }

    public int getDistanciaAtaque() {
        return this.algoformer.getDistanciaAtaqueAlterno();
    }

    public int getVelocidad() {
        return this.algoformer.getVelocidadAlterno();
    }

    public boolean esAlterno() {
        return true;
    }
}
