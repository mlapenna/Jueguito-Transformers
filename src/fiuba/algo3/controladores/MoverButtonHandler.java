package fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.vistas.TableroVista;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.EventObject;
import fiuba.algo3.vistas.CasilleroVista;
import fiuba.algo3.vistas.TableroVista;
import javafx.scene.Node;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.controladores.MouseClickHandler;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoCasilleroOcupadoExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;
import fiuba.algo3.modelos.excepciones.NoEsElTurnoDelJugadorExcepcion;
import fiuba.algo3.modelos.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoCasilleroInvalidoExcepcion;

public class MoverButtonHandler implements EventHandler<ActionEvent>{
	
	TableroVista tableroVista;

	public MoverButtonHandler(TableroVista tableroVista) {
		this.tableroVista = tableroVista;
    }

    @Override
	public void handle(ActionEvent actionEvent) {
		this.tableroVista.setProximaAccion(TableroVista.ACCION_MOVER);
        this.tableroVista.actualizarTableroVista();
    }
}