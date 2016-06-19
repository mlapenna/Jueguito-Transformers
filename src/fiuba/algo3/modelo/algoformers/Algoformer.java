package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.Ataque;
import fiuba.algo3.modelo.movimientos.MovimientoHumanoide;
//import javafx.geometry.Pos;


public abstract class Algoformer extends Contenido {
	static public final int MODO_AUTOBOT = 0;
	static public final int MODO_DECEPTICON = 1;
	static final int CANTIDAD_MINIMA_TURNOS_INMOVIL = 0;

	protected int vida;
	protected Posicion posicion;
	protected int turnosInmovil;
	protected Tablero tablero;
	protected boolean afectadoPorTormentaPsionica = false;
	protected Modo modo;


	public Algoformer(Posicion posicion, Tablero tablero) {
		this.posicion = posicion;
		this.tablero = tablero;
		this.modo = new ModoHumanoide(this, tablero);
		this.hayAlgo = true;
	}


	public abstract void validarQueSePuedeAtacar(Algoformer otroAlgoformer);
	
	public boolean esDecepticon() {
		return false;
	}

	public boolean esAutobot() {
		return false;
	}

	public Posicion getPosicion(){  
		return this.posicion;		
	}

	public int getVida() {
		return this.vida;
	}
	
	public int getAtaqueInicial() {
		return this.modo.getAtaqueInicial();
	}

	public int getAtaque() {
		return this.modo.getAtaque();
	}
	
	public int getDistanciaAtaque() {
		return this.modo.getDistanciaAtaque();
	}
	
	public int getVelocidad() {
		return this.modo.getVelocidad();
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void afectarVida(int nuevaVida) {
		this.setVida(nuevaVida);
	}
	
	public void afectarAtaque(int nuevoAtaque) {
		this.modo.afectarAtaque(nuevoAtaque);
	}
	
	public void recibirAtaque(Algoformer algoformerAtacante) {
		int vidaAux = this.getVida() - algoformerAtacante.getAtaque();
		if (vidaAux < 0) vidaAux = 0;
		this.setVida(vidaAux);
	}
	
	public void atacar(Algoformer algoformerObjetivo) {
		Ataque ataque = new Ataque();
		ataque.Ataque(this, algoformerObjetivo);
	}
	

	public void validarQueNoEstaInmovilizado() {
		if (turnosInmovil > CANTIDAD_MINIMA_TURNOS_INMOVIL) {
			throw new AlgoformerInmovilizadoExcepcion();
		}
	}

	public void mover(Posicion posicionDestino) {
		this.validarQueNoEstaInmovilizado();
		this.modo.mover(posicionDestino);
	}

	public void establecerTurnosAtrapado(int turnosAtrapado) {
		this.turnosInmovil = turnosAtrapado;
	}

	public void setNuevaPosicion(Posicion nuevaPosicion) {
		this.posicion.setCoordenadas(nuevaPosicion.getX(), nuevaPosicion.getY());
	}
	
	public void nuevoTurno() {
		if(turnosInmovil>0) turnosInmovil = turnosInmovil -1;
	}
	
	public boolean afectadoPorTormentaPsionica() {
		return this.afectadoPorTormentaPsionica;
	}
	
	public void afectarPorTormentaPsionica() {
		this.afectadoPorTormentaPsionica = true;
	}

	public abstract Algoformer clonarAlgoformer();

	protected int getTurnosInmovil() {
		return this.turnosInmovil;
	}

	protected Modo getModo() {
		return this.modo;
	}
	
	public void copiarA(Algoformer clon){
		clon.afectadoPorTormentaPsionica = this.afectadoPorTormentaPsionica();
		clon.modo = this.getModo();
		clon.turnosInmovil = this.getTurnosInmovil();
		clon.vida = this.getVida();
	}


	public void cambiarModo() {
		if (this.modo.esHumanoide()) {
			this.modo = new ModoAlterno(this, this.tablero);
		} else {
			this.modo = new ModoHumanoide(this, this.tablero);
		}
	}

	public Movimiento getMovimientoHumanoide() {
		return new MovimientoHumanoide(this.tablero);
	}

	public abstract Movimiento getMovimientoAlterno();

	public abstract int getAtaqueInicialHumanoide();
	public abstract int getDistanciaAtaqueHumanoide();
	public abstract int getVelocidadHumanoide();
	public abstract int getAtaqueInicialAlterno();
	public abstract int getDistanciaAtaqueAlterno();
	public abstract int getVelocidadAlterno();
}
