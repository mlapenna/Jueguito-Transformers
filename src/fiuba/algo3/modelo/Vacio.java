package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Contenido;

public class Vacio extends Contenido {

	private static Vacio vacio = new Vacio();

	/* Un constructor privado previene que otras clases lo instancien */
	private Vacio() { }

	public static Vacio getInstancia( ) {
		return vacio;
	}

}
