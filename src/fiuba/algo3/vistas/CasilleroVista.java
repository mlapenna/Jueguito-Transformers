package fiuba.algo3.vistas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class CasilleroVista extends StackPane { //DEJO LAS RUTAS DE NACHO, hagamos un directorio igual o algo asi
    	
	  static final Image noughtImage = new Image("file:/home/nachox/workspace/TicTacToe/src/Megatron_Humanoide.png");
	  static final Image crossImage = new Image("file:/home/nachox/workspace/TicTacToe/src/Optimus-Prime-Humanoide.png");
	
	  static final Image imagenRocas = new Image("file:/home/nachox/workspace/TicTacToe/src/superficie_roca.png");
	  static final Image imagenPantano = new Image("file:/home/nachox/workspace/TicTacToe/src/superficie_pantano.png");
	  static final Image imagenEspinas = new Image("file:/home/nachox/workspace/TicTacToe/src/superficie_espina.png");
	  static final Image imagenNube = new Image("file:/home/nachox/workspace/TicTacToe/src/superficie_nube.png");
	  static final Image imagenNebulosa = new Image("file:/home/nachox/workspace/TicTacToe/src/superficie_nebulosa.png");
	  static final Image imagenTormenta = new Image("file:/home/nachox/workspace/TicTacToe/src/superficie_tormenta_psionica.png");
	  
	  private final ImageView imageView = new ImageView();
	
	  public CasilleroVista(String superficie) {
		  
		  getStyleClass().add("square");

		  imageView.setMouseTransparent(true);

		    getChildren().setAll(imageView);
		    setPrefSize(crossImage.getHeight(), crossImage.getHeight());
		    switch (superficie) {
	        	case "Rocas":  imageView.setImage(imagenRocas);       	 	    break;
	        	case "Pantano": imageView.setImage(imagenPantano);			    break;
	        	case "Espinas":  imageView.setImage(imagenEspinas); 		    break;
	        	case "Nube":  imageView.setImage(imagenNube);					break;
	        	case "NebulosaDeAndromeda": imageView.setImage(imagenNebulosa); break;
	        	case "TormentaPsionica":  imageView.setImage(imagenTormenta);   break;
		    }
      }

}
