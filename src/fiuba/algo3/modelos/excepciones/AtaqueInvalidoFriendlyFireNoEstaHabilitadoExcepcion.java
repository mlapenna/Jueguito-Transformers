package fiuba.algo3.modelos.excepciones;

public class AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion extends RuntimeExceptionConMensajes {
    
	public AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion() {
        super();
		this.title ="Ataque Inv\u00e1lido";
		this.header = "No puedes atacar a los miembros de tu equipo.";
		this.content = ":)";
    }

}
