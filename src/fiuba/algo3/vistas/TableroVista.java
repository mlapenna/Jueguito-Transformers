package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import javafx.scene.layout.GridPane;


public class TableroVista extends GridPane{

    public TableroVista(Tablero tablero) {
    	String superficie = "";
    	Posicion posicion = new Posicion(0,0);
    	this.tableroVistaAire(tablero,superficie,posicion);
    	this.tableroVistaTierra(tablero,superficie,posicion);
    	
    }
    
    private void tableroVistaAire(Tablero tablero, String superficie, Posicion posicion){

        for (int columna=0; columna < tablero.getDimensionY(); columna++) {
            for (int fila = 0; fila < tablero.getDimensionX(); fila++) {
                posicion.setCoordenadas(fila, columna);
                superficie = tablero.getCasillero(posicion).getSuperficieAire().getSuperficie();
                CasilleroVista casillero = new CasilleroVista(superficie);

            }
        }
    }
    
    private void tableroVistaTierra(Tablero tablero, String superficie, Posicion posicion){

        for (int columna=0; columna < tablero.getDimensionY(); columna++) {
            for (int fila = 0; fila < tablero.getDimensionX(); fila++) {
                posicion.setCoordenadas(fila, columna);
                superficie = tablero.getCasillero(posicion).getSuperficieTierra().getSuperficie();
                CasilleroVista casillero = new CasilleroVista(superficie);

            }
        }
    }


}