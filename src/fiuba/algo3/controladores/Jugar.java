package fiuba.algo3.controladores;

import fiuba.algo3.modelos.Juego;
import fiuba.algo3.modelos.Jugador;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.vistas.JuegoVista;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Jugar {  //Segun dijeron en clase el main estaba en una clase q herede de application...
					  //ya se que hacen el launch en juegoVista y es parecido, pero habria q verlo
	
    public static void main (String[] args) throws Exception {

        JSONParser parser = new JSONParser();
        JSONObject jsonTablero = (JSONObject) parser.parse(new FileReader("mapas/1.json"));
        Tablero tablero = new Tablero(jsonTablero);
        Jugador jugador1 = new Jugador("Pedro", Algoformer.MODO_AUTOBOT, tablero);
        Jugador jugador2 = new Jugador("Juan", Algoformer.MODO_DECEPTICON, tablero);
        Juego juego = new Juego(jugador1, jugador2);
        
        
    	TableroControlador tableroControlador = new TableroControlador(juego);
        JuegoVista juegoVista = new JuegoVista();
        juegoVista.mostrar(tableroControlador);

    }

}
