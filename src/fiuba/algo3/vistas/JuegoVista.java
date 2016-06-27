package fiuba.algo3.vistas;
import fiuba.algo3.modelos.Tablero;
/*
import fiuba.algo3.controladores.TableroControlador;
import fiuba.algo3.modelos.Tablero;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JuegoVista extends Application {

	private TableroControlador tablero;


	public void mostrar(TableroControlador tablero) {
		this.tablero = tablero;

		// En alg�n lugar se deber� usar el contenido de la variable:
		//TableroVista tableroVista = new TableroVista(this.tablero); ESTO LO HACE TABLERO CONTROLADOR

		String[] argumentos = new String[0];
		try {
			launch(argumentos);
		} catch(Exception e) {
		}

	}


	public void start(Stage stage) throws Exception {

		/* C�digo de prueba */
/*
		stage.setTitle("Algoformers");

		StackPane layOut = new StackPane();

		Button button = new Button();
		button.setText("hola");
		layOut.getChildren().add(button);
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				System.out.println("me clickearon");
			}
		});

		Scene scene = new Scene(layOut);
		stage.setScene(scene);
		stage.show();

	}*/
import javafx.scene.layout.VBox;

public class JuegoVista extends VBox{

	JuegoVista(Tablero tablero) {
	    getChildren().addAll(
	        //tablero.getSkin()
	    );
	}
	
}

	