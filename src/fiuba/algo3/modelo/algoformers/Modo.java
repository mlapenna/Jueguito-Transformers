package fiuba.algo3.modelo.algoformers;


public abstract class Modo {
    protected Algoformer algoformer;

    public Modo(Algoformer algoformer) {
        this.algoformer = algoformer;
    }

    public boolean esHumanoide() {
        return false;
    }

    public boolean esAlterno() {
        return false;
    }

    public abstract int getAtaque();
    public abstract int getDistanciaAtaque();
    public abstract int getVelocidad();
}
