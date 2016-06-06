package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Autobot;
import fiuba.algo3.modelo.MovimientoHumanoide;
import fiuba.algo3.modelo.MovimientoAlternoTerrestre;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsHumanoide;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsAlterno;

public class BumbleBee extends Autobot {
	private static final int ATAQUE_HUMANOIDE = 40;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 1;
	private static final int VELOCIDAD_HUMANOIDE = 2;
	private static final int ATAQUE_ALTERNO = 20;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 3;
	private static final int VELOCIDAD_ALTERNO = 5;
	private static final int VIDA = 350;
	
	public BumbleBee() {
		this.vida = VIDA;
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.movimiento = new MovimientoHumanoide();
	}
	
  	@Override
	public void transformarHumanoide() {
		if(this.ataque == ATAQUE_HUMANOIDE || this.distanciaDeAtaque == DISTANCIA_ATAQUE_HUMANOIDE || this.velocidad == VELOCIDAD_HUMANOIDE)
			throw new TransformacionIncorresctaYaEsHumanoide();
    	
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad=VELOCIDAD_HUMANOIDE;
	}

	@Override
	public void transformarAlterno() {
		if((this.ataque == ATAQUE_ALTERNO) || (this.distanciaDeAtaque == DISTANCIA_ATAQUE_ALTERNO) || (this.velocidad == VELOCIDAD_ALTERNO))
			throw new TransformacionIncorresctaYaEsAlterno();
		
		this.movimiento = new MovimientoAlternoTerrestre();
		this.ataque=ATAQUE_ALTERNO;
		this.distanciaDeAtaque=DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad=VELOCIDAD_ALTERNO;
	}
}
