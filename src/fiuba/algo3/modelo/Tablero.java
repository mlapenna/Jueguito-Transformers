package fiuba.algo3.modelo;
import java.util.Random;

public class Tablero {
	
	private Casillero[][] casilleros;
	
	public void moverAlgoformerHumanoide(Algoformer algoformer, Posicion posicionFinal){
		this.atCasillero(algoformer.obtenerPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.atCasillero(posicionFinal).agregarAlgoformerHumanoide(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.cargarNuevaPosicion(posicionFinal);
	}
	
	
	private Casillero atCasillero(Posicion posicion){
		return casilleros[posicion.obtenerPosicionX()][posicion.obtenerPosicionY()];
	}
}
