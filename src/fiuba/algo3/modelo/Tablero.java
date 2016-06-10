package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
//import javafx.geometry.Pos;
import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.superficies.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import fiuba.algo3.modelo.movimientos.Movimiento;

public class Tablero {

	ArrayList<ArrayList<Casillero>> casilleros = new ArrayList<ArrayList<Casillero>>();
	
	private int dimensionX;
	private int dimensionY;

	private static final String JSON_FIELD_KEY_DIMENSION_X = "dimensionX";
	private static final String JSON_FIELD_KEY_DIMENSION_Y = "dimensionY";
	private static final String JSON_FIELD_KEY_CASILLEROS = "casilleros";
	private static final String JSON_FIELD_KEY_POSICION_X = "posicionX";
	private static final String JSON_FIELD_KEY_POSICION_Y = "posicionY";
	private static final String JSON_FIELD_KEY_TIERRA = "tierra";
	private static final String JSON_FIELD_KEY_AIRE = "aire";


	public Tablero(JSONObject json) {

		this.dimensionX = Integer.parseInt( json.get(JSON_FIELD_KEY_DIMENSION_X).toString() );
		this.dimensionY = Integer.parseInt( json.get(JSON_FIELD_KEY_DIMENSION_Y).toString() );
		
		// Se pone Vacio en todas las ubicaciones posibles
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
			String superficieTierraString = unCasillero.get(JSON_FIELD_KEY_TIERRA).toString();
			String superficieAireString = unCasillero.get(JSON_FIELD_KEY_AIRE).toString();

			Tierra superficieTierra=null; //PIDE INICIALIZAR
			Aire superficieAire=null;

			switch (superficieTierraString) {
				case Rocas.NOMBRE_JSON:
					superficieTierra = new Rocas();
					break;
				case Pantano.NOMBRE_JSON:
					superficieTierra = new Pantano();
					break;
				case Espinas.NOMBRE_JSON:
					superficieTierra = new Espinas();
					break;
			}

			switch (superficieAireString) {
				case Nube.NOMBRE_JSON:
					superficieAire = new Nube();
					break;
				case NebulosaDeAndromeda.NOMBRE_JSON:
					superficieAire = new NebulosaDeAndromeda();
					break;
				case TormentaPsionica.NOMBRE_JSON:
					superficieAire = new TormentaPsionica();
					break;
			}

			this.casilleros.get(posicionX).get(posicionY).setSuperficies(superficieTierra, superficieAire);
		}
	}




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
	

	public Casillero getCasillero(Posicion posicion) {
		ArrayList<Casillero> fila = this.casilleros.get( posicion.obtenerPosicionY() );
		return fila.get( posicion.obtenerPosicionX() );
	}


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


	public int getDimensionX() {
		return this.dimensionX;
	}

	public int getDimensionY() {
		return this.dimensionY;
	}
}
