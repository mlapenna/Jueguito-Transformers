package fiuba.algo3.vistas;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class ReproducirSonido {

    public ReproducirSonido(String nombreArchivo) {
        this.reproducir(nombreArchivo, 1);
    }

    public ReproducirSonido(String nombreArchivo, double volumen) {
        this.reproducir(nombreArchivo, volumen);
    }

    private void reproducir(String nombreArchivo, double volumen) {
        String archivoURI = new File("sonidos/" + nombreArchivo).toURI().toString();
        Media sonidoFondo = new Media(archivoURI);
        MediaPlayer mediaPlayer = new MediaPlayer(sonidoFondo);
        mediaPlayer.play();
        mediaPlayer.setVolume(volumen);
    }
}
