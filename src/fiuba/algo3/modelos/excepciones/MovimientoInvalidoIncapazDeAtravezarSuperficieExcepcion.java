package fiuba.algo3.modelos.excepciones;

public class MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion extends RuntimeExceptionConMensajes {
    public MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion() {
        super();
		this.title ="Movimiento Inv\u00e1lido";
		this.header = "El Algoformer en el modo actual no es capaz de atravesar todas las superficies del recorrido.";
		this.content = "";
    }

}
