package fiuba.algo3.tests.integracion;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.algoformers.Megatron;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Juego;

import java.io.FileReader;
import java.io.IOException;

public class IntegracionTest {

    @Test
    public void testLlenarZonaPantanoYVerificarEnModoHumanoideNoPasaYVolverACondicionesIniciales() throws IOException, ParseException{

        JSONParser parser = new JSONParser();
        JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano.json"));
        Tablero tablero = new Tablero(jsonTablero);

        Posicion posicion = new Posicion(3, 0);
        Algoformer megatron = new Megatron(posicion,tablero);
        Posicion posicionDestino = new Posicion(2,0);

        try{
            megatron.mover(posicionDestino);
        }catch (Exception MovimientoInvalidoIncapazDeAtravezarSuperficieExcepcion){
            Assert.assertEquals(megatron.getPosicion(), posicion);
            Assert.assertEquals(tablero.getCasillero(posicion).getContenido(), megatron);
            Assert.assertTrue(tablero.getCasillero(posicionDestino).estaVacio());
        }
    }

}
