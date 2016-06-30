package fiuba.algo3.modelos.excepciones;

public class ErrorDesconocidoEnLaVistaExcepcion extends RuntimeExceptionConMensajes {

    public ErrorDesconocidoEnLaVistaExcepcion() {
        super();
		this.title = "Error desconocido";
		this.header = "Ha ocurrido un error que no es reconocido.";
		this.content = "";
    }
	
}
