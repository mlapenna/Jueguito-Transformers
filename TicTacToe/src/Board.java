import java.io.FileReader;

import javafx.scene.Node;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;

class Board {
  private final BoardSkin skin;
  private final Square[][] squares;
  
  public int dimensionX;
  public int dimensionY;

	private static final String JSON_FIELD_KEY_DIMENSION_X = "dimensionX";
	private static final String JSON_FIELD_KEY_DIMENSION_Y = "dimensionY";
	private static final String JSON_FIELD_KEY_CASILLEROS = "casilleros";
	private static final String JSON_FIELD_KEY_POSICION_X = "posicionX";
	private static final String JSON_FIELD_KEY_POSICION_Y = "posicionY";
	private static final String JSON_FIELD_KEY_SUPERFICIES = "superficies";

  public Board(Game game) {
	try{this.loadBoardSize();} catch(Exception e){};
	this.squares = new Square[this.dimensionY][this.dimensionX];
	this.constructBoard(game);
	skin = new BoardSkin(this);

  }
  
  private void loadBoardSize() throws IOException, ParseException {
	  JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		this.dimensionX = Integer.parseInt( jsonTablero.get(JSON_FIELD_KEY_DIMENSION_X).toString() );
		this.dimensionY = Integer.parseInt( jsonTablero.get(JSON_FIELD_KEY_DIMENSION_Y).toString() );
  }
  
  private void constructBoard(Game game) {
	    for (int i = 0; i < this.dimensionY; i++) {
	      for (int j = 0; j < this.dimensionX; j++) {
	        squares[i][j] = new Square(game);
	      }
	    }
  }

  public Square getSquare(int i, int j) {
    
    return squares[i][j];
  }

  public Node getSkin() {
    return skin;
  }
}