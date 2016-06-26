package fiuba.algo3.modelos;

import fiuba.algo3.modelos.algoformers.Algoformer;
import fiuba.algo3.modelos.excepciones.AtaqueInvalidoDistanciaInsuficienteExcepcion;

public class Ataque {

    public void atacar(Algoformer algoformerAtacante, Algoformer algoformerObjetivo) {
    	
    	this.validarAtaque(algoformerAtacante,algoformerObjetivo);
    	algoformerObjetivo.recibirAtaque(algoformerAtacante);
    	
    }
    
    private void validarAtaque(Algoformer algoformerAtacante, Algoformer algoformerObjetivo) {

		Posicion posicionOrigen = algoformerAtacante.getPosicion();
		Posicion posicionDestino = algoformerObjetivo.getPosicion();
		
		algoformerAtacante.validarQueSePuedeAtacar(algoformerObjetivo);
		if (algoformerAtacante.getDistanciaAtaque() < posicionOrigen.getDistancia(posicionDestino)) {
			throw new AtaqueInvalidoDistanciaInsuficienteExcepcion();
        }
	}
}
