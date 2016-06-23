package fiuba.algo3.tests.integracion;

import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Turno;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.algoformers.Megatron;
import fiuba.algo3.modelos.excepciones.ErrorAlgoformersNoAlineadosException;
import fiuba.algo3.modelos.excepciones.ErrorCantidadDeAlgoformersInsuficienteException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class IntegracionTest {

    @Test
    public void testLlenarZonaPantanoYVerificarEnModoHumanoideNoPasaYVolverACondicionesIniciales() throws IOException, ParseException{

        JSONParser parser = new JSONParser();
        JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
        Tablero tablero = new Tablero(jsonTablero);

        Posicion posicion = new Posicion(3, 0);
        Algoformer megatron = new Megatron(posicion, tablero, new Turno());
        Posicion posicionDestino = new Posicion(2,0);

        try{
            megatron.mover(posicionDestino);
        }catch (Exception MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion){
            Assert.assertEquals(megatron.getPosicion(), posicion);
            Assert.assertEquals(tablero.getCasillero(posicion).getContenido(), megatron);
            Assert.assertTrue(tablero.getCasillero(posicionDestino).estaVacio());
        }
    }
    
    @Test(expected=ErrorAlgoformersNoAlineadosException.class)
    public void testIntentarCombinarTresAlgoformersNoAlineadosYQueSalteExcepcion() throws FileNotFoundException, IOException, ParseException, ErrorAlgoformersNoAlineadosException, ErrorCantidadDeAlgoformersInsuficienteException{
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano2.json"));
        Tablero tablero = new Tablero(jsonTablero);
		Turno turno = new Turno();
		Jugador jugador1 = new Jugador("pepe", Algoformer.MODO_AUTOBOT, tablero, turno); //ALGOFORMERS EN Y=0 Y=2 Y=4
		Iterator<Algoformer> misAlgoformers = jugador1.getAlgoformersIterator();
		
		jugador1.combinarAlgoformers(turno);
    }
    
    @Test
    public void testCombinarTresAlgoformersAlineados() throws FileNotFoundException, IOException, ParseException, ErrorAlgoformersNoAlineadosException, ErrorCantidadDeAlgoformersInsuficienteException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestSinZonas.json"));
        Tablero tablero = new Tablero(jsonTablero);
		Turno turno = new Turno();
		Jugador jugador1 = new Jugador("pepe", Algoformer.MODO_AUTOBOT, tablero, turno); //ALGOFORMERS EN Y=0 Y=2 Y=4
		Iterator<Algoformer> misAlgoformers = jugador1.getAlgoformersIterator();
		
		Posicion posicion1 = new Posicion(0,1);
		Posicion posicion2 = new Posicion(0,3);
		
		jugador1.getAlgoformers().get(0).mover(posicion1);
		jugador1.getAlgoformers().get(2).mover(posicion2);
		
		jugador1.combinarAlgoformers(turno);
		
		Assert.assertEquals(jugador1.getAlgoformers().size(),1);
    }

}
