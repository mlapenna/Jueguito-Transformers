package fiuba.algo3.controladores;

import java.io.FileReader;

import javafx.scene.Node;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.vistas.TableroVista;

import java.io.IOException;
import org.json.simple.JSONArray;

public class TableroControlador {
  private final TableroVista vista;
  private final CasilleroControlador[][] tableroTierra;
  private final CasilleroControlador[][] tableroAire;
  private final CasilleroControlador[][] tablero;
  public int dimensionX;
  public int dimensionY;
  private JSONObject jsonTablero;
  private JSONArray jsonCasilleros;

  private static final String JSON_FIELD_KEY_DIMENSION_X = "dimensionX";
  private static final String JSON_FIELD_KEY_DIMENSION_Y = "dimensionY";
  private static final String JSON_FIELD_KEY_CASILLEROS = "casilleros";
  private static final String JSON_FIELD_KEY_POSICION_X = "posicionX";
  private static final String JSON_FIELD_KEY_POSICION_Y = "posicionY";
  private static final String JSON_FIELD_KEY_SUPERFICIES = "superficies";
  private static final String JSON_FIELD_KEY_SUPERFICIE_TIERRA = "tierra";
  private static final String JSON_FIELD_KEY_SUPERFICIE_AIRE = "aire";


  
  public TableroControlador(Juego juego) {
	  try{this.getBoardFromFile();} catch (IOException ioexception){System.out.println("Salto la excepcion IO.");} catch (ParseException parseexception){System.out.println("Salto la excepcion Parse.");};
	  this.setDimension();
	  this.tableroTierra = new CasilleroControlador[this.dimensionX][this.dimensionY];
	  this.tableroAire = new CasilleroControlador[this.dimensionX][this.dimensionY];
	  this.crearTablero(juego);
	  this.tablero = this.tableroTierra;
	  vista = new TableroVista(this);
  }
  
  private void setDimension() {
	 this.dimensionX = Integer.parseInt( this.jsonTablero.get(JSON_FIELD_KEY_DIMENSION_X).toString() );
	 this.dimensionY = Integer.parseInt( this.jsonTablero.get(JSON_FIELD_KEY_DIMENSION_Y).toString() );
  }
  
  private void crearTablero(Juego juego) {
	  int posicionX;
	  int posicionY;
	  JSONObject superficies;
	  String superficieTierra;
	  String superficieAire;

	  /*
	   LO COMENTO PARA QUE ME COMPILE, YA QUE NO SE SI ESTO SE VA A USAR O QUITAR :

	  JSONArray jsonCasilleros = (JSONArray) jsonTablero.get(JSON_FIELD_KEY_CASILLEROS);
	  for (int i = 0; i < jsonCasilleros.size(); i++) {
		  JSONObject unCasillero = (JSONObject) jsonCasilleros.get(i);
		  posicionX = Integer.parseInt( unCasillero.get(JSON_FIELD_KEY_POSICION_X).toString() );
		  posicionY = Integer.parseInt( unCasillero.get(JSON_FIELD_KEY_POSICION_Y).toString() );
		  superficies = (JSONObject) unCasillero.get(JSON_FIELD_KEY_SUPERFICIES);
		  superficieTierra = superficies.get(JSON_FIELD_KEY_SUPERFICIE_TIERRA).toString();
		  superficieAire = superficies.get(JSON_FIELD_KEY_SUPERFICIE_AIRE).toString();
		  this.tableroTierra[posicionX][posicionY] = new CasilleroControlador(juego,superficieTierra);
		  this.tableroAire[posicionX][posicionY] = new CasilleroControlador(juego,superficieAire);
	  }
	  /*
	  /*for (int i = 0; i < this.dimensionY; i++) {
		  for (int j = 0; j < this.dimensionX; j++) {
			  this.squaresTierra[i][j] = new Square(game,"Rocas");
			  this.squaresAire[i][j] = new Square(game,"Nube");
	 	 }
	  }*/
  }
   
  private void getBoardFromFile() throws IOException, ParseException  {
	  JSONParser parser = new JSONParser();
	  this.jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
  }

  public CasilleroControlador getCasillero(Posicion posicion) {
    return this.tablero[posicion.getX()][posicion.getY()];
  }

  public TableroVista getVista() {
    return vista;
  }

	public int getDimensionY() {
		return this.dimensionY;
	}

	public int getDimensionX() {
		return this.dimensionX;
	}

	public Object getJSONTablero() {
		return this.jsonTablero;
	}
	
	/*public void cambiarVista(){
		Posicion posicion = new Posicion (0,0);
	    for (int columna=0; columna < this.getDimensionY(); columna++) {
            for (int fila = 0; fila < this.getDimensionY(); fila++) {
                posicion.setCoordenadas(fila, columna);
                this.getCasillero(posicion).cambiarVista();
            }
	    }     
	}*/

}