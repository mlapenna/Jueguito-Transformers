package fiuba.algo3.controladores;

import fiuba.algo3.modelos.Casillero;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.excepciones.*;
import fiuba.algo3.vistas.AlgoformerVista;
import javafx.event.EventHandler;
import fiuba.algo3.vistas.TableroVista;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.vistas.CasilleroVista;
import fiuba.algo3.modelos.Posicion;


public class MouseClickHandler {

	private TableroVista tableroVista;

	public MouseClickHandler(TableroVista tableroVista) {

		this.tableroVista = tableroVista;
		
		this.tableroVista.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			Algoformer algoformerQueRealizaAccion;
            Posicion posicionDestinoDeLaAccion;

            @Override
            public void handle(MouseEvent e) {
                if (tableroVista.getAccion() != TableroVista.ACCION_NADA) {

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

                    if (this.algoformerQueRealizaAccion != null &&
                            (this.posicionDestinoDeLaAccion != null
                                    || tableroVista.getAccion() == TableroVista.ACCION_TRANSFORMAR
                                    || tableroVista.getAccion() == TableroVista.ACCION_COMBINAR)) {

                        this.realizarAccion();
                        this.algoformerQueRealizaAccion = null;
                        this.posicionDestinoDeLaAccion = null;
                    }
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
                            Casillero casillero = tableroVista.getTablero().getCasillero(this.posicionDestinoDeLaAccion);

                            if (casillero.estaVacio() || casillero.getContenido().esChispa()) {
                                String titulo = "Ataque Inv\u00e1lido";
                                String header = "El casillero de destino no tiene un algoformer.";
                                String content = "Debes atacar casilleros ocupados por robots del otro jugador.";
                                new AlertHandler(titulo, header, content);
                            } else {
                                this.algoformerQueRealizaAccion.atacar((Algoformer) casillero.getContenido());
                                tableroVista.actualizarRobotsYChispa();
                            }

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
                    	try {
                    		this.algoformerQueRealizaAccion.cambiarModo();
                            tableroVista.actualizarRobotsYChispa();

                    	} catch (MenasorNoPuedeTransformarseExcepcion menasorNoPuedeTransformarseException) {
                    		new AlertHandler(
                                menasorNoPuedeTransformarseException.getExcepcionTitulo(),
                                menasorNoPuedeTransformarseException.getExcepcionHeader(),
                                menasorNoPuedeTransformarseException.getExcepcionContent());

                    	} catch (SuperionNoPuedeTransformarseExcepcion superionNoPuedeTransformarseException){
	            		    new AlertHandler(
	            				superionNoPuedeTransformarseException.getExcepcionTitulo(),
	            				superionNoPuedeTransformarseException.getExcepcionHeader(),
	            				superionNoPuedeTransformarseException.getExcepcionContent());

                        } catch (NoEsElTurnoDelJugadorExcepcion noEsElTurnoDelJugadorExcepcion) {
                            new AlertHandler(
	                            noEsElTurnoDelJugadorExcepcion.getExcepcionTitulo(),
	                            noEsElTurnoDelJugadorExcepcion.getExcepcionHeader(),
	                            noEsElTurnoDelJugadorExcepcion.getExcepcionContent());

                        } catch (AlgoformerCombinadoNoPuedeTransformarseExcepcion algoformerCombinadoNoPuedeTransformarseExcepcion) {
                            new AlertHandler(
                                    algoformerCombinadoNoPuedeTransformarseExcepcion.getExcepcionTitulo(),
                                    algoformerCombinadoNoPuedeTransformarseExcepcion.getExcepcionHeader(),
                                    algoformerCombinadoNoPuedeTransformarseExcepcion.getExcepcionContent());

                        } catch (Exception e) {
                            String titulo = "Ha ocurrido un error que no es reconocido.";
                            String header = titulo;
                            String content = titulo;
                            new AlertHandler(titulo,header,content);
                        }
                        break;
                        
                    case TableroVista.ACCION_COMBINAR:
                    	try {
                    		Jugador jugador = this.algoformerQueRealizaAccion.getTurno().getJugadorDelQueEsElTurno();
                           	jugador.combinarAlgoformers(this.algoformerQueRealizaAccion.getTurno());
                           	tableroVista.actualizarRobotsYChispa();

                        } catch (AlgoformersNoAlineadosException algoformersNoAlineadosException) {
                    		new AlertHandler(
                                algoformersNoAlineadosException.getExcepcionTitulo(),
                                algoformersNoAlineadosException.getExcepcionHeader(),
                                algoformersNoAlineadosException.getExcepcionContent());

                        } catch (CantidadDeAlgoformersInsuficienteException cantidadDeAlgoformersInsuficienteException) {
                    		new AlertHandler(
                                cantidadDeAlgoformersInsuficienteException.getExcepcionTitulo(),
                                cantidadDeAlgoformersInsuficienteException.getExcepcionHeader(),
                                cantidadDeAlgoformersInsuficienteException.getExcepcionContent());

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
		                }
                    	break;

                }

                tableroVista.setAccion(TableroVista.ACCION_NADA);
            }

        });
	}

}
