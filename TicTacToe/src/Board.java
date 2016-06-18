import javafx.scene.Node;

class Board {
  private final BoardSkin skin;
  private int size = 5;
  private final Square[][] squares = new Square[size][size];

  public Board(Game game) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        squares[i][j] = new Square(game);
      }
    }

    skin = new BoardSkin(this);
  }

  public Square getSquare(int i, int j) {
    return squares[i][j];
  }

  public Node getSkin() {
    return skin;
  }
}