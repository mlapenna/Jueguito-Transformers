package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.io.FileReader;
import javafx.scene.Node;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import org.json.simple.JSONArray;
import fiuba.algo3.modelo.TableroSkin;

public class Tablero {

	ArrayList<ArrayList<Casillero>> casilleros = new ArrayList<ArrayList<Casillero>>();
	
	private int dimensionX;
	private int dimensionY;
	private final TableroSkin skin;
	private final Square[][] squaresTierra;
	private final Square[][] squaresAire;
	private final Square[][] squares;
	private JSONObject jsonTablero;
	private JSONArray jsonCasilleros;
	private Juego game;
	
	private static final String JSON_FIELD_KEY_DIMENSION_X = "dimensionX";
	private static final String JSON_FIELD_KEY_DIMENSION_Y = "dimensionY";
	private static final String JSON_FIELD_KEY_CASILLEROS = "casilleros";
	private static final String JSON_FIELD_KEY_POSICION_X = "posicionX";
	private static final String JSON_FIELD_KEY_POSICION_Y = "posicionY";
	private static final String JSON_FIELD_KEY_SUPERFICIES = "superficies";
	private static final String JSON_FIELD_KEY_SUPERFICIE_TIERRA = "tierra";
	private static final String JSON_FIELD_KEY_SUPERFICIE_AIRE = "aire";

	public Tablero(JSONObject json) {

		try{
			JSONParser parser = new JSONParser();
			this.jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		} catch (IOException ioexception){System.out.println("Salto la excepcion IO.");} catch (ParseException parseexception){System.out.println("Salto la excepcion Parse.");};
		this.loadBoardSize();
		this.squaresTierra = new Square[this.dimensionX][this.dimensionY];
		this.squaresAire = new Square[this.dimensionX][this.dimensionY];
		this.constructBoard();
		this.squares = this.squaresTierra;
		this.skin = new TableroSkin(this);

		// Se crea cada casillero
		for (int i = 0; i < this.dimensionY; i++) {
			ArrayList<Casillero> fila = new ArrayList<Casillero>();
			for (int j=0; j < this.dimensionX ; j++) {
				fila.add( new Casillero() );
			}
			this.casilleros.add(fila);
		}
	}

	private void loadBoardSize() {
		 this.dimensionX = Integer.parseInt( this.jsonTablero.get(JSON_FIELD_KEY_DIMENSION_X).toString() );
		 this.dimensionY = Integer.parseInt( this.jsonTablero.get(JSON_FIELD_KEY_DIMENSION_Y).toString() );
	}
	
	 private void constructBoard() {
		  int posicionX;
		  int posicionY;
		  JSONObject superficies;
		  String superficieTierra;
		  String superficieAire;
		  
		  JSONArray jsonCasilleros = (JSONArray) jsonTablero.get(JSON_FIELD_KEY_CASILLEROS);
		  for (int i = 0; i < jsonCasilleros.size(); i++) {
			  JSONObject unCasillero = (JSONObject) jsonCasilleros.get(i);
			  posicionX = Integer.parseInt( unCasillero.get(JSON_FIELD_KEY_POSICION_X).toString() );
			  posicionY = Integer.parseInt( unCasillero.get(JSON_FIELD_KEY_POSICION_Y).toString() );
			  superficies = (JSONObject) unCasillero.get(JSON_FIELD_KEY_SUPERFICIES);
			  superficieTierra = superficies.get(JSON_FIELD_KEY_SUPERFICIE_TIERRA).toString();
			  superficieAire = superficies.get(JSON_FIELD_KEY_SUPERFICIE_AIRE).toString();
			  this.squaresTierra[posicionX][posicionY] = new Square(game,superficieTierra);
			  this.squaresAire[posicionX][posicionY] = new Square(game,superficieAire);
		  }
		  
		  for (int i = 0; i < this.dimensionY; i++) {
			ArrayList<Casillero> fila = new ArrayList<Casillero>();
			for (int j=0; j < this.dimensionX ; j++) {
				fila.add( new Casillero() );
			}
			this.casilleros.add(fila);
		  }
		  
	  }
	
	public void getJuego(Juego game){
		this.game = game;
	}
	 
	public Casillero getCasillero(Posicion posicion) { //VER SI FUNCIONA
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


	public Square getSquare(int i, int j) {
		return squares[i][j];
	}

	public Node getSkin() {
		 return skin;
	}

}
