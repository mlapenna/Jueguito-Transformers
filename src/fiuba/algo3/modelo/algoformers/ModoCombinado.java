package fiuba.algo3.modelo.algoformers;


import fiuba.algo3.modelo.Tablero;

public class ModoCombinado extends Modo {

    public ModoCombinado(Algoformer algoformer, Tablero tablero) {
        super(algoformer, tablero);
    }

    public int getAtaqueInicial() {
        return this.algoformer.getAtaqueInicial();
    }

    public int getDistanciaAtaque() {
        return this.algoformer.getDistanciaAtaque();
    }

    public int getVelocidad() {
        return this.algoformer.getVelocidad();
    }

}
