package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class BumbleBee extends Decepticon {
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyBumbleBee();
    };

    public boolean soyBumbleBee() { return true; }
}
