package fiuba.algo3.modelos.excepciones;

public class AlgoformerInmovilizadoExcepcion extends RuntimeExceptionConMensajes {

    public AlgoformerInmovilizadoExcepcion() {
        super();
        this.title = "Movimiento Invalido";
        this.header = "El algoformer se encuentra inmovilizado a causa de un movimiento previo.";
        this.content = "Los turnos que queda atrapado son 3 en total.";
    }

}
