package fiuba.algo3.modelo;

public abstract class Autobot extends Algoformer{

	public boolean puedeAtacarA(Algoformer otroAlgoformer) {
		return !otroAlgoformer.esAutobot();
	}

	public boolean esAutobot() {
		return true;
	}

	public boolean esDecepticon() {
		return false;
	}

	public void agregarATablero(){
		//AL TABLERO LE TENGO QUE MANDAR UBICARAUTOBOT(THIS);
	}
}
