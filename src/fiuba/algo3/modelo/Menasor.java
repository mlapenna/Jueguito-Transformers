package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Menasor extends Menasor {
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyMenasor();
    };

    public boolean soyMenasor() { return true; }
}
