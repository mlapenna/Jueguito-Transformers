package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

//import javafx.geometry.Pos;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Tablero {

	ArrayList<ArrayList<Casillero>> casilleros = new ArrayList<ArrayList<Casillero>>();
	
	private int dimensionX;
	private int dimensionY;

	private static final String DIMENSION_X_JSON_FIELD_KEY = "dimensionX";
	private static final String DIMENSION_Y_JSON_FIELD_KEY = "dimensionY";


	public Tablero(JSONObject json){
		this.dimensionX = Integer.parseInt( json.get(DIMENSION_X_JSON_FIELD_KEY).toString() );
		this.dimensionY = Integer.parseInt( json.get(DIMENSION_Y_JSON_FIELD_KEY).toString() );

		// Se pone Vacio en todas las ubicaciones posibles
		for (int i = 0; i < this.dimensionY; i++) {
			ArrayList<Casillero> fila = new ArrayList<Casillero>();
			for(int j=0; j < this.dimensionX ; j++) {
				fila.add( new Casillero() );
			}
			this.casilleros.add(fila);
		}
	}


	public void moverAlgoformerHumanoide(Algoformer algoformer, Posicion posicionFinal){
		this.getCasillero(algoformer.getPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.getCasillero(posicionFinal).agregarAlgoformerHumanoide(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.setPosicion(posicionFinal);
	}

	
	public void moverAlgoformerHumanoidesinEfectoDeLaSuperficie(Algoformer algoformer, Posicion posicionFinal){
		if(algoformer.fueraDelAlcanceDelAlgoformer(posicionFinal))
			throw new MovimientoInvalidoDistanciaNoValida();
		
		this.getCasillero(algoformer.getPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.getCasillero(posicionFinal).agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.setPosicion(posicionFinal);
	}
	

	public Casillero getCasillero(Posicion posicion) {
		ArrayList<Casillero> fila = this.casilleros.get( posicion.obtenerPosicionY() );
		return fila.get( posicion.obtenerPosicionX() );
	}


	public void moverAlgoformerAlternoTerrestre(Algoformer algoformer, Posicion posicionFinal) {
		this.getCasillero(algoformer.getPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.getCasillero(posicionFinal).agregarAlgoformerAlternoTerrestre(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.setPosicion(posicionFinal);
	}


	public void moverAlgoformerAlternoAereo(Algoformer algoformer, Posicion posicionFinal) {
		this.getCasillero(algoformer.getPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.getCasillero(posicionFinal).agregarAlgoformerAlternoAereo(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.setPosicion(posicionFinal);	
	}


	public void agregarAlgoformerHumanoide(Algoformer algoformer, Posicion posicion) {
		this.getCasillero(posicion).agregarAlgoformerHumanoide(algoformer);
		algoformer.setPosicion(posicion);
	}

	
	public void agregarAlgoformerHumanoideSinEfectoDeSuperficie(Algoformer algoformer, Posicion posicion) {
		Casillero casillero = this.getCasillero(posicion);
		casillero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer);
		algoformer.setPosicion(posicion);
	}


	public int getDimensionX() {
		return this.dimensionX;
	}

	public int getDimensionY() {
		return this.dimensionY;
	}
}
