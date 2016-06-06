package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Autobot;
import fiuba.algo3.modelo.MovimientoHumanoide;
import fiuba.algo3.modelo.MovimientoAlternoTerrestre;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsAlternoExcepcion;

public class Optimus extends Autobot {
	private static final int ATAQUE_HUMANOIDE = 50;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 2;
	private static final int VELOCIDAD_HUMANOIDE = 2;
	private static final int ATAQUE_ALTERNO = 15;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 4;
	private static final int VELOCIDAD_ALTERNO = 5;
	private static final int VIDA = 500;
	
	public Optimus() {
		this.vida = VIDA;
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.movimiento = new MovimientoHumanoide();
	}
	
	public void transformarHumanoide() {
		if(this.ataque == ATAQUE_HUMANOIDE || this.distanciaDeAtaque == DISTANCIA_ATAQUE_HUMANOIDE || this.velocidad == VELOCIDAD_HUMANOIDE)
			throw new TransformacionIncorresctaYaEsHumanoideExcepcion();
		
		this.movimiento = new MovimientoHumanoide();
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
	}
	
	public void transformarAlterno(){
		if((this.ataque == ATAQUE_ALTERNO) || (this.distanciaDeAtaque == DISTANCIA_ATAQUE_ALTERNO) || (this.velocidad == VELOCIDAD_ALTERNO))
			throw new TransformacionIncorresctaYaEsAlternoExcepcion();

		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque = ATAQUE_ALTERNO;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad = VELOCIDAD_ALTERNO;
	}

}
