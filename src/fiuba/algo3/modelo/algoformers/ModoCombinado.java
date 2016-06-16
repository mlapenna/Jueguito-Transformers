package fiuba.algo3.modelo.algoformers;


public class ModoCombinado extends Modo {

    public ModoCombinado(Algoformer algoformer) {
        super(algoformer);
    }

    public int getAtaque() {
        return this.algoformer.getAtaque();
    }

    public int getDistanciaAtaque() {
        return this.algoformer.getDistanciaAtaque();
    }

    public int getVelocidad() {
        return this.algoformer.getVelocidad();
    }

}
