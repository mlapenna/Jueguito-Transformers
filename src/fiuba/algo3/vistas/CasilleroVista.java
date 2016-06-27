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

    static final Image imagenRocas = new Image("file:imagenes/img/rocas.png");
    static final Image imagenPantano = new Image("file:imagenes/img/pantano1.png");
    static final Image imagenEspinas = new Image("file:imagenes/img/espinas.png");
    static final Image imagenNube = new Image("file:imagenes/img/nube.png");
    static final Image imagenNebulosa = new Image("file:imagenes/img/nebulosa.png");
    static final Image imagenTormenta = new Image("file:imagenes/img/tormenta.png");

    private final ImageView imageView = new ImageView();
    private Casillero casillero;

    public CasilleroVista(Casillero casillero, String superficie) {
        this.casillero = casillero;
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

    public Casillero getCasillero() {
        return this.casillero;
    }
}
