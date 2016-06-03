package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Tablero {

	private ArrayList<Casillero> casilleros;

	private int dimensionX;
	private int dimensionY;

	private static final String DIMENSION_X_JSON_FIELD_KEY = "dimensionX";
	private static final String DIMENSION_Y_JSON_FIELD_KEY = "dimensionY";


	public Tablero(JSONObject json){
		this.dimensionX = (int) json.get(DIMENSION_X_JSON_FIELD_KEY).toString();
		this.dimensionY = (int) json.get(DIMENSION_Y_JSON_FIELD_KEY).toString();
	}


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
