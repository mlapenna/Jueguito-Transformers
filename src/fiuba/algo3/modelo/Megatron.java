package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Decepticon;
import fiuba.algo3.modelo.MovimientoAlternoAereo;
import fiuba.algo3.modelo.MovimientoHumanoide;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.TransformacionIncorresctaYaEsAlternoExcepcion;

public class Megatron extends Decepticon {
	private static final int ATAQUE_HUMANOIDE = 10;
	private static final int DISTANCIA_ATAQUE_HUMANOIDE = 3;
	private static final int VELOCIDAD_HUMANOIDE = 1;
	private static final int ATAQUE_ALTERNO = 55;
	private static final int DISTANCIA_ATAQUE_ALTERNO = 2;
	private static final int VELOCIDAD_ALTERNO = 8;
	private static final int VIDA = 550;
	
	public Megatron() {
		this.vida = VIDA;
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.movimiento = new MovimientoHumanoide();
		this.modo = "humanoide";
	}
	
 	public void transformarHumanoide() {
 		this.esHumanoide(this);
		this.movimiento = new MovimientoHumanoide();
		this.ataque = ATAQUE_HUMANOIDE;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_HUMANOIDE;
		this.velocidad = VELOCIDAD_HUMANOIDE;
		this.modo = "humanoide";
	}
	
	public void transformarAlterno(){
		this.esAlterno(this);
		this.movimiento = new MovimientoAlternoAereo();
		this.ataque = ATAQUE_ALTERNO;
		this.distanciaDeAtaque = DISTANCIA_ATAQUE_ALTERNO;
		this.velocidad = VELOCIDAD_ALTERNO;
		this.modo = "alterno";
	}
}
