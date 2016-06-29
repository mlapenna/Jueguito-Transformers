package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Casillero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import fiuba.algo3.modelos.superficies.*;


public class CasilleroVista extends StackPane {

    static final Image imagenRocas = new Image("file:imagenes/img/rocas.png");
    static final Image imagenPantano = new Image("file:imagenes/img/pantano1.png");
    static final Image imagenEspinas = new Image("file:imagenes/img/espinas.png");
    static final Image imagenNube = new Image("file:imagenes/img/nube.png");
    static final Image imagenNebulosa = new Image("file:imagenes/img/nebulosa.png");
    static final Image imagenTormenta = new Image("file:imagenes/img/tormenta.png");

    private final ImageView imageView = new ImageView();
    private Casillero casillero;


    public CasilleroVista(Casillero casillero, String tipoSuperficie) {
        this.casillero = casillero;
        getStyleClass().add("casillero");

        imageView.setMouseTransparent(true);
        getChildren().setAll(imageView);
        setPrefSize(imagenRocas.getHeight(), imagenRocas.getHeight());

        this.setImagen(tipoSuperficie);;
    }


    public Casillero getCasillero() {
        return this.casillero;
    }


    public void setImagen(String tipoSuperficie) {
        switch (casillero.getSuperficie(tipoSuperficie).getNombre()) {
            case Rocas.NOMBRE:
                imageView.setImage(imagenRocas);
                break;
            case Pantano.NOMBRE:
                imageView.setImage(imagenPantano);
                break;
            case Espinas.NOMBRE:
                imageView.setImage(imagenEspinas);
                break;
            case Nube.NOMBRE:
                imageView.setImage(new Image("file:imagenes/img/nube.png"));
                break;
            case NebulosaDeAndromeda.NOMBRE:
                imageView.setImage(imagenNebulosa);
                break;
            case TormentaPsionica.NOMBRE:
                imageView.setImage(imagenTormenta);
                break;
        }
    }
}
