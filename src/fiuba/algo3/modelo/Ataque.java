package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.algoformers.Algoformer;

public class Ataque {

    public Ataque(Tablero tablero, Posicion posicionOrigen, Posicion posicionDestino) {
    	
    	/*Casillero casilleroOrigen = tablero.getCasillero( posicionOrigen);
    	Casillero casilleroDestino = tablero.getCasillero( posicionDestino);
    	
        if (casilleroOrigen.hayAlgoformer() && casilleroDestino.hayAlgoformer() ) {

            Algoformer algoformer1 = casilleroOrigen.getAlgoformer();
            Algoformer algoformer2 = casilleroDestino.getAlgoformer();

            int distanciaEntrePosiciones = posicionOrigen.getDistancia(posicionDestino);

            if (algoformer1.getDistanciaDeAtaque() >= distanciaEntrePosiciones && algoformer1.puedeAtacarA(algoformer2) ) {
                algoformer2.recibirAtaque(algoformer1);
            }
        }*/
    }
}
