package fiuba.algo3.vistas;

import fiuba.algo3.controladores.CasilleroControlador;
import fiuba.algo3.modelos.superficies.Superficie;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class CasilleroVista extends StackPane { //DEJO LAS RUTAS DE NACHO, hagamos un directorio igual o algo asi
    	
	  static final Image noughtImage = new Image("file:imagenes/Megatron_Humanoide.png");
	  static final Image crossImage = new Image("file:imagenes/Optimus-Prime-Humanoide.png");
	
	  static final Image imagenRocas = new Image("file:imagenes/superficie_roca.png");
	  static final Image imagenPantano = new Image("file:imagenes/superficie_pantano.png");
	  static final Image imagenEspinas = new Image("file:imagenes/superficie_espina.png");
	  static final Image imagenNube = new Image("file:imagenes/superficie_nube.png");
	  static final Image imagenNebulosa = new Image("file:imagenes/superficie_nebulosa.png");
	  static final Image imagenTormenta = new Image("file:imagenes/superficie_tormenta_psionica.png");
	  
	  private final ImageView imageView = new ImageView();
	
	  public CasilleroVista(CasilleroControlador casillero, Superficie superficie) {
		  
		  getStyleClass().add("square");

		  imageView.setMouseTransparent(true);

		    getChildren().setAll(imageView);
		    setPrefSize(crossImage.getHeight(), crossImage.getHeight());

		  /* SI ESTO SE LLEGA A USAR FINALMENTE, DEBE EL MODELO PROVEER SU IMAGEN.... PORQUE PONER ACA EL LISTADO DE TODAS LAS SUPERFICIES NO LO VEO BIEN
		  switch (superficie) {
	        	case "Rocas":  imageView.setImage(imagenRocas);       	 	    break;
	        	case "Pantano": imageView.setImage(imagenPantano);			    break;
	        	case "Espinas":  imageView.setImage(imagenEspinas); 		    break;
	        	case "Nube":  imageView.setImage(imagenNube);					break;
	        	case "NebulosaDeAndromeda": imageView.setImage(imagenNebulosa); break;
	        	case "TormentaPsionica":  imageView.setImage(imagenTormenta);   break;
		    }
		   */
      }
	  
}
