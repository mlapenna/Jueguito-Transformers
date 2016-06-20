package fiuba.algo3.modelo;


import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Node;

class Square {
  enum State { EMPTY, NOUGHT, CROSS }

  private final SquareSkin skin;

  private ReadOnlyObjectWrapper<State> state = new ReadOnlyObjectWrapper<>(State.EMPTY);
  public ReadOnlyObjectProperty<State> stateProperty() {
    return state.getReadOnlyProperty();
  }
  public State getState() {
    return state.get();
  }

  private final Juego game;

/*  public Square(Game game) {
    this.game = game;

    skin = new SquareSkin(this);
  }*/
  
  public Square(Juego game,String superficie) {
    this.game = game;

    skin = new SquareSkin(this,superficie);
  }

  public void pressed() {
    if (!game.isGameOver() && state.get() == State.EMPTY) {
      state.set(game.getCurrentPlayer());
      game.boardUpdated();
      game.nextTurn();
    }
  }

  public Node getSkin() {
    return skin;
  }
}
