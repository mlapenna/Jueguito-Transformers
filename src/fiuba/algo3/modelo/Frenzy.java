package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Frenzy extends Decepticon {
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyFrenzy();
    };

    public boolean soyFrenzy() { return true; }
}
