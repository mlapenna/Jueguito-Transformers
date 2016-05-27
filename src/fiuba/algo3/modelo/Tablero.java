package fiuba.algo3.modelo;
import java.util.Random;

public class Tablero {
	private Casillero[][] casilleros = new Casillero[20][30];
	
	public void ubicarAutobot(Autobot autobot){
		Random rnd = new Random();
		int i = (int)(rnd.nextDouble()*20);
		//VER SI CASILLERO ESTA OCUPADO
		this.casilleros[i][0].agregarAlgoformer(autobot);
	}
	
	public void ubicarDecepticon(Decepticon decepticon){
		Random rnd = new Random();
		int i = (int)(rnd.nextDouble()*20);
		//VER SI CASILLERO ESTA OCUPADO
		this.casilleros[i][29].agregarAlgoformer(decepticon);
	}
	
	public void moverAlgoformer(){
		
	}
}
