package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;

public class Megatron extends Decepticon {
    public boolean esDelMismoTipoQue(Algoformer unRobot) {
        return unRobot.soyMegatron();
    };

    public boolean soyMegatron() { return true; }
}
