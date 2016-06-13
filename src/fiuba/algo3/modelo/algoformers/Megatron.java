package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.algoformers.Decepticon;
import fiuba.algo3.modelo.movimientos.MovimientoAlternoAereo;
import fiuba.algo3.modelo.movimientos.MovimientoHumanoide;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsAlternoExcepcion;

public class Megatron extends Decepticon {
	private static final int ATAQUE_HUMANOIDE = 10;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 3;
	private static final int VELOCIDAD_HUMANOIDE = 1;
	private static final int ATAQUE_ALTERNO = 55;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 2;
	private static final int VELOCIDAD_ALTERNO = 8;
	private static final int VIDA = 550;
	
	public Megatron(Posicion posicion, Tablero tablero) {
		super(posicion, tablero);
		this.vida = VIDA;
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.movimiento = new MovimientoHumanoide();
	}
	
 	public void transformarHumanoide() {
 		this.validarQueNoSoyHumanoide();
		this.movimiento = new MovimientoHumanoide();
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.modo = MODO_HUMANOIDE;
	}
	
	public void transformarAlterno(){
		this.validarQueNoSoyAlterno();
		this.movimiento = new MovimientoAlternoAereo();
		this.ataque = ATAQUE_ALTERNO;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad = VELOCIDAD_ALTERNO;
		this.modo = 1;
	}
	
	@Override
	public Algoformer clonarAlgoformer() {
		Algoformer clon = new Megatron(this.getPosicion(),this.tablero);
		this.copiarA(clon);
		return clon;	
	}

}
