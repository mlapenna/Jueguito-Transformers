import javafx.scene.layout.GridPane;

class BoardSkin extends GridPane {

  BoardSkin(Board board) {
    getStyleClass().add("board");
    for (int i = 0; i < board.dimensionX; i++) {
      for (int j = 0; j < board.dimensionY; j++) {
        add(board.getSquare(i, j).getSkin(), i, j);
      }
    }
  }
}