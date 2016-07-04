package fiuba.algo3.modelos.algoformers;

import fiuba.algo3.modelos.*;
import fiuba.algo3.modelos.excepciones.AlgoformerCombinadoNoPuedeTransformarseExcepcion;
import fiuba.algo3.modelos.excepciones.NoEsElTurnoDelJugadorExcepcion;
import fiuba.algo3.modelos.movimientos.Movimiento;
import fiuba.algo3.modelos.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelos.movimientos.MovimientoHumanoide;

public abstract class Algoformer extends Contenido {
	static public final int MODO_AUTOBOT = 0;
	static public final int MODO_DECEPTICON = 1;
	public static final String nombreAlgoformer = "";
	
	protected int vida;
	protected Posicion posicion;
	protected int turnosInmovil;
	protected boolean afectadoPorTormentaPsionica = false;
	protected Modo modo;
	protected int ataqueAfectado;
	protected Turno turno;
	protected boolean movimientoDisminuido;
	private boolean tieneLaChispa;
	private boolean muerto;

	public Algoformer(Posicion posicion, Tablero tablero, Turno turno) {
		this.posicion = posicion;
		tablero.setContenido(posicion, this);

		this.modo = new ModoHumanoide(this, tablero);
		this.hayAlgo = true;
		this.turno = turno;
		this.movimientoDisminuido = false;
		this.tieneLaChispa = false;
		this.muerto = false;
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
		this.ataqueAfectado = nuevoAtaque;
	}
	
	public void recibirAtaque(Algoformer algoformerAtacante) {
		int vidaAux = this.getVida() - algoformerAtacante.getAtaque();
		if (vidaAux <= 0){
			this.eliminar();
			return;
		}
		this.setVida(vidaAux);
	}


	public void atacar(Algoformer algoformerObjetivo) {
		this.validarQueEsMiTurno();
		Ataque ataque = new Ataque();
		ataque.atacar(this, algoformerObjetivo);
		this.turno.siguiente();
	}
	

	public void validarQueNoEstaInmovilizado() {
		if (turnosInmovil > 0) {
			throw new AlgoformerInmovilizadoExcepcion();
		}
	}

	public void mover(Posicion posicionDestino) {
		this.validarQueEsMiTurno();
		this.validarQueNoEstaInmovilizado();
		try{
			this.modo.mover(posicionDestino);
		}
		catch(AlgoformerInmovilizadoExcepcion exception){
			this.turno.siguiente();
			throw new AlgoformerQuedoInmovilizadoExcepcion();
		}
		this.turno.siguiente();
	}

	private void validarQueEsMiTurno() {
		if (!this.turno.puedeJugar(this)) {
			throw new NoEsElTurnoDelJugadorExcepcion();
		}
	}

	public void establecerTurnosAtrapado(int turnosAtrapado) {
		this.turnosInmovil = turnosAtrapado + 1;
	}

	public void setNuevaPosicion(Posicion nuevaPosicion) {
		this.posicion.setCoordenadas(nuevaPosicion.getX(), nuevaPosicion.getY());
	}
	
	public void nuevoTurno() {
		if (turnosInmovil > 0){
			turnosInmovil--;
		}
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

	public Modo getModo() {
		return this.modo;
	}
	
	public void copiarA(Algoformer clon){
		clon.afectadoPorTormentaPsionica = this.afectadoPorTormentaPsionica();
		clon.modo = this.getModo();
		clon.turnosInmovil = this.getTurnosInmovil();
		clon.vida = this.getVida();
	}


	public void cambiarModo() {
		this.validarQueEsMiTurno();
		if (this.esUnRobotCombinado()) {
			throw new AlgoformerCombinadoNoPuedeTransformarseExcepcion();
		}

		if (this.modo.esHumanoide()) {
			this.modo = new ModoAlterno(this, this.modo.getTablero());
			if (this.afectadoPorTormentaPsionica())
				this.afectarAtaque(this.ataqueAfectado());
		} else {
			this.modo = new ModoHumanoide(this, this.modo.getTablero());
		}

		this.siguienteTurno();
	}
	
	public void siguienteTurno(){
		this.turno.siguiente();
	}

	private int ataqueAfectado() {
		return this.ataqueAfectado;
	}


	public Movimiento getMovimientoHumanoide(Tablero tablero) {
		return new MovimientoHumanoide(tablero);
	}

	public abstract Movimiento getMovimientoAlterno();

	public abstract int getAtaqueInicialHumanoide();
	public abstract int getDistanciaAtaqueHumanoide();
	public abstract int getVelocidadHumanoide();
	public abstract int getAtaqueInicialAlterno();
	public abstract int getDistanciaAtaqueAlterno();
	public abstract int getVelocidadAlterno();
	public abstract int getVidaInicial();

	public void disminuirMovimientoEsteTurno() {
		this.movimientoDisminuido = true;
	}


	public boolean movimientoDisminuido() {
		return this.movimientoDisminuido;
	}


	public void normalizarMovimiento() {
		this.movimientoDisminuido = false;
	}


	public void eliminar() {
		this.modo.eliminar(this);
		//this.modo = null;
		//this.posicion = null;
		//this.turno = null;
		this.muerto = true;
	}

	public void setTieneLaChispa(){
		this.tieneLaChispa = true;
	}
	
	public boolean getTieneLaChispa(){
		return this.tieneLaChispa;
	}


	public Turno getTurno() {
		return this.turno;
	}


	public boolean estaVivo() {
		return !(this.muerto);
	}
	
	public abstract String getNombre();

	public boolean esUnRobotCombinado() {
		return false;
	}

}
