package fiuba.algo3.modelos.excepciones;

public class AlgoformersNoAlineadosException extends RuntimeExceptionConMensajes {

    public AlgoformersNoAlineadosException() {
        super();
        this.title = "Movimiento inválido.";
        this.header = "Casilleros seleccionados incorrectos.";
        this.content = "El algoformer no puede moverse en esa dirección.";
    }

}
