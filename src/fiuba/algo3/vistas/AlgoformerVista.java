package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Casillero;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import fiuba.algo3.modelos.algoformers.*;


public class AlgoformerVista extends StackPane {

	  static final Image optimusHumanoide = new Image("file:imagenes/optimusHumanoide.png");
	  static final Image optimusAlterno = new Image("file:imagenes/optimusAlterno.png");
	  static final Image bumblebeeHumanoide = new Image("file:imagenes/bumblebeeHumanoide.png");
	  static final Image bumblebeeAlterno = new Image("file:imagenes/bumblebeeAlterno.png");
	  static final Image ratchetHumanoide = new Image("file:imagenes/ratchetHumanoide.png");
	  static final Image ratchetAlterno = new Image("file:imagenes/ratchetAlterno.png");
	  static final Image megatronHumanoide = new Image("file:imagenes/megatronHumanoide.png");
	  static final Image megatronAlterno = new Image("file:imagenes/megatronAlterno.png");
	  static final Image bonecrusherHumanoide = new Image("file:imagenes/bonecrusherHumanoide.png");
	  static final Image bonecrusherAlterno = new Image("file:imagenes/bonecrusherAlterno.png");
	  static final Image frenzyHumanoide = new Image("file:imagenes/frenzyHumanoide.png");
	  static final Image frenzyAlterno = new Image("file:imagenes/frenzyAlterno.png");
	  static final Image superionHumanoide = new Image("file:imagenes/superionHumanoide.png");
	  static final Image menasorHumanoide = new Image("file:imagenes/menasorHumanoide.png");
	  
	  private final ImageView imageView = new ImageView();
	  private Algoformer algoformer;

	  public AlgoformerVista(Casillero casillero) {
		  
		    getStyleClass().add("algoformer");

		    imageView.setMouseTransparent(true);
		    getChildren().setAll(imageView);
		    setPrefSize(optimusHumanoide.getHeight(), optimusHumanoide.getHeight());

			this.algoformer = (Algoformer) casillero.getContenido();

		    if(this.algoformer .getModo().esHumanoide()) {

		    	switch (this.algoformer .getNombre()) {
	        		case Optimus.nombreAlgoformer:  imageView.setImage(optimusHumanoide); break;
	        		case Ratchet.nombreAlgoformer:  imageView.setImage(ratchetHumanoide); break;
	        		case BumbleBee.nombreAlgoformer:  imageView.setImage(bumblebeeHumanoide); break;
	        		case Megatron.nombreAlgoformer:  imageView.setImage(megatronHumanoide); break;
	        		case Frenzy.nombreAlgoformer:  imageView.setImage(frenzyHumanoide); break;
	        		case Bonecrusher.nombreAlgoformer:  imageView.setImage(bonecrusherHumanoide); break;
	        		case Superion.nombreAlgoformer:  imageView.setImage(superionHumanoide); break;
	        		case Menasor.nombreAlgoformer:  imageView.setImage(menasorHumanoide); break;
		    	}
		    } else if (this.algoformer.getModo().esAlterno()) {
		    	switch (this.algoformer .getNombre()) {
        			case Optimus.nombreAlgoformer:  imageView.setImage(optimusAlterno); break;
        			case Ratchet.nombreAlgoformer:  imageView.setImage(ratchetAlterno); break;
        			case BumbleBee.nombreAlgoformer:  imageView.setImage(bumblebeeAlterno); break;
        			case Megatron.nombreAlgoformer:  imageView.setImage(megatronAlterno); break;
        			case Frenzy.nombreAlgoformer:  imageView.setImage(frenzyAlterno); break;
        			case Bonecrusher.nombreAlgoformer:  imageView.setImage(bonecrusherAlterno); break;
		    	}
		    }
	  }


	public Algoformer getAlgoformer() {
		return this.algoformer;
	}
}
