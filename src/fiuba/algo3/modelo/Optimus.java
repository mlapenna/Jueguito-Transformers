package fiuba.algo3.modelo;

public class Optimus extends Autobot {
	private static final int ataqueOptimusHumanoide = 50;
	private static final int distanciaAtaqueOptimusHumanoide = 2;
	private static final int VelocidadOptimusHumanoide = 2;
	private static final int ataqueOptimusAlterno = 15;
	private static final int distanciaAtaqueOptimusAlterno = 4;
	private static final int VelocidadOptimusAlterno = 2;
	
	public Optimus(){
		this.vida = 500;
		this.modo = modoHumanoide;
		this.nombre = "optimus"; //CREAR CTE
	}
	private int ataque = ataqueOptimusHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueOptimusHumanoide;
	private int Velocidad = VelocidadOptimusHumanoide;
	
	public void transformarHumanoide() {
		this.modo=modoHumanoide;
		this.ataque=ataqueOptimusHumanoide;
		this.distanciaDeAtaque=distanciaAtaqueOptimusHumanoide;
		this.Velocidad=VelocidadOptimusHumanoide;
	}
	
	public void transformarAlterno(){
		this.modo=modoAlterno;
		this.ataque=ataqueOptimusAlterno;
		this.distanciaDeAtaque=distanciaAtaqueOptimusAlterno;
		this.Velocidad=VelocidadOptimusAlterno;
	}


	public boolean esDelMismoTipoQue(Algoformer unRobot) {
		return unRobot.soyOptimus();
	};

	public boolean soyOptimus() { return true; }
	

}
