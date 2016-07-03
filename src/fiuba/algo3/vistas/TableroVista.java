package fiuba.algo3.vistas;

import fiuba.algo3.controladores.AlertHandler;
import fiuba.algo3.modelos.Casillero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Posicion;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Iterator;
import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.Jugador;
import javafx.scene.text.Text;

public class TableroVista extends GridPane {
	
	public static final int ACCION_NADA = 0;
	public static final int ACCION_MOVER = 1;
	public static final int ACCION_ATACAR = 2;
	public static final int ACCION_TRANSFORMAR = 3;
	public static final int ACCION_COMBINAR = 4;
	public static final String TURNO_DE = "Es el turno de los ";

    private String tipoSuperficie = Tablero.SUPERFICIE_TIERRA;

	private int accion;
	private Tablero tablero;
	private Juego juego;
	private BarraJugadorVista barraJugador1;
	private BarraJugadorVista barraJugador2;
    ArrayList<ArrayList<CasilleroVista>> casillerosVistas = new ArrayList<ArrayList<CasilleroVista>>();
    ArrayList<StackPane> algoformersYchispaVistas = new ArrayList<StackPane>();
    private VBox contenedorIzquierda;
    private VBox contenedorDerecha;
    private VBox contenedorSuperior;
    private String jugadorTurno;
    
    public TableroVista(Juego juego) {
        getStyleClass().add("tablero");
        this.setGridLinesVisible(true);
        this.tablero = juego.getTablero();
        this.juego = juego;
        this.mostrarSuperficies();
        this.mostrarRobotsYChispa();
        this.crearBarrasJugadores();
        this.accion = TableroVista.ACCION_NADA;
        this.jugadorTurno = this.juego.getJugador1().getTurno().getJugadorDelQueEsElTurno().nombre();
        this.contenedorSuperior = new VBox();
        this.contenedorSuperior.setAlignment(Pos.TOP_CENTER);
        this.contenedorSuperior.setPadding(new Insets(3));
        Text label = new Text(TURNO_DE+this.jugadorTurno);
        this.contenedorSuperior.getChildren().add(label);
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

    private void chequearFinDeJuego() {
   		if (this.juego.hayGanador()){
    	 	String ganador = this.juego.ganador();
    		String mensajeGanador = "el ganador del juego es: xxxx";
    	 	mensajeGanador = mensajeGanador.replace("xxxx", ganador);
				
    		new AlertHandler(
                "FIN DEL JUEGO",
                mensajeGanador,
                "hasta luego!"
    	       );
   		}
   	}


    public void actualizarRobotsYChispa() {

        Iterator<StackPane> robotsYChispa = this.algoformersYchispaVistas.iterator();

        while (robotsYChispa.hasNext()) {
            this.getChildren().remove(robotsYChispa.next());
        }
        this.algoformersYchispaVistas.clear();

        this.mostrarRobotsYChispa();
        this.actualizarBarrasJugadores();
        this.actualizarJugadorTurno();
        this.chequearFinDeJuego();
    }
    
    private void actualizarJugadorTurno() {
    	this.jugadorTurno = this.juego.getJugador1().getTurno().getJugadorDelQueEsElTurno().nombre();
    	this.contenedorSuperior.getChildren().clear();
    	Text label = new Text(TURNO_DE+this.jugadorTurno);
        this.contenedorSuperior.getChildren().add(label);
    }
    
    private void crearBarrasJugadores() {
    	this.barraJugador1 = new BarraJugadorVista(this.juego.getJugador1());
		this.barraJugador2 = new BarraJugadorVista(this.juego.getJugador2());
		
		this.contenedorIzquierda = barraJugador1.getAlgoformersContenedor();
		this.contenedorDerecha = barraJugador2.getAlgoformersContenedor();
    }
    
    private void actualizarBarrasJugadores() {
    	this.contenedorIzquierda.getChildren().clear();
    	BarraJugadorVista barraJugador1 = new BarraJugadorVista(juego.getJugador1());
    	VBox contenedorAux1 = barraJugador1.getAlgoformersContenedor();
    	this.contenedorIzquierda.getChildren().add(contenedorAux1);
    	
    	this.contenedorDerecha.getChildren().clear();
    	BarraJugadorVista barraJugador2= new BarraJugadorVista(juego.getJugador2());
    	VBox contenedorAux2 = barraJugador2.getAlgoformersContenedor();
    	this.contenedorDerecha.getChildren().add(contenedorAux2);
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

    public VBox getContenedorDerecha() {
    	return this.contenedorDerecha;
    }
    
    public VBox getContenedorIzquierda() {
    	return this.contenedorIzquierda;
    }
    
    public VBox getContenedorSuperior() {
    	return this.contenedorSuperior;
    }
       
}