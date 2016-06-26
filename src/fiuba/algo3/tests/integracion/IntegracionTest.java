package fiuba.algo3.tests.integracion;

import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Turno;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.algoformers.Megatron;
import fiuba.algo3.modelos.algoformers.Superion;
import fiuba.algo3.modelos.excepciones.AlgoformersNoAlineadosException;
import fiuba.algo3.modelos.excepciones.CantidadDeAlgoformersInsuficienteException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    
    @Test(expected=AlgoformersNoAlineadosException.class)
    public void testIntentarCombinarTresAlgoformersNoAlineadosYQueSalteExcepcion() throws IOException, ParseException, AlgoformersNoAlineadosException,
                                                                                            CantidadDeAlgoformersInsuficienteException {
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano2.json"));
        Tablero tablero = new Tablero(jsonTablero);
		Turno turno = new Turno();
		Jugador jugador1 = new Jugador("pepe", Algoformer.MODO_AUTOBOT, tablero, turno, new Juego(jsonTablero)); //ALGOFORMERS EN Y=0 Y=2 Y=4

		jugador1.combinarAlgoformers(turno);
    }
    
    @Test
    public void testCombinarTresAlgoformersAlineados() throws IOException, ParseException, AlgoformersNoAlineadosException,
                                                                            CantidadDeAlgoformersInsuficienteException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano2.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Jugador jugador2 = juego.getJugador2();
		
		Posicion posicion1 = new Posicion(0,1);
		Posicion posicion2 = new Posicion(0,3);

        ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
        algoformers.get(0).mover(posicion1);
        jugador2.getAlgoformers().get(0).cambiarModo();
        algoformers.get(2).mover(posicion2);
		
		jugador1.combinarAlgoformers(new Turno());

        ArrayList<Algoformer> algoformersCombinados = jugador1.getAlgoformers();
        Algoformer elAlgoformerCombinado = algoformersCombinados.get(0);

		Assert.assertEquals(algoformersCombinados.size(), 1);
        Assert.assertTrue(elAlgoformerCombinado instanceof Superion);
        Assert.assertEquals(elAlgoformerCombinado.getPosicion(), new Posicion(0, 2) );
    }
    
	@Test
	public void testVerQueLaChispaSeAgregaEnElMedio()
			throws IOException, ParseException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaPantano2.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Assert.assertTrue(jugador1.tablero().getContenido(jugador1.tablero().posicionCentro()).esChispa());
		
	}
	
    @Test
    public void testMatarAlgoformer() throws IOException, ParseException, AlgoformersNoAlineadosException,
                                                                            CantidadDeAlgoformersInsuficienteException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);

		Jugador jugador1 = juego.getJugador1();
		Jugador jugador2 = juego.getJugador2();

        ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
        Algoformer rival = jugador2.getAlgoformers().get(1);
        Algoformer ratchet = algoformers.get(2);//(0,4)
        ratchet.cambiarModo();
        rival.cambiarModo();
        ratchet.mover(new Posicion(3,4));//esquivo la chispa en (4,4)
        rival.cambiarModo();
        ratchet.mover(new Posicion(3,6));
        rival.cambiarModo();
        ratchet.mover(new Posicion(7,6));
        rival.cambiarModo();
        
        for(int i=0; i<6; i++){
        	ratchet.atacar(rival);
        	if (rival.estaVivo())
        		rival.cambiarModo();
        }
        Assert.assertTrue(!rival.estaVivo());
    }
    
    @Test
    public void testGanarPorAgarrarChispa() throws IOException, ParseException, AlgoformersNoAlineadosException,
                                                                            CantidadDeAlgoformersInsuficienteException {

		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);
		String nombre = juego.getJugador1().nombre();
		
        Algoformer ratchet = juego.getJugador1().getAlgoformers().get(2);//(0,4)
        Algoformer rival = juego.getJugador2().getAlgoformers().get(1);
        
        ratchet.cambiarModo();
        rival.cambiarModo();
        
        ratchet.mover(new Posicion(7,4));//la chispa esta en (4,4)
        
        Assert.assertEquals(juego.ganador(), nombre);
    }

	@Test
	public void testGanarPorMatarAlgoformers() throws IOException, ParseException, AlgoformersNoAlineadosException,
	                                                                        CantidadDeAlgoformersInsuficienteException {
	
		JSONParser parser = new JSONParser();
		JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/mapaTestZonaRocosa.json"));
		Juego juego = new Juego(jsonTablero);
	
		Jugador jugador1 = juego.getJugador1();
		Jugador jugador2 = juego.getJugador2();
		String nombre = jugador1.nombre();
	    ArrayList<Algoformer> algoformers = jugador1.getAlgoformers();
	    Algoformer rival = jugador2.getAlgoformers().get(1);
	    Algoformer ratchet = algoformers.get(2);//(0,4)
	    ratchet.cambiarModo();
	    rival.cambiarModo();
	    ratchet.mover(new Posicion(3,4));//esquivo la chispa en (4,4)
	    rival.cambiarModo();
	    ratchet.mover(new Posicion(3,7));
	    rival.cambiarModo();
	    ratchet.mover(new Posicion(7,7));
	    
	    for(int i=0; i<6; i++){
	    	rival.cambiarModo();
	    	ratchet.atacar(rival);
	    }
	    Assert.assertTrue(!rival.estaVivo());
	    
	    rival = jugador2.getAlgoformers().get(2);
	    for(int i=0; i<12; i++){
	    	rival.cambiarModo();
	    	ratchet.atacar(rival);
	    }
	    Assert.assertTrue(!rival.estaVivo());
	    
	    rival = jugador2.getAlgoformers().get(0);
	    rival.cambiarModo();
	    ratchet.mover(new Posicion(7,4));
	    for(int i=0; i<16; i++){
	    	rival.cambiarModo();
	    	ratchet.atacar(rival);
	    }
	    Assert.assertTrue(juego.ganador()==nombre);
	    	
	}

}