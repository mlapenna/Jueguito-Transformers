package fiuba.algo3.modelo;


public class Vacio extends Contenido {

	private static Vacio vacio = Vacio.getInstancia();
	
	public Vacio() {
		this.hayAlgo=false;
	}

	public static Vacio getInstancia() {
		return vacio;
	}

}
