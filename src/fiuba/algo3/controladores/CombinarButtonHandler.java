package fiuba.algo3.controladores;

import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.vistas.TableroVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CombinarButtonHandler implements EventHandler<ActionEvent>{
	
	 TableroVista tableroVista;

	 public CombinarButtonHandler(TableroVista tableroVista) {
		   
		 this.tableroVista = tableroVista;
	}
		

	   @Override
	   public void handle(ActionEvent actionEvent) {
//	       this.tableroVista.combinar(this.tableroVista.getTablero());
//		   this.tableroVista.actualizarTableroVista();
	   }

}
