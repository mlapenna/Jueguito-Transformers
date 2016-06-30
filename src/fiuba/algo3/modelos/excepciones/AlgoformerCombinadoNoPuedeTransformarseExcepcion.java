package fiuba.algo3.modelos.excepciones;


public class AlgoformerCombinadoNoPuedeTransformarseExcepcion extends RuntimeExceptionConMensajes {


    public AlgoformerCombinadoNoPuedeTransformarseExcepcion() {
        super();
        this.title = "Transformaci\u00f3n Inv\u00e1lida";
        this.header = "El algoformer se encuentra combinado.";
        this.content = "S\u00f3lo los algoformers no combinados pueden transformarse.";
    }

}
