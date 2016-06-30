package fiuba.algo3.vistas;

import fiuba.algo3.modelos.Casillero;
import javafx.scene.layout.GridPane;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Posicion;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Iterator;

public class TableroVista extends GridPane {
	
	public static final int ACCION_NADA = 0;
	public static final int ACCION_MOVER = 1;
	public static final int ACCION_ATACAR = 2;
	public static final int ACCION_TRANSFORMAR = 3;
	public static final int ACCION_COMBINAR = 4;


    private String tipoSuperficie = Tablero.SUPERFICIE_TIERRA;

	private int accion;
	private Tablero tablero;
    ArrayList<ArrayList<CasilleroVista>> casillerosVistas = new ArrayList<ArrayList<CasilleroVista>>();
    ArrayList<StackPane> algoformersYchispaVistas = new ArrayList<StackPane>();


    public TableroVista(Tablero tablero) {
        getStyleClass().add("tablero");
        this.setGridLinesVisible(true);
        this.tablero = tablero;
        this.mostrarSuperficies();
        this.mostrarRobotsYChispa();
        this.accion = TableroVista.ACCION_NADA;
    }


    public void alternarSuperficies() {
        if (this.tipoSuperficie == Tablero.SUPERFICIE_TIERRA) {
            this.tipoSuperficie = Tablero.SUPERFICIE_AIRE;
        } else {
            this.tipoSuperficie = Tablero.SUPERFICIE_TIERRA;
        }
        this.actualizarSuperficies();
    }


    public void mostrarSuperficies() {

        // Se crea cada vista de los casilleros y se agrega al Grid pane
        for (int i = 0; i < tablero.getDimensionX(); i++) {
            ArrayList<CasilleroVista> fila = new ArrayList<CasilleroVista>();
            for (int j = 0; j < tablero.getDimensionY(); j++) {
                Posicion posicion = new Posicion(i,j);

                Casillero casillero = tablero.getCasillero(posicion);
                CasilleroVista casilleroVista = new CasilleroVista(casillero, this.tipoSuperficie);
                this.add(casilleroVista, i, j);
                fila.add(casilleroVista);

            }
            this.casillerosVistas.add(fila);
        }
    }


    public void actualizarSuperficies() {

        Iterator<ArrayList<CasilleroVista>> filas = this.casillerosVistas.iterator();

        while (filas.hasNext()) {
            Iterator<CasilleroVista> columnas = filas.next().iterator();
            while (columnas.hasNext()) {
                CasilleroVista casilleroVista = columnas.next();
                casilleroVista.setImagen(this.tipoSuperficie);
            }
        }
    }


    public void mostrarRobotsYChispa() {

        for (int i = 0; i < tablero.getDimensionX(); i++) {

            for (int j = 0; j < tablero.getDimensionY(); j++) {
                Posicion posicion = new Posicion(i, j);

                if (!tablero.getCasillero(posicion).estaVacio()) {
                    if (tablero.getCasillero(posicion).getContenido().esChispa()) {
                        ChispaSupremaVista chispaSuprema = new ChispaSupremaVista(tablero.getCasillero(posicion));
                        this.add(chispaSuprema, i, j);
                        this.algoformersYchispaVistas.add(chispaSuprema);
                    } else {
                        AlgoformerVista algoformerVista = new AlgoformerVista(tablero.getCasillero(posicion));
                        this.add(algoformerVista, i, j);
                        this.algoformersYchispaVistas.add(algoformerVista);
                    }
                }
            }
        }
    }



    public void actualizarRobotsYChispa() {

        Iterator<StackPane> robotsYChispa = this.algoformersYchispaVistas.iterator();

        while (robotsYChispa.hasNext()) {
            this.getChildren().remove(robotsYChispa.next());
        }
        this.algoformersYchispaVistas.clear();

        this.mostrarRobotsYChispa();

    }

	public void setAccion(int accion) {
		this.accion = accion;
	}

	public int getAccion() {
		return this.accion;
    }

    public Tablero getTablero() {
		return this.tablero;
	}

}