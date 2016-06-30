package fiuba.algo3.modelos.excepciones;

public class CantidadDeAlgoformersInsuficienteException extends RuntimeExceptionConMensajes {

	public CantidadDeAlgoformersInsuficienteException() {
		super();
		this.title ="Combinación Inv\u00e1lida";
		this.header = "Parece que algo sucedió con tus algoformers!!!";
		this.content = ":)";
	}

}
