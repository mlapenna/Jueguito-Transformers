package fiuba.algo3.controladores;

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
		this.tableroVista.setAccion(TableroVista.ACCION_COMBINAR);
	}

}
