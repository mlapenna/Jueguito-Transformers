package fiuba.algo3.modelos.excepciones;

public class SuperionNoPuedeTransformarseExcepcion extends RuntimeExceptionConMensajes {

    public SuperionNoPuedeTransformarseExcepcion() {
        super();
		this.title = "Superion No Puede Transformarse";
		this.header = "";
		this.content = "";
    }
	
}
