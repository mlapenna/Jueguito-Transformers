package fiuba.algo3.modelo;


public class Ataque {

    public Ataque(Tablero tablero, Posicion posicionOrigen, Posicion posicionDestino) {
        if (tablero.getCasillero( posicionOrigen).hayAlgoformer() && tablero.getCasillero( posicionDestino).hayAlgoformer() ) {

            Algoformer algoformer1 = tablero.getCasillero(posicionOrigen).getAlgoformer();
            Algoformer algoformer2 = tablero.getCasillero(posicionDestino).getAlgoformer();

            int distanciaEntrePosiciones = posicionOrigen.getDistancia(posicionDestino);

            if (algoformer1.getDistanciaDeAtaque() >= distanciaEntrePosiciones && algoformer1.puedeAtacarA(algoformer2) ) {

                int nuevaVida = 0;

                if (algoformer1.getVida() >= algoformer2.getAtaque()) {
                    nuevaVida = algoformer2.getVida() - algoformer1.getAtaque();
                }
                algoformer2.setVida(nuevaVida);
            }
        }
    }
}
