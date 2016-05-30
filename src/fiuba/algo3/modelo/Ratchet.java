package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Ratchet extends Decepticon {
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyRatchet();
    };

    public boolean soyRatchet() { return true; }
}
