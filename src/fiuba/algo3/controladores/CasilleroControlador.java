package fiuba.algo3.controladores;

import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.superficies.Superficie;
import fiuba.algo3.vistas.CasilleroVista;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Node;

public class CasilleroControlador {

	  enum State { EMPTY, NOUGHT, CROSS }

	  private final CasilleroVista vista;

	  private ReadOnlyObjectWrapper<State> state = new ReadOnlyObjectWrapper<>(State.EMPTY);
	  public ReadOnlyObjectProperty<State> stateProperty() {
	    return state.getReadOnlyProperty();
	  }
	  public State getState() {
	    return state.get();
	  }

	  private final Juego juego;

	  
	  public CasilleroControlador(Juego juego, Superficie superficie) {
	    this.juego = juego;

	    vista = new CasilleroVista(this, superficie);
	  }

	  public void pressed() {/*  FALTA LA LOGICA 
	    if (!juego.termino() && state.get() == State.EMPTY) {
	      state.set(juego.getJugadorActual());
	      juego.actualizarTablero();
	      juego.siguienteTurno();
	    }*/
	  }

	  public Node getVista() {
	    return vista;
	  }
	}