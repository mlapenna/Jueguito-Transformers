package fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fiuba.algo3.vistas.TableroVista;
import javafx.scene.layout.VBox;
import fiuba.algo3.modelos.Tablero;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.EventObject;
import fiuba.algo3.vistas.CasilleroVista;
import fiuba.algo3.vistas.TableroVista;
import javafx.scene.Node;
import fiuba.algo3.modelos.Posicion;


public class MouseClickHandler {

	private TableroVista tableroVista;

	public MouseClickHandler(TableroVista tableroVista) {

		this.tableroVista = tableroVista;
		
		this.tableroVista.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

			Posicion posicionInicial;
     		Posicion posicionFinal;

            @Override
            public void handle(MouseEvent e) {
                for( Node node: tableroVista.getChildren()) {

                    if( node instanceof CasilleroVista && this.posiciones.size() <= 2) {
                        if( node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
                            System.out.println( "Cliqueado casillero " + TableroVista.getColumnIndex( node) + ',' + TableroVista.getRowIndex(node));
							this.posiciones.add(new Posicion(TableroVista.getColumnIndex( node),TableroVista.getRowIndex( node)));
                        }
                    }
                }

                if(this.posiciones.size() == 2) {
                	posicionInicial = this.posiciones.get(0);
                	posicionFinal = this.posiciones.get(1);

					tableroVista.realizarAccion(posicionInicial, posicionFinal);
					this.posiciones.clear();
              }
                
            }
        });		
	}

}
