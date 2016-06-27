package fiuba.algo3.vistas;

import javafx.scene.layout.GridPane;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Posicion;

public class TableroVista extends GridPane {
	
	public static final int ACCION_NADA = 0;
	public static final int ACCION_MOVER = 1;
	public static final int ACCION_ATACAR = 2;
	public static final int ACCION_TRANSFORMAR = 3;
	public static final int ACCION_COMBINAR = 4;
	
	private int proximaAccion;
	private Tablero tablero;

    public TableroVista(Tablero tablero) {
        getStyleClass().add("tablero");
        this.setGridLinesVisible(true);
        this.tablero = tablero;
        this.llenarCadaCuadradoDelGridPane();

    }


    public void cambiar(Tablero tablero) {
        this.setNextSkin(tablero);
        this.llenarCadaCuadradoDelGridPane();
    }


    public void llenarCadaCuadradoDelGridPane() {
        String skinRequerido = tablero.getActualSkin();

        for (int i = 0; i < tablero.getDimensionX(); i++) {
            for (int j = 0; j < tablero.getDimensionY(); j++) {
                Posicion posicion = new Posicion(i,j);

                if (!tablero.getCasillero(posicion).estaVacio()) {
                	if (!tablero.getCasillero(posicion).getContenido().esChispa()) {
                		AlgoformerVista nuevoAlgoformerVista = new AlgoformerVista(tablero.getCasillero(posicion));
                        this.add(nuevoAlgoformerVista, i, j);

                	}  else if (tablero.getCasillero(posicion).getContenido().esChispa()) {

                		ChispaSupremaVista nuevaChispaSuprema = new ChispaSupremaVista(tablero.getCasillero(posicion));
                		this.add(nuevaChispaSuprema, i, j);
                	}
                } else {
                	tablero.getCasillero(posicion).setActualSkin(skinRequerido);
                	CasilleroVista nuevoCasilleroVista = new CasilleroVista(tablero.getCasillero(posicion),
                                                                    tablero.getCasillero(posicion).getSuperficie(skinRequerido).getNombreJSON());
                	this.add(nuevoCasilleroVista,i,j);
                }
            }
        }
    }
    
	public void setNextSkin(Tablero tablero) {
		String actualSkin = tablero.getActualSkin();
		tablero.setActualSkin(tablero.getProximoSkin());
		tablero.setProximoSkin(actualSkin);
	}
	


	public void setProximaAccion(int proximaAccion) {
		this.proximaAccion = proximaAccion;
	}

	public int getProximaAccion() {
		return this.proximaAccion;
	}

	public Tablero getTablero() {
		return this.tablero;
	}

	
}