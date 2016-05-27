package fiuba.algo3.modelo;

public class Casillero {
	
	private Algoformer algoformer = null;
	private boolean vacio=true;
	private Tierra tierra;
	private Aire aire;
	private Bonus bonus;

	public void agregarAlgoformer(Algoformer algoformer) {
		this.algoformer=algoformer;
		this.vacio=false;
	}
}
