package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.algoformers.Algoformer;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoDistanciaInsuficienteExcepcion;

public class Ataque {

    public void Ataque(Algoformer algoformerAtacante, Algoformer algoformerObjetivo) {
    	
    	this.validarAtaque(algoformerAtacante,algoformerObjetivo);
    	algoformerObjetivo.recibirAtaque(algoformerAtacante);
    	
    }
    
    private void validarAtaque(Algoformer algoformerAtacante, Algoformer algoformerObjetivo) {
		Posicion posicionOrigen = algoformerAtacante.getPosicion();
		Posicion posicionDestino = algoformerObjetivo.getPosicion();
		
		algoformerAtacante.validarQueSePuedeAtacar(algoformerObjetivo);
		if (algoformerAtacante.getDistanciaDeAtaque() < posicionOrigen.getDistancia(posicionDestino)) {
			throw new AtaqueInvalidoDistanciaInsuficienteExcepcion();
        }
	}
}
