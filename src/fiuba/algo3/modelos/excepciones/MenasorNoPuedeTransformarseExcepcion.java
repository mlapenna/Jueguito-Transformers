package fiuba.algo3.modelos.excepciones;

public class MenasorNoPuedeTransformarseExcepcion extends RuntimeExceptionConMensajes {
    
	public MenasorNoPuedeTransformarseExcepcion() {
		super();
		this.title = "";
		this.header = "Menasor no puede transformarse.";
		this.content = "";
	}
    
}
