package fiuba.algo3.controladores;

import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.excepciones.*;
import fiuba.algo3.vistas.TableroVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TransformarButtonHandler implements EventHandler<ActionEvent>{
	
    TableroVista tableroVista;
	
    public TransformarButtonHandler(TableroVista tableroVista) {
        this.tableroVista = tableroVista;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.tableroVista.setAccion(TableroVista.ACCION_TRANSFORMAR);
    }
}
