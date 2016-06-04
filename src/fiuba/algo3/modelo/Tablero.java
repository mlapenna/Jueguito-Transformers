package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

//import javafx.geometry.Pos;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Tablero {

	ArrayList<ArrayList<Casillero>> Casilleros = new ArrayList<ArrayList<Casillero>>();
	
	private int dimensionX;
	private int dimensionY;

	private static final String DIMENSION_X_JSON_FIELD_KEY = "dimensionX";
	private static final String DIMENSION_Y_JSON_FIELD_KEY = "dimensionY";


	public Tablero(JSONObject json){
		this.dimensionX = Integer.parseInt( json.get(DIMENSION_X_JSON_FIELD_KEY).toString() );
		this.dimensionY = Integer.parseInt( json.get(DIMENSION_Y_JSON_FIELD_KEY).toString() );
		crearTablero(this.dimensionX,this.dimensionY);
	}

	private void crearTablero(int columnas,int filas){
  	    for(int i=0; i<filas ;i++) 
		{
			ArrayList<Casillero> fila = new ArrayList<Casillero>();
			for(int j=0; j<columnas ; j++){	
				Casillero nuevoCasillero = new Casillero();
				fila.add(nuevoCasillero);
			}
			this.Casilleros.add(fila);			
		}
	}

	public void moverAlgoformerHumanoide(Algoformer algoformer, Posicion posicionFinal){
		this.atCasillero(algoformer.obtenerPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.atCasillero(posicionFinal).agregarAlgoformerHumanoide(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.cargarNuevaPosicion(posicionFinal);
	}
	
	public void moverAlgoformerHumanoidesinEfectoDeLaSuperficie(Algoformer algoformer, Posicion posicionFinal){
		this.atCasillero(algoformer.obtenerPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.atCasillero(posicionFinal).agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.cargarNuevaPosicion(posicionFinal);
	}
	
	private Casillero atCasillero(Posicion posicion){
		
		int posX = posicion.obtenerPosicionX();
		int posY = posicion.obtenerPosicionY();
		ArrayList<Casillero> filaDelCasillero = new ArrayList<Casillero>();
		filaDelCasillero = Casilleros.get(posY-1);
		return filaDelCasillero.get(posX-1);
		
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


	public void agregarAlgoformerHumanoide(Algoformer algoformer, Posicion posicion) {
		this.atCasillero(posicion).agregarAlgoformerHumanoide(algoformer);
	}
	
	public void agregarAlgoformerHumanoideSinEfectoDeSuperficie(Algoformer algoformer, Posicion posicion) {
		Casillero casillero = this.atCasillero(posicion);
		casillero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer);
		algoformer.cargarNuevaPosicion(posicion);
	}

	public int getDimensionX() {
		return this.dimensionX;
	}

	public int getDimensionY() {
		return this.dimensionY;
	}
}
