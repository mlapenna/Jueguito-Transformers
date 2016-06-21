package fiuba.algo3.modelos;

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
			JSONObject superficies = (JSONObject) unCasillero.get(JSON_FIELD_KEY_SUPERFICIES);

			this.casilleros.get(posicionY).get(posicionX).setSuperficies(superficies);

		}
	}

	public Casillero getCasillero(Posicion posicion) {
		ArrayList<Casillero> fila = this.casilleros.get( posicion.getY() );
		Casillero unCasillero = fila.get( posicion.getX() );
		return unCasillero;		
	}


	public void quitarContenido(Posicion posicion) {
		this.getCasillero(posicion).quitarContenido();		
	}

	public Contenido getContenido(Posicion posicion) {
		return this.getCasillero(posicion).getContenido();
	}


	public void setContenido(Posicion posicion, Contenido contenido) {
		this.getCasillero(posicion).setContenido(contenido);
	}

	public int getDimensionX() {
		return this.dimensionX;
	}

	public int getDimensionY() {
		return this.dimensionY;
	}



}
