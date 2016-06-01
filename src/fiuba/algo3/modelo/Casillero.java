package fiuba.algo3.modelo;

public class Casillero {
	
	private Algoformer algoformer = null; //VER QUE ESTA FEO EL NULL ACA
	private boolean vacio=true;
	private Tierra tierra;
	private Aire aire;
	private Bonus bonus;

	public void agregarAlgoformer(Algoformer algoformer) {
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
	
	public void obtenerContenido(){
		
	}
	
}
