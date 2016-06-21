package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;


public class TableroVista {

    public TableroVista(Tablero tablero) {

        for (int columna=0; columna < tablero.getDimensionY(); columna++) {
            for (int fila = 0; fila < tablero.getDimensionX(); fila++) {
                Posicion posicion = new Posicion(fila, columna);
                CasilleroVista casillero = new CasilleroVista( tablero.getCasillero(posicion) );

            }
        }

    }
}
 