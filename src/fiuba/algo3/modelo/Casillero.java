package fiuba.algo3.modelo;

import fiuba.algo3.modelo.superficies.*;
import org.json.simple.JSONObject;


public class Casillero {
	private static final String JSON_FIELD_KEY_TIERRA = "tierra";
	private static final String JSON_FIELD_KEY_AIRE = "aire";

	private Contenido contenido;
	private Tierra tierra;
	private Aire aire;

	public Casillero() {
		this.contenido = Vacio.getInstancia();
	}


	public void setSuperficies(JSONObject superficies) {

		String superficieTierra = superficies.get(JSON_FIELD_KEY_TIERRA).toString();
		String superficieAire = superficies.get(JSON_FIELD_KEY_AIRE).toString();

		switch (superficieTierra) {
			case Rocas.NOMBRE_JSON:
				this.tierra = new Rocas();
				break;
			case Pantano.NOMBRE_JSON:
				this.tierra = new Pantano();
				break;
			case Espinas.NOMBRE_JSON:
				this.tierra = new Espinas();
				break;
		}

		switch (superficieAire) {
			case Nube.NOMBRE_JSON:
				this.aire = new Nube();
				break;
			case NebulosaDeAndromeda.NOMBRE_JSON:
				this.aire = new NebulosaDeAndromeda();
				break;
			case TormentaPsionica.NOMBRE_JSON:
				this.aire = new TormentaPsionica();
				break;
		}
	}


	public Contenido getContenido() {
		return this.contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	public Tierra getSuperficieTierra() {
		return this.tierra;
	}

	public Aire getSuperficieAire() {
		return this.aire;
	}
	
	public boolean estaVacio(){  //LO CAMBIE PORQ TIRABA NULL POINTER
		// return !this.contenido.hayAlgo();
		return (this.contenido==Vacio.getInstancia());
	}
	
	public void quitarContenido(){
		this.contenido = Vacio.getInstancia();
	}


}
