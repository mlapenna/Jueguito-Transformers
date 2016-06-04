package fiuba.algo3.modelo;

import fiuba.algo3.modelo.MovimientoInvalidoCasilleroOcupado;

public class Casillero {
	public static final int ataqueEspinas = 5;
	private Algoformer algoformer = null; //VER QUE ESTA FEO EL NULL ACA
	private boolean vacio = true;
	private Tierra tierra;
	private Aire aire;
	private Bonus bonus;

	public void agregarAlgoformerHumanoideSinEfectoDeSuperficie(Algoformer algoformer) {
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupado();
		this.algoformer=algoformer;
		this.vacio=false;
	}
	
	public void agregarAlgoformerHumanoide(Algoformer algoformer) {
		
		if (this.tierra.superficie()=="pantano") //PONER CTE
			throw new MovimientoInvalidoIncapazDeAtravezarSuperficie();
		if (this.tierra.superficie()=="espinas")
			algoformer.reducirVida((algoformer.getVida())*(ataqueEspinas/100));
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupado();
		//VER Q ONDA EL BONUS, NO SE SI HAY Q HACERLO
		this.algoformer=algoformer;
		this.vacio=false;
	}
	
	public void agregarAlgoformerAlternoTerrestre(Algoformer algoformer) {
		
		if (this.tierra.superficie()=="espinas")
			algoformer.reducirVida((algoformer.getVida())*(ataqueEspinas/100));
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupado();
		
		this.algoformer=algoformer;
		this.vacio=false;
	}
	
	public void agregarAlgoformerAlternoAereo(Algoformer algoformer) {
		
		//if (this.aire.superficie()=="nebulosaDeAndromeda")
			//algoformer.atrapadoPorTurnos(3);
		//if (this.aire.superficie()=="tormentaPsiconica")
			//algoformer.cambiarAtaqueDelModoAlterno(-40%);
		if (this.estaVacio()==false)
			throw new MovimientoInvalidoCasilleroOcupado();
		
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
	
	public void agregarSuperficieTerrestre(Tierra tierra){
		this.tierra=tierra;
	}
	
	public void agregarSuperficieAerea(Aire aire){
		this.aire=aire;
	}
	
	public void agregarBonus(Bonus bonus){
		this.bonus=bonus;
	}
	
	public Algoformer obtenerAlgoformerContenido(){
		return this.algoformer;
	}
	
	public void obtenerContenido(){
		
	}



}
