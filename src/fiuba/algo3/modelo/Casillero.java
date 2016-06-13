package fiuba.algo3.modelo;

import fiuba.algo3.modelo.superficies.*;
import org.json.simple.JSONArray;
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


	/*
	public void agregarAlgoformerHumanoideSinEfectoDeSuperficie(Algoformer algoformer) {
		if (this.estaVacio() == false)
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		this.algoformer=algoformer;
	}

	public void agregarAlgoformerHumanoide(Algoformer algoformer) {
		if (this.tierra.superficie()=="pantano") //PONER CTE
			throw new MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion(); // ESTO VA EN Pantano
		if (this.tierra.superficie()=="espinas")
			algoformer.reducirVida((algoformer.getVida())*(ataqueEspinas/100)); // ESTO VA EN Espinas
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();

		this.algoformer = algoformer;
	}
	
	public void agregarAlgoformerAlternoTerrestre(Algoformer algoformer) {
		if (this.tierra.superficie()=="espinas")
			algoformer.reducirVida((algoformer.getVida())*(ataqueEspinas/100)); // Esto va en Espinas
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		this.algoformer = algoformer;
	}

	
	public void agregarAlgoformerAlternoAereo(Algoformer algoformer) {
		
		//if (this.aire.superficie()=="nebulosaDeAndromeda")
			//algoformer.atrapadoPorTurnos(3);
		//if (this.aire.superficie()=="tormentaPsionica")
			//algoformer.cambiarAtaqueDelModoAlterno(-40%);
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		
		this.algoformer=algoformer;		
	}
	
	public void quitarAlgoformer(Algoformer algoformer){
		this.algoformer=null;
		this.contenido = Vacio.getInstancia();
	}


	public Algoformer getAlgoformerContenido(){
		return this.algoformer;
	}

	public Algoformer getAlgoformer() {
		return this.algoformer;
	}

	public boolean hayAlgoformer(){
		return this.algoformer != null;
	}

	*/


}
