package fiuba.algo3.modelo;

import javafx.scene.layout.GridPane;

class TableroSkin extends GridPane {

	TableroSkin(Tablero tablero) {
    getStyleClass().add("tablero");
    for (int i = 0; i < tablero.getDimensionX(); i++) {
      for (int j = 0; j < tablero.getDimensionY(); j++) {
        add(tablero.getSquare(i, j).getSkin(), i, j);
      }
    }
  }
}