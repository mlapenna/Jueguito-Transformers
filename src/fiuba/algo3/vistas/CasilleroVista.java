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


public class CasilleroVista extends StackPane{

	  static final Image imagenRocas = new Image("file:imagenes/superficie_roca.png");
	  static final Image imagenPantano = new Image("file:imagenes/superficie_pantano.png");
	  static final Image imagenEspinas = new Image("file:imagenes/superficie_espina.png");
	  static final Image imagenNube = new Image("file:imagenes/superficie_nube.png");
	  static final Image imagenNebulosa = new Image("file:imagenes/superficie_nebulosa.png");
	  static final Image imagenTormenta = new Image("file:imagenes/superficie_tormenta_psionica.png");
	  private final ImageView imageView = new ImageView();
	  
	  public CasilleroVista(Casillero casillero, String superficie) {
		    getStyleClass().add("casillero");

		    imageView.setMouseTransparent(true);
		    getChildren().setAll(imageView);
		    setPrefSize(imagenRocas.getHeight(), imagenRocas.getHeight());
		    switch (superficie) {
	        	case Rocas.NOMBRE_JSON:  imageView.setImage(imagenRocas);        break;
	        	case Pantano.NOMBRE_JSON: imageView.setImage(imagenPantano); break;
	        	case Espinas.NOMBRE_JSON:  imageView.setImage(imagenEspinas);  break;
	        	case Nube.NOMBRE_JSON:  imageView.setImage(imagenNube);        break;
	        	case NebulosaDeAndromeda.NOMBRE_JSON: imageView.setImage(imagenNebulosa); break;
	        	case TormentaPsionica.NOMBRE_JSON:  imageView.setImage(imagenTormenta);  break;
		    }
	  }
	  
}
