package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.MovimientoInvalidoCasilleroOcupadoExcepcion;
import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.superficies.Tierra;
import fiuba.algo3.modelo.superficies.Aire;


public class Casillero {
	public static final int ataqueEspinas = 5;
	private Algoformer algoformer = null; //VER QUE ESTA FEO EL NULL ACA
	private Contenido contenido;
	private Tierra tierra;
	private Aire aire;


	public Casillero() {
		this.contenido = new Vacio();
	}


	public void setSuperficies(Tierra tierra, Aire aire) {
		this.tierra = tierra;
		this.aire = aire;
	)


	public void agregarAlgoformerHumanoideSinEfectoDeSuperficie(Algoformer algoformer) {
		if (this.estaVacio() == false)
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		this.algoformer=algoformer;
		this.vacio=false;
	}

	public void agregarAlgoformerHumanoide(Algoformer algoformer) {
		/*
		if (this.tierra.superficie()=="pantano") //PONER CTE
			throw new MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion(); // ESTO VA EN Pantano
		if (this.tierra.superficie()=="espinas")
			algoformer.reducirVida((algoformer.getVida())*(ataqueEspinas/100)); // ESTO VA EN Espinas
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		*/
		this.algoformer = algoformer;
		this.vacio = false;
	}
	
	public void agregarAlgoformerAlternoTerrestre(Algoformer algoformer) {
		/*
		if (this.tierra.superficie()=="espinas")
			algoformer.reducirVida((algoformer.getVida())*(ataqueEspinas/100)); // Esto va en Espinas
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		*/
		this.algoformer = algoformer;
		this.vacio = false;
	}

	
	public void agregarAlgoformerAlternoAereo(Algoformer algoformer) {
		
		//if (this.aire.superficie()=="nebulosaDeAndromeda")
			//algoformer.atrapadoPorTurnos(3);
		//if (this.aire.superficie()=="tormentaPsionica")
			//algoformer.cambiarAtaqueDelModoAlterno(-40%);
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupadoExcepcion();
		
		this.algoformer=algoformer;
		this.vacio=false;		
	}
	
	public void quitarAlgoformer(Algoformer algoformer){
		this.algoformer=null;
		this.vacio=true;
	}
	
	public boolean estaVacio(){
		return this.vacio;
	}

	public boolean hayAlgoformer(){
		return this.algoformer != null;
	}
	
	public void agregarSuperficieTerrestre(Tierra tierra){
		this.tierra=tierra;
	}
	
	public void agregarSuperficieAerea(Aire aire){
		this.aire=aire;
	}

	public Algoformer getAlgoformerContenido(){
		return this.algoformer;
	}
	
	public Algoformer getAlgoformer() {
		return this.algoformer;
	}



}
