package fiuba.algo3.modelos.excepciones;


public class AlgoformerCombinadoNoPuedeTransformarseExcepcion extends RuntimeException {


    public AlgoformerCombinadoNoPuedeTransformarseExcepcion() {
        super();
    }

    private String title = "Transformaci\u00f3n Inv\u00e1lida";
    private String header = "El algoformer se encuentra combinado.";
    private String content = "S\u00f3lo los algoformers no combinados pueden transformarse.";

    public String getExcepcionTitulo() {
        return this.title;
    }

    public String getExcepcionHeader() {
        return this.header;
    }

    public String getExcepcionContent() {
        return this.content;
    }

}
