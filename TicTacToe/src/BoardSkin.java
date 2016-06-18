import javafx.scene.layout.GridPane;

class BoardSkin extends GridPane {
	private int size = 5;
  BoardSkin(Board board) {
    getStyleClass().add("board");
    
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        add(board.getSquare(i, j).getSkin(), i, j);
      }
    }
  }
}