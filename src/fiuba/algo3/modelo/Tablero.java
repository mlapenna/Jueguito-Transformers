package fiuba.algo3.modelo;
import java.util.Random;

public class Tablero {
	static final int columnas = 30;
	static final int filas = 20;
	private Casillero[][] casilleros = new Casillero[filas][columnas];
	
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
		this.casilleros[i][columnas-1].agregarAlgoformer(decepticon);
	}
	
	public void moverAlgoformer(){
		
	}
}
