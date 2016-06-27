package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.Tablero;
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


public class JuegoVista extends Application {


	@Override
    public void start(Stage stage) throws Exception {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("mapas/mapaParaJugar.json");
        JSONObject jsonTablero = (JSONObject) parser.parse(fileReader);
        Juego juego = new Juego(jsonTablero);


       TableroVista tableroVista = new TableroVista(juego.getTablero());

		MouseClickHandler mouseClickHandler = new MouseClickHandler(tableroVista);

		Button moverButton = new Button();
		moverButton.setText("Mover");
		MoverButtonHandler moverButtonHandler = new MoverButtonHandler(tableroVista);
		moverButton.setOnAction(moverButtonHandler);

		Button atacarButton = new Button();
		atacarButton.setText("Atacar");
		AtacarButtonHandler atacarButtonHandler = new AtacarButtonHandler(tableroVista);
		atacarButton.setOnAction(atacarButtonHandler);

		Button combinarButton = new Button();
		combinarButton.setText("Combinar");
		CombinarButtonHandler combinarButtonHandler = new CombinarButtonHandler(tableroVista);
		combinarButton.setOnAction(combinarButtonHandler);

		Button cambiarMapaButton = new Button();
		cambiarMapaButton.setText("Cambiar de superficie");

		HBox contenedorHorizontal = new HBox(moverButton, atacarButton, combinarButton, cambiarMapaButton);

		contenedorHorizontal.setSpacing(10);
		CambiarMapaButtonHandler cambiarMapaButtonHandler = new CambiarMapaButtonHandler(tableroVista, juego.getTablero() );

		cambiarMapaButton.setOnAction(cambiarMapaButtonHandler);
		//System.out.println(tablero.getActualSkin());
		VBox contenedorPrincipal = new VBox(tableroVista,contenedorHorizontal);
		contenedorPrincipal.setSpacing(10);
		contenedorPrincipal.setPadding(new Insets(20));

		stage.setTitle("Algoformers Wars");
		final Scene scene = new Scene(contenedorPrincipal,1024,768);
		stage.setScene(scene);
		stage.show();
	}

	public void main(String[] args) {
		Application.launch(JuegoVista.class);
	}

}
