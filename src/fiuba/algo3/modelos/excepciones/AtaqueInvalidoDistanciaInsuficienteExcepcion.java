package fiuba.algo3.modelos.excepciones;

public class AtaqueInvalidoDistanciaInsuficienteExcepcion extends RuntimeExceptionConMensajes {
	
    public AtaqueInvalidoDistanciaInsuficienteExcepcion() {
        super();
        this.title ="Ataque Inv\u00e1lido";
        this.header = "La distancia entre ambos robots es excesiva.";
        this.content = "Acerca tu algoformer y ataca al enemigo.";
    }
 
}
