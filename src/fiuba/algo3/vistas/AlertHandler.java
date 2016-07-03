package fiuba.algo3.vistas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class AlertHandler {
	
	public AlertHandler(String title,String header,String content) {
	
	Alert alert = new Alert(AlertType.ERROR);
	alert.setTitle(title);
	alert.setHeaderText(header);
	alert.setContentText(content);

	alert.showAndWait();
	}
}
