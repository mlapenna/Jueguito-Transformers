package fiuba.algo3.modelo.algoformers;

public class ModoAlterno extends Modo {

    public ModoAlterno(Algoformer algoformer) {
        super(algoformer);
    }

    public int getAtaque() {
        return this.algoformer.getAtaqueAlterno();
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
