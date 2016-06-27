package fiuba.algo3.modelos;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import org.json.simple.JSONArray;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import fiuba.algo3.controladores.CambiarMapaButtonHandler;
import fiuba.algo3.controladores.CombinarButtonHandler;
import fiuba.algo3.controladores.AtacarButtonHandler;
import fiuba.algo3.controladores.MoverButtonHandler;
import fiuba.algo3.controladores.MouseClickHandler;
import fiuba.algo3.vistas.TableroVista;

public class AlgoformersGame extends Application {
	
	@Override public void start(Stage stage) throws Exception {
		Tablero tablero = crearModelo();
	    TableroVista tableroVista = new TableroVista(tablero);
	    
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
	    CambiarMapaButtonHandler cambiarMapaButtonHandler = new CambiarMapaButtonHandler(tableroVista, tablero);
 
        cambiarMapaButton.setOnAction(cambiarMapaButtonHandler);
        System.out.println(tablero.getActualSkin());
        VBox contenedorPrincipal = new VBox(tableroVista,contenedorHorizontal);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));       

        stage.setTitle("Algoformers Wars");
        final Scene scene = new Scene(contenedorPrincipal,1024,768);
        stage.setScene(scene);
	    stage.show();
	  }

	  public static void main(String[] args) {
		    Application.launch(AlgoformersGame.class);
	  }
	  
	  private Tablero crearModelo() throws IOException, ParseException{
		  JSONParser parser = new JSONParser();
		  JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
		  Tablero tablero = new Tablero(jsonTablero);
		  return tablero;
	  }
	  
}
