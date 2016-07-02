package fiuba.algo3.controladores;

import java.io.File;

import fiuba.algo3.vistas.JuegoVista;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Juego {
	
    public static void main(String[] args) throws Exception {

        JuegoVista juegoVista = new JuegoVista();

        String musicFile = "sounds/Thunderstruck.mp3";   
        juegoVista.main(args);
    }

}
