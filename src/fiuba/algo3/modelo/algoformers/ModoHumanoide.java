package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.algoformers.Modo;

public class ModoHumanoide extends Modo {

    public ModoHumanoide(Algoformer algoformer) {
        super(algoformer);
    }

    public int getAtaque() {
        return this.algoformer.getAtaqueHumanoide();
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
