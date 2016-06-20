import java.io.FileReader;

import javafx.scene.Node;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import org.json.simple.JSONArray;

class Board {
  private final BoardSkin skin;
  private final Square[][] squaresTierra;
  private final Square[][] squaresAire;
  private final Square[][] squares;
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

  public Board(Game game) {
	  try{this.getBoardFromFile();} catch (IOException ioexception){System.out.println("Salto la excepcion IO.");} catch (ParseException parseexception){System.out.println("Salto la excepcion Parse.");};
	  this.loadBoardSize();
	  this.squaresTierra = new Square[this.dimensionX][this.dimensionY];
	  this.squaresAire = new Square[this.dimensionX][this.dimensionY];
	  this.constructBoard(game);
	  this.squares = this.squaresTierra;
	  skin = new BoardSkin(this);
  }
  
  private void loadBoardSize() {
	 this.dimensionX = Integer.parseInt( this.jsonTablero.get(JSON_FIELD_KEY_DIMENSION_X).toString() );
	 this.dimensionY = Integer.parseInt( this.jsonTablero.get(JSON_FIELD_KEY_DIMENSION_Y).toString() );
  }
  
  private void constructBoard(Game game) {
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

  public Square getSquare(int i, int j) {
    return squares[i][j];
  }

  public Node getSkin() {
    return skin;
  }
}