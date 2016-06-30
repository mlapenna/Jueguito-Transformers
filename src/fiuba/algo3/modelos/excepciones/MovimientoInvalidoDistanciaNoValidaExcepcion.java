package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoDistanciaNoValidaExcepcion extends RuntimeExceptionConMensajes {

    public MovimientoInvalidoDistanciaNoValidaExcepcion() {
        super();
        this.title = "Movimiento Inv\u00e1lido";
        this.header = "La distancia solicitada supera la velocidad del Algoformer.";
        this.content = "";
    }

}
