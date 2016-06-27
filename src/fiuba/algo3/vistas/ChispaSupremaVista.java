package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Casillero;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import fiuba.algo3.modelos.superficies.*;


public class ChispaSupremaVista extends StackPane{

	  static final Image chispaSuprema = new Image("file:imagenes/chispSuperma.png");
	  private final ImageView imageView = new ImageView();
	  
	  public ChispaSupremaVista(Casillero casillero) {
		    getStyleClass().add("casillero");

		    imageView.setMouseTransparent(true);
		    getChildren().setAll(imageView);
		    setPrefSize(chispaSuprema.getHeight(), chispaSuprema.getHeight());
 	        imageView.setImage(chispaSuprema);
	  }
	  
}