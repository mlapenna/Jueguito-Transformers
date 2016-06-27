package fiuba.algo3.vistas;

import javafx.scene.layout.GridPane;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.vistas.ChispaSupremaVista;
import fiuba.algo3.vistas.CasilleroVista;
import fiuba.algo3.vistas.AlgoformerVista;
import fiuba.algo3.controladores.AlertHandler;
import fiuba.algo3.modelos.Casillero;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelos.excepciones.AtaqueInvalidoDistanciaInsuficienteExcepcion;
import fiuba.algo3.modelos.excepciones.AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoCasilleroInvalidoExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoCasilleroOcupadoExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelos.excepciones.MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion;
import fiuba.algo3.modelos.excepciones.NoEsElTurnoDelJugadorExcepcion;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fiuba.algo3.modelos.Casillero;

public class TableroVista extends GridPane {
	
	private static final String INICIAL = "inicial";
	private static final String FINAL = "final";

	public static final int ACCION_NADA = 0;
	public static final int ACCION_MOVER = 1;
	public static final int ACCION_ATACAR = 2;

	private int proximaAccion;
	private Tablero tablero;

    public TableroVista(Tablero tablero) {
        getStyleClass().add("tablero");
        this.setGridLinesVisible(true);
        this.tablero = tablero;
        this.llenarCadaCuadradoDelGridPane(tablero);

    }


    public void cambiar(Tablero tablero) {
        this.setNextSkin(tablero);
        this.llenarCadaCuadradoDelGridPane(tablero);
    }


    private void llenarCadaCuadradoDelGridPane(Tablero tablero) {
        String skinRequerido = tablero.getActualSkin();

        for (int i = 0; i < tablero.getDimensionX(); i++) {
            for (int j = 0; j < tablero.getDimensionY(); j++) {
                Posicion posicion = new Posicion(i,j);
            	System.out.println(tablero.getCasillero(posicion).estaVacio());

                if(!tablero.getCasillero(posicion).estaVacio()) {
                	if(!tablero.getCasillero(posicion).getContenido().esChispa())
                	{
                		AlgoformerVista nuevoAlgoformerVista = new AlgoformerVista(tablero.getCasillero(posicion));
                        System.out.println("Contenido seleccionado en casillero :"+((Algoformer)tablero.getCasillero(posicion).getContenido()).getNombre());
                		this.add(nuevoAlgoformerVista, i, j);
                	} 
                	else if (tablero.getCasillero(posicion).getContenido().esChispa()) {
                		ChispaSupremaVista nuevaChispaSuprema = new ChispaSupremaVista(tablero.getCasillero(posicion));
                		System.out.println("Contenido seleccionado en casillero es chispa suprema :"+tablero.getCasillero(posicion).getContenido().esChispa());
                		this.add(nuevaChispaSuprema, i, j);
                	}
                } else {
                	tablero.getCasillero(posicion).setActualSkin(skinRequerido);
                	CasilleroVista nuevoCasilleroVista = new CasilleroVista(tablero.getCasillero(posicion),tablero.getCasillero(posicion).getSuperficie(skinRequerido).getNombreJSON());
                	System.out.println("Superficie seleccionada en casillero :"+tablero.getCasillero(posicion).getSuperficie(skinRequerido).getNombreJSON());
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
	
//	public Tablero getTablero() {
//		return this.tablero;
//	}
	
	public void actualizarTableroVista() {
		this.llenarCadaCuadradoDelGridPane(this.tablero);
	}

	public void dosPosicionesCliqueadas(Posicion posicionInicial, Posicion posicionFinal) {
		Casillero inicial = tablero.getCasillero(posicionInicial);
		Casillero ultimo = tablero.getCasillero(posicionFinal);

		switch (this.proximaAccion) {
			case TableroVista.ACCION_MOVER:
				try{
					if(!ultimo.estaVacio() || inicial.estaVacio()) throw new MovimientoInvalidoCasilleroInvalidoExcepcion();
					if(!inicial.estaVacio() && !inicial.getContenido().esChispa()) {
						((Algoformer)inicial.getContenido()).mover(posicionFinal);
						System.out.println("MOVER DE " + posicionInicial.getX() + "," + posicionFinal.getY()+" a "
							+ posicionFinal.getX() + "," + posicionFinal.getY());
					}
					else
					{
						throw new MovimientoInvalidoCasilleroInvalidoExcepcion();
					}
		    	}
		        catch (MovimientoInvalidoCasilleroOcupadoExcepcion movimientoInvalidoCasilleroOcupadoExcepcion) {
		        	new AlertHandler(
		        			movimientoInvalidoCasilleroOcupadoExcepcion.getExcepcionTitulo(),
		        			movimientoInvalidoCasilleroOcupadoExcepcion.getExcepcionHeader(),
		        			movimientoInvalidoCasilleroOcupadoExcepcion.getExcepcionContent());
		        }
		        catch (MovimientoInvalidoDistanciaNoValidaExcepcion movimientoInvalidoDistanciaNoValidaExcepcion) {
		        	new AlertHandler(
		        			movimientoInvalidoDistanciaNoValidaExcepcion.getExcepcionTitulo(),
		        			movimientoInvalidoDistanciaNoValidaExcepcion.getExcepcionHeader(),
		        			movimientoInvalidoDistanciaNoValidaExcepcion.getExcepcionContent());
		        }
		        catch (MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion movimientoInvalidoIncapazDeAtravezarSuperficieExcepcion) {
		        	new AlertHandler(
		        			movimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.getExcepcionTitulo(),
		        			movimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.getExcepcionHeader(),
		        			movimientoInvalidoIncapazDeAtravezarSuperficieExcepcion.getExcepcionContent());
		        }
		        catch (AlgoformerInmovilizadoExcepcion algoformerInmovilizadoExcepcion) {    		
		        	new AlertHandler(
		        			algoformerInmovilizadoExcepcion.getExcepcionTitulo(),
		        			algoformerInmovilizadoExcepcion.getExcepcionHeader(),
		        			algoformerInmovilizadoExcepcion.getExcepcionContent());}
		        catch (MovimientoInvalidoCasilleroInvalidoExcepcion movimientoInvalidoCasilleroInvalidoExcepcion) {
		        	new AlertHandler(
		        			movimientoInvalidoCasilleroInvalidoExcepcion.getExcepcionTitulo(),
		        			movimientoInvalidoCasilleroInvalidoExcepcion.getExcepcionHeader(),
		        			movimientoInvalidoCasilleroInvalidoExcepcion.getExcepcionContent());
		        }
		        catch (NoEsElTurnoDelJugadorExcepcion noEsElTurnoDelJugadorExcepcion) {
		        	new AlertHandler(
		        			noEsElTurnoDelJugadorExcepcion.getExcepcionTitulo(),
		        			noEsElTurnoDelJugadorExcepcion.getExcepcionHeader(),
		        			noEsElTurnoDelJugadorExcepcion.getExcepcionContent());
		        }
		        catch (Exception e) {
		        	String titulo = "Ha ocurrido un error que no es reconocido.";
		        	String header = "Ha ocurrido un error que no es reconocido.";
		        	String content = "Ha ocurrido un error que no es reconocido.";
		        	new AlertHandler(titulo,header,content);
		        };				
				
				break;
			case TableroVista.ACCION_ATACAR:
				try{
					if(ultimo.estaVacio() || inicial.estaVacio()) throw new MovimientoInvalidoCasilleroInvalidoExcepcion();
					if(!inicial.estaVacio() && !inicial.getContenido().esChispa() && !ultimo.estaVacio() && !ultimo.getContenido().esChispa()) 
					{
						((Algoformer)inicial.getContenido()).atacar((Algoformer)ultimo.getContenido());
						System.out.println("ATACAR DE " + posicionInicial.getX() + "," + posicionFinal.getY()+" a "
								+ posicionFinal.getX() + "," + posicionFinal.getY());
					}
					else
					{
						throw new MovimientoInvalidoCasilleroInvalidoExcepcion();
					}
				}
			   	catch (AtaqueInvalidoDistanciaInsuficienteExcepcion ataqueInvalidoDistanciaInsuficienteExcepcion) {
			   		new AlertHandler(
			   				ataqueInvalidoDistanciaInsuficienteExcepcion.getExcepcionTitulo(),
			   				ataqueInvalidoDistanciaInsuficienteExcepcion.getExcepcionHeader(),
			   				ataqueInvalidoDistanciaInsuficienteExcepcion.getExcepcionContent());
			   	}
			   	catch (NoEsElTurnoDelJugadorExcepcion noEsElTurnoDelJugadorExcepcion) {
			   		new AlertHandler(
			   				noEsElTurnoDelJugadorExcepcion.getExcepcionTitulo(),
			   				noEsElTurnoDelJugadorExcepcion.getExcepcionHeader(),
			  				noEsElTurnoDelJugadorExcepcion.getExcepcionContent());
			   	}
			   	catch (AtaqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion ataqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion) {
			   		new AlertHandler(
			   				ataqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion.getExcepcionTitulo(),
			   				ataqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion.getExcepcionHeader(),
			   				ataqueInvalidoFriendlyFireNoEstaHabilitadoExcepcion.getExcepcionContent());
			   	}
				catch (Exception e) {
					String titulo = "Ha ocurrido un error que no es reconocido.";
					String header = "Ha ocurrido un error que no es reconocido.";
					String content = "Ha ocurrido un error que no es reconocido.";
					new AlertHandler(titulo,header,content);
				}
				break;
			default:
				// Nada, se olvid� de cliquear ATACAR o MOVER
				break;
		}

		this.proximaAccion = TableroVista.ACCION_NADA;
	}

	public void setProximaAccion(int proximaAccion) {
		this.proximaAccion = proximaAccion;
	}

	
}