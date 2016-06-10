package fiuba.algo3.modelo;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class Tablero {

	ArrayList<ArrayList<Casillero>> casilleros = new ArrayList<ArrayList<Casillero>>();
	
	private int dimensionX;
	private int dimensionY;

	private static final String JSON_FIELD_KEY_DIMENSION_X = "dimensionX";
	private static final String JSON_FIELD_KEY_DIMENSION_Y = "dimensionY";
	private static final String JSON_FIELD_KEY_CASILLEROS = "casilleros";
	private static final String JSON_FIELD_KEY_POSICION_X = "posicionX";
	private static final String JSON_FIELD_KEY_POSICION_Y = "posicionY";
	private static final String JSON_FIELD_KEY_SUPERFICIES = "superficies";


	public Tablero(JSONObject json) {

		this.dimensionX = Integer.parseInt( json.get(JSON_FIELD_KEY_DIMENSION_X).toString() );
		this.dimensionY = Integer.parseInt( json.get(JSON_FIELD_KEY_DIMENSION_Y).toString() );


		// Se crea cada casillero
		for (int i = 0; i < this.dimensionY; i++) {
			ArrayList<Casillero> fila = new ArrayList<Casillero>();
			for (int j=0; j < this.dimensionX ; j++) {
				fila.add( new Casillero() );
			}
			this.casilleros.add(fila);
		}

		// Por cada casillero del mapa, se guardan sus superficies
		JSONArray casilleros = (JSONArray) json.get(JSON_FIELD_KEY_CASILLEROS);

		for (int i = 0; i < casilleros.size(); i++) {
			JSONObject unCasillero = (JSONObject) casilleros.get(i);

			int posicionX = Integer.parseInt( unCasillero.get(JSON_FIELD_KEY_POSICION_X).toString() );
			int posicionY = Integer.parseInt( unCasillero.get(JSON_FIELD_KEY_POSICION_Y).toString() );
			JSONArray superficies = (JSONArray) json.get(JSON_FIELD_KEY_SUPERFICIES);

			this.casilleros.get(posicionX).get(posicionY).setSuperficies(superficies);

		}
	}


/*

	public void moverAlgoformer(Algoformer algoformer,Posicion posicionDestino) {
		Movimiento movimiento = new Movimiento();
		
		movimiento.validarPosibleMovimiento(algoformer,posicionDestino);	
		
		movimiento.realizarMovimiento(algoformer,posicionDestino);
		
	}

	public void moverAlgoformerHumanoide(Algoformer algoformer, Posicion posicionFinal){
		this.getCasillero(algoformer.getPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.getCasillero(posicionFinal).agregarAlgoformerHumanoide(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.mover(posicionFinal);
	}

	
	public void moverAlgoformerHumanoidesinEfectoDeLaSuperficie(Algoformer algoformer, Posicion posicionFinal){
//		if(!algoformer.estaAlAlcance(posicionFinal))
//			throw new MovimientoInvalidoDistanciaNoValidaExcepcion();
		
		this.getCasillero(algoformer.getPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.getCasillero(posicionFinal).agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.mover(posicionFinal);
	}
	*/

	public Casillero getCasillero(Posicion posicion) {
		ArrayList<Casillero> fila = this.casilleros.get( posicion.obtenerPosicionY() );
		return fila.get( posicion.obtenerPosicionX() );
	}
/*

	public void moverAlgoformerAlternoTerrestre(Algoformer algoformer, Posicion posicionFinal) {
		this.getCasillero(algoformer.getPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.getCasillero(posicionFinal).agregarAlgoformerAlternoTerrestre(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.mover(posicionFinal);
	}


	public void moverAlgoformerAlternoAereo(Algoformer algoformer, Posicion posicionFinal) {
		this.getCasillero(algoformer.getPosicion()).quitarAlgoformer(algoformer);
		//try{
			this.getCasillero(posicionFinal).agregarAlgoformerAlternoAereo(algoformer);
		//}catch (Exception ) SI NO SE PUDO MOVER VOLVER A POSICION INICIAL
		algoformer.mover(posicionFinal);	
	}


	public void agregarAlgoformerHumanoide(Algoformer algoformer, Posicion posicion) {
		this.getCasillero(posicion).agregarAlgoformerHumanoide(algoformer);
		algoformer.mover(posicion);
	}

	
	public void agregarAlgoformerHumanoideSinEfectoDeSuperficie(Algoformer algoformer, Posicion posicion) {
		Casillero casillero = this.getCasillero(posicion);
		casillero.agregarAlgoformerHumanoideSinEfectoDeSuperficie(algoformer);
		algoformer.mover(posicion);
	}
*/

	public int getDimensionX() {
		return this.dimensionX;
	}

	public int getDimensionY() {
		return this.dimensionY;
	}
}
