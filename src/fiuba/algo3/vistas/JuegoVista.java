package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Casillero;
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

import javafx.scene.control.ProgressBar;
import java.awt.Label;
import javafx.geometry.Pos;
import javafx.scene.Node;
import java.util.Collection;
import javafx.scene.text.Text;
import fiuba.algo3.modelos.algoformers.*;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.vistas.BarraJugadorVista;

public class JuegoVista extends Application {


	@Override
    public void start(Stage stage) throws Exception {
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader("mapas/mapaParaJugar.json");
        JSONObject jsonTablero = (JSONObject) parser.parse(fileReader);
        Juego juego = new Juego(jsonTablero, "Pedro", "Juan");


       TableroVista tableroVista = new TableroVista(juego);

		MouseClickHandler mouseClickHandler = new MouseClickHandler(tableroVista);

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
		VBox contenedorCentral = new VBox(tableroVista,contenedorHorizontal);
		contenedorCentral.setSpacing(10);
		contenedorCentral.setPadding(new Insets(20));

//		BarraJugadorVista barraJugador1 = new BarraJugadorVista(juego.getJugador1());
//		BarraJugadorVista barraJugador2 = new BarraJugadorVista(juego.getJugador2());
//		
//		VBox contenedorIzquierda = barraJugador1.getAlgoformersContenedor();
//		VBox contenedorDerecha = barraJugador2.getAlgoformersContenedor();
		
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
