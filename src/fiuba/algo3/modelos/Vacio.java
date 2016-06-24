package fiuba.algo3.modelos;


public class Vacio extends Contenido {

	private static Vacio vacio = new Vacio();
	
	public Vacio() {
		this.hayAlgo=false;
	}

	public static Vacio getInstancia() {
		return vacio;
	}

}
