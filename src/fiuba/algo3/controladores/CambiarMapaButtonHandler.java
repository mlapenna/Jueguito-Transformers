package fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.vistas.TableroVista;

public class CambiarMapaButtonHandler implements EventHandler<ActionEvent>{
	
	 Tablero tablero;
	 TableroVista tableroVista;
	
  public CambiarMapaButtonHandler(TableroVista tableroVista, Tablero tablero) {
	   
		this.tablero = tablero;
		this.tableroVista = tableroVista;
	}
	

  @Override
  public void handle(ActionEvent actionEvent) {
      this.tableroVista.cambiar(tablero);
  }

}