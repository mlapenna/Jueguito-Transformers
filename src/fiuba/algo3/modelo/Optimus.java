package fiuba.algo3.modelo;

public class Optimus extends Autobot{
	private static final int ataqueOptimusHumanoide = 50;
	private static final int distanciaAtaqueOptimusHumanoide = 2;
	private static final int VelocidadOptimusHumanoide = 2;
	private static final int ataqueOptimusAlterno = 15;
	private static final int distanciaAtaqueOptimusAlterno = 4;
	private static final int VelocidadOptimusAlterno = 2;
	
	public Optimus(){
		this.vida = 500;
		this.nombre = "optimus"; //CREAR CTE
	}
	private String modo = modoHumanoide;
	private int ataque = ataqueOptimusHumanoide;
	private int distanciaDeAtaque = distanciaAtaqueOptimusHumanoide;
	private int Velocidad = VelocidadOptimusHumanoide;
	

}
