package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Juego;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import fiuba.algo3.controladores.CambiarMapaButtonHandler;
import fiuba.algo3.controladores.CombinarButtonHandler;
import fiuba.algo3.controladores.AtacarButtonHandler;
import fiuba.algo3.controladores.MoverButtonHandler;
import fiuba.algo3.controladores.MouseClickHandler;
import fiuba.algo3.controladores.TransformarButtonHandler;

public class JuegoVista extends Application {

    private static final String temaDeFondo = "temaDeFondo-thunderstruck.mp3";
    public static final String sonidoMovimiento = "movimiento.mp3";
    public static final String sonidoAtaque = "disparo.mp3";
    public static final String sonidoTransformacion = "transformacion.mp3";
    public static final String sonidoCombinacion = "combinacion.mp3";
    public static final String sonidoFinJuego = "juegoTerminado.mp3";


	@Override
    public void start(Stage stage) throws Exception {

        // Música de fondo
		new ReproducirSonido(this.temaDeFondo, 0.6);

        // Cargar tablero
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("mapas/mapaParaJugar.json");
        JSONObject jsonTablero = (JSONObject) parser.parse(fileReader);
        Juego juego = new Juego(jsonTablero, "Autobot", "Decepticon");  

        TableroVista tableroVista = new TableroVista(juego);

        // Controladores de eventos
		new MouseClickHandler(tableroVista);

		Button moverButton = new Button();
		moverButton.setText("Mover");
		MoverButtonHandler moverButtonHandler = new MoverButtonHandler(tableroVista);
		moverButton.setOnAction(moverButtonHandler);

		Button atacarButton = new Button();
		atacarButton.setText("Atacar");
		AtacarButtonHandler atacarButtonHandler = new AtacarButtonHandler(tableroVista);
		atacarButton.setOnAction(atacarButtonHandler);
		
		Button transformarButton = new Button();
		transformarButton.setText("Transformar");
		TransformarButtonHandler transformarButtonHandler = new TransformarButtonHandler(tableroVista);
		transformarButton.setOnAction(transformarButtonHandler);

		Button combinarButton = new Button();
		combinarButton.setText("Combinar");
		CombinarButtonHandler combinarButtonHandler = new CombinarButtonHandler(tableroVista);
		combinarButton.setOnAction(combinarButtonHandler);

		Button cambiarMapaButton = new Button();
		cambiarMapaButton.setText("Cambiar de superficie");

		HBox contenedorHorizontal = new HBox(moverButton, atacarButton, transformarButton, combinarButton, cambiarMapaButton);

		contenedorHorizontal.setSpacing(10);
		CambiarMapaButtonHandler cambiarMapaButtonHandler = new CambiarMapaButtonHandler(tableroVista, juego.getTablero() );

		cambiarMapaButton.setOnAction(cambiarMapaButtonHandler);
		
		VBox contenedorCentral = new VBox(tableroVista.getContenedorSuperior(),tableroVista,contenedorHorizontal);
		contenedorCentral.setSpacing(10);
		contenedorCentral.setPadding(new Insets(20));

		HBox contenedorPrincipal = new HBox(tableroVista.getContenedorIzquierda(),contenedorCentral,tableroVista.getContenedorDerecha());
		
		stage.setTitle("Algoformers");
		final Scene scene = new Scene(contenedorPrincipal,1024,768);
		stage.setScene(scene);
		stage.show();
	}


	public void main(String[] args) {
		Application.launch(JuegoVista.class);
	}
	
}
