package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Superion extends Decepticon {
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soySuperion();
    };

    public boolean soySuperion() { return true; }
}
