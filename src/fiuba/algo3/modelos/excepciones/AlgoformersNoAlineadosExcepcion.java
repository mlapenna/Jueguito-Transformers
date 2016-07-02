package fiuba.algo3.modelos.excepciones;

public class AlgoformersNoAlineadosExcepcion extends RuntimeExceptionConMensajes {

    public AlgoformersNoAlineadosExcepcion() {
        super();
        this.title = "Movimiento inválido.";
        this.header = "Casilleros seleccionados incorrectos.";
        this.content = "El algoformer no puede moverse en esa dirección.";
    }

}
