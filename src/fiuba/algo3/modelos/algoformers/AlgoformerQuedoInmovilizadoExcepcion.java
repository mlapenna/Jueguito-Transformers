package fiuba.algo3.modelos.algoformers;

import fiuba.algo3.modelos.excepciones.RuntimeExceptionConMensajes;

public class AlgoformerQuedoInmovilizadoExcepcion extends RuntimeExceptionConMensajes {

    public AlgoformerQuedoInmovilizadoExcepcion() {
        super();
        this.title = "No se puede seguir moviendo";
        this.header = "El algoformer fue inmovilizado.";
        this.content = "Los turnos que queda atrapado son 3 en total.";
    }
}