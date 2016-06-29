package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Casillero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class ChispaSupremaVista extends StackPane {

	  static final Image chispaSuprema = new Image("file:imagenes/ChispaSuprema.png");
	  private final ImageView imageView = new ImageView();
	  
	  public ChispaSupremaVista(Casillero casillero) {
		    getStyleClass().add("chispa");

		    imageView.setMouseTransparent(true);
		    getChildren().setAll(imageView);
		    setPrefSize(chispaSuprema.getHeight(), chispaSuprema.getHeight());
 	        imageView.setImage(chispaSuprema);
	  }
	  
}