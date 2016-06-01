package fiuba.algo3.modelo;

public class Optimus extends Autobot {
	private static final int ataqueOptimusHumanoide = 50;
	private static final int distanciaAtaqueOptimusHumanoide = 2;
	private static final int velocidadOptimusHumanoide = 2;
	private static final int ataqueOptimusAlterno = 15;
	private static final int distanciaAtaqueOptimusAlterno = 4;
	private static final int velocidadOptimusAlterno = 2;
	private static final int VIDAOPTIMUS = 500;
	
	public Optimus(){
		this.vida = VIDAOPTIMUS;
		this.movimiento = new MovimientoHumanoide(); 
	}
	
	private int ataque = ataqueOptimusHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueOptimusHumanoide;
	private int velocidad = velocidadOptimusHumanoide;
	
	public void transformarHumanoide() {
		this.movimiento = new MovimientoHumanoide();
		this.ataque=ataqueOptimusHumanoide;
		this.distanciaDeAtaque=distanciaAtaqueOptimusHumanoide;
		this.velocidad=velocidadOptimusHumanoide;
	}
	
	public void transformarAlterno(){
		this.movimiento = new MovimientoAlterno();
		this.ataque=ataqueOptimusAlterno;
		this.distanciaDeAtaque=distanciaAtaqueOptimusAlterno;
		this.velocidad=velocidadOptimusAlterno;
	}


	public boolean esDelMismoTipoQue(Algoformer unRobot) {
		return unRobot.soyOptimus();
	};

	public boolean soyOptimus() { return true; }
	

}
