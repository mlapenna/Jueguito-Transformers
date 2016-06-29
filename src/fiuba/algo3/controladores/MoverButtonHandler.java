package fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fiuba.algo3.vistas.TableroVista;


public class MoverButtonHandler implements EventHandler<ActionEvent>{
	
	TableroVista tableroVista;

	public MoverButtonHandler(TableroVista tableroVista) {
		this.tableroVista = tableroVista;
    }

    @Override
	public void handle(ActionEvent actionEvent) {
		this.tableroVista.setAccion(TableroVista.ACCION_MOVER);
    }
}