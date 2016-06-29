package fiuba.algo3.controladores;

import fiuba.algo3.modelos.Casillero;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.excepciones.*;
import fiuba.algo3.vistas.AlgoformerVista;
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

			Algoformer algoformerQueRealizaAccion;
            Posicion posicionDestinoDeLaAccion;

            @Override
            public void handle(MouseEvent e) {

                if (e.getTarget() instanceof AlgoformerVista) {

                    Algoformer algoformer = ((AlgoformerVista) e.getTarget()).getAlgoformer();

                    if (this.algoformerQueRealizaAccion == null) {
                        this.algoformerQueRealizaAccion = algoformer;
                    } else {
                        this.posicionDestinoDeLaAccion = algoformer.getPosicion();
                    }

                } else if (e.getTarget() instanceof CasilleroVista) {
                    if (this.algoformerQueRealizaAccion != null) {
                        this.posicionDestinoDeLaAccion = ((CasilleroVista) e.getTarget()).getCasillero().getPosicion();
                    }
                }

                if (this.algoformerQueRealizaAccion != null && this.posicionDestinoDeLaAccion != null) {
                    this.realizarAccion();
                    this.algoformerQueRealizaAccion = null;
                    this.posicionDestinoDeLaAccion = null;
                }

            }

            public void realizarAccion() {

                switch (tableroVista.getAccion()) {
                    case TableroVista.ACCION_MOVER:
                       
                        try {
                            this.algoformerQueRealizaAccion.mover(this.posicionDestinoDeLaAccion);
                            tableroVista.actualizarRobotsYChispa();

                        } catch (MovimientoInvalidoCasilleroOcupadoExcepcion movimientoInvalidoCasilleroOcupadoExcepcion) {

                            new AlertHandler(
                                    movimientoInvalidoCasilleroOcupadoExcepcion.getExcepcionTitulo(),
                                    movimientoInvalidoCasilleroOcupadoExcepcion.getExcepcionHeader(),
                                    movimientoInvalidoCasilleroOcupadoExcepcion.getExcepcionContent());

                        } catch (MovimientoInvalidoDistanciaNoValidaExcepcion movimientoInvalidoDistanciaNoValidaExcepcion) {
                            new AlertHandler(
                                    movimientoInvalidoDistanciaNoValidaExcepcion.getExcepcionTitulo(),
                                    movimientoInvalidoDistanciaNoValidaExcepcion.getExcepcionHeader(),
                                    movimientoInvalidoDistanciaNoValidaExcepcion.getExcepcionContent());

                        } catch (MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion movimientoInvalidoIncapazDeAtravezarSuperficieExcepcion) {
                            new AlertHandler(
                                    movimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.getExcepcionTitulo(),
                                    movimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.getExcepcionHeader(),
                                    movimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.getExcepcionContent());

                        } catch (AlgoformerInmovilizadoExcepcion algoformerInmovilizadoExcepcion) {
                            new AlertHandler(
                                    algoformerInmovilizadoExcepcion.getExcepcionTitulo(),
                                    algoformerInmovilizadoExcepcion.getExcepcionHeader(),
                                    algoformerInmovilizadoExcepcion.getExcepcionContent());

                        } catch (MovimientoInvalidoCasilleroInvalidoExcepcion movimientoInvalidoCasilleroInvalidoExcepcion) {
                            new AlertHandler(
                                    movimientoInvalidoCasilleroInvalidoExcepcion.getExcepcionTitulo(),
                                    movimientoInvalidoCasilleroInvalidoExcepcion.getExcepcionHeader(),
                                    movimientoInvalidoCasilleroInvalidoExcepcion.getExcepcionContent());

                        } catch (NoEsElTurnoDelJugadorExcepcion noEsElTurnoDelJugadorExcepcion) {
                            new AlertHandler(
                                    noEsElTurnoDelJugadorExcepcion.getExcepcionTitulo(),
                                    noEsElTurnoDelJugadorExcepcion.getExcepcionHeader(),
                                    noEsElTurnoDelJugadorExcepcion.getExcepcionContent());

                        } catch (Exception e) {
                            String titulo = "Ha ocurrido un error que no es reconocido.";
                            String header = titulo;
                            String content = titulo;
                            new AlertHandler(titulo, header, content);
                        };

                        break;

                    case TableroVista.ACCION_ATACAR:
                        try {

                            // CAMBIAR ESTO:
                            Algoformer algoformerDestino = (Algoformer) tableroVista.getTablero().getCasillero(this.posicionDestinoDeLaAccion).getContenido();

                            this.algoformerQueRealizaAccion.atacar(algoformerDestino);
                            tableroVista.actualizarRobotsYChispa();

                        } catch (AtaqueInvalidoDistanciaInsuficienteExcepcion ataqueInvalidoDistanciaInsuficienteExcepcion) {
                            new AlertHandler(
                                    ataqueInvalidoDistanciaInsuficienteExcepcion.getExcepcionTitulo(),
                                    ataqueInvalidoDistanciaInsuficienteExcepcion.getExcepcionHeader(),
                                    ataqueInvalidoDistanciaInsuficienteExcepcion.getExcepcionContent());

                        } catch (NoEsElTurnoDelJugadorExcepcion noEsElTurnoDelJugadorExcepcion) {
                            new AlertHandler(
                                    noEsElTurnoDelJugadorExcepcion.getExcepcionTitulo(),
                                    noEsElTurnoDelJugadorExcepcion.getExcepcionHeader(),
                                    noEsElTurnoDelJugadorExcepcion.getExcepcionContent());

                        } catch (AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion ataqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion) {
                            new AlertHandler(
                                    ataqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion.getExcepcionTitulo(),
                                    ataqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion.getExcepcionHeader(),
                                    ataqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion.getExcepcionContent());

                        } catch (Exception e) {
                            String titulo = "Ha ocurrido un error que no es reconocido.";
                            String header = "Ha ocurrido un error que no es reconocido.";
                            String content = "Ha ocurrido un error que no es reconocido.";
                            new AlertHandler(titulo,header,content);
                        }
                        break;
                    case TableroVista.ACCION_TRANSFORMAR:
                        break;
                    case TableroVista.ACCION_COMBINAR:
                        break;
                    default:
                        // Nada, se olvido de cliquear ATACAR o MOVER
                        break;
                }

                tableroVista.setAccion(TableroVista.ACCION_NADA);
            }

        });
	}

}
