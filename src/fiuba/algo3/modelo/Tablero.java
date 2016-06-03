package fiuba.algo3.modelo;

public class Tablero {
	
	private casillero[][] casilleros;
	
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

	public void moverAlgoformerAlternoTerrestre(Algoformer algoformer, Posicion posicionFinal) {
		this.atCasillero(algoformer.obtenerPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.atCasillero(posicionFinal).agregarAlgoformerAlternoTerrestre(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.cargarNuevaPosicion(posicionFinal);
	}

	public void moverAlgoformerAlternoAereo(Algoformer algoformer, Posicion posicionFinal) {
		this.atCasillero(algoformer.obtenerPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.atCasillero(posicionFinal).agregarAlgoformerAlternoAereo(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.cargarNuevaPosicion(posicionFinal);	
	}
}
