package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.controladores.CasilleroControlador;
import fiuba.algo3.controladores.TableroControlador;
import fiuba.algo3.modelos.superficies.Superficie;
import javafx.scene.layout.GridPane;



public class TableroVista extends GridPane{
	
    public TableroVista(TableroControlador tablero) {
    	//getStyleClass().add("tablero");
    	this.tableroVistaTierra(tablero);
    }
    
    public void tableroVistaAire(TableroControlador tablero) {
        Posicion posicion = new Posicion(0,0);

        for (int columna=0; columna < tablero.getDimensionY(); columna++) {
            for (int fila = 0; fila < tablero.getDimensionX(); fila++) {
                posicion.setCoordenadas(fila, columna);
                Superficie superficie = ((Tablero) tablero.getJSONTablero()).getCasillero(posicion).getSuperficieTierra();
                CasilleroVista casillero = new CasilleroVista(tablero.getCasillero(posicion), superficie);

            }
        }
    }
    
    public void tableroVistaTierra(TableroControlador tablero) {

        Posicion posicion = new Posicion(0,0);

        for (int columna=0; columna < tablero.getDimensionY(); columna++) {
            for (int fila = 0; fila < tablero.getDimensionY(); fila++) {
                posicion.setCoordenadas(fila, columna);
                Superficie superficie = ((Tablero) tablero.getJSONTablero()).getCasillero(posicion).getSuperficieTierra();
                CasilleroVista casillero = new CasilleroVista(tablero.getCasillero(posicion), superficie);

            }
        }
    }
    
}