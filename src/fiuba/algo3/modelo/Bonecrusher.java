package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Bonecrusher extends Decepticon {
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyBonecrusher();
    };

    public boolean soyBonecrusher() { return true; }
}
