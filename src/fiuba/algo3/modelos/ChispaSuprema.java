package fiuba.algo3.modelos;

public class ChispaSuprema extends Contenido {
	
	Posicion posicion;
	
	public ChispaSuprema(Posicion posicion){
		this.hayAlgo = true;
		this.posicion = posicion;
	}

	public boolean esChispa(){
		return true;
	}
	
	public Posicion getPosicion(){
		return this.posicion;
	}
}
