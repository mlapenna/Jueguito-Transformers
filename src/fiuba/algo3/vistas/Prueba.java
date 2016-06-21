package fiuba.algo3.vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Prueba extends Application{

	public void start(Stage stage) throws Exception {
		stage.setTitle("prueba");
		
		StackPane layOut = new StackPane();
		
		Button button = new Button();
		button.setText("hola");
		layOut.getChildren().add(button);
		button.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent actionEvent)
			{
				System.out.println("me clickearon");
			}
		});
		
		Scene scene = new Scene(layOut);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main (String [] args) throws Exception{
		launch(args);
	}
	
}
