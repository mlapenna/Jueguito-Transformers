package fiuba.algo3.modelo;

public abstract class Autobot extends Algoformer{

	public boolean puedeAtacarA(Algoformer otroAlgoformer) {
		return !otroAlgoformer.esAutobot();
	}

	public boolean esAutobot() {
		return true;
	}


	public void agregarATablero(){
		//AL TABLERO LE TENGO QUE MANDAR UBICARAUTOBOT(THIS);
	}
}
