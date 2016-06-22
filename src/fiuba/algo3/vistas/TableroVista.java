package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.controladores.CasilleroControlador;
import fiuba.algo3.controladores.TableroControlador;
import javafx.scene.layout.GridPane;



public class TableroVista extends GridPane{
	
    public TableroVista(TableroControlador tablero) {
    	//getStyleClass().add("tablero");
    	
    	String superficieAux = "";
    	Posicion posicion = new Posicion(0,0);
    	this.tableroVistaTierra(tablero,superficieAux,posicion);
    }
    
    public void tableroVistaAire(TableroControlador tablero, String superficie, Posicion posicion){

        for (int columna=0; columna < tablero.getDimensionY(); columna++) {
            for (int fila = 0; fila < tablero.getDimensionX(); fila++) {
                posicion.setCoordenadas(fila, columna);
                superficie = ((Tablero) tablero.getJSONTablero()).getCasillero(posicion).getSuperficieTierra().getSuperficie();
                CasilleroVista casillero = new CasilleroVista(tablero.getCasillero(posicion), superficie);

            }
        }
    }
    
    public void tableroVistaTierra(TableroControlador tablero, String superficie, Posicion posicion){

        for (int columna=0; columna < tablero.getDimensionY(); columna++) {
            for (int fila = 0; fila < tablero.getDimensionY(); fila++) {
                posicion.setCoordenadas(fila, columna);
                superficie = ((Tablero) tablero.getJSONTablero()).getCasillero(posicion).getSuperficieTierra().getSuperficie();
                CasilleroVista casillero = new CasilleroVista(tablero.getCasillero(posicion), superficie);

            }
        }
    }
    
}