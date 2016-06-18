import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

class SquareSkin extends StackPane {
  static final Image noughtImage = new Image(
	  "file:/home/nachox/workspace/TicTacToe/src/Megatron_Humanoide.png"  
);
  static final Image crossImage = new Image(
	  "file:/home/nachox/workspace/TicTacToe/src/Optimus-Prime-Humanoide.png"
  );

  private final ImageView imageView = new ImageView();

  SquareSkin(final Square square) {
    getStyleClass().add("square");

    imageView.setMouseTransparent(true);

    getChildren().setAll(imageView);
    System.out.println(crossImage.getHeight());
    setPrefSize(crossImage.getHeight() + 20, crossImage.getHeight() + 20);

    setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        square.pressed();
      }
    });

    square.stateProperty().addListener(new ChangeListener<Square.State>() {
      @Override public void changed(ObservableValue<? extends Square.State> observableValue, Square.State oldState, Square.State state) {
        switch (state) {
          case EMPTY:  imageView.setImage(null);        break;
          case NOUGHT: imageView.setImage(noughtImage); break;
          case CROSS:  imageView.setImage(crossImage);  break;
        }
      }
    });
  }
}