package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.excepciones.MovimientoInvalidoDistanciaNoValidaExcepcion;
import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsAlternoExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.AlgoformerInmovilizadoExcepcion;
import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoFriendlyFireNoEstaHabilitado;
import fiuba.algo3.modelo.excepciones.AtaqueInvalidoDistanciaInsuficienteExcepcion;
//import javafx.geometry.Pos;


public abstract class Algoformer extends Contenido {
	static final int MODO_HUMANOIDE = 0;
	static final int MODO_ALTERNO = 1;
	static public final int MODO_AUTOBOT = 0;
	static public final int MODO_DECEPTICON = 1;
	static final int CANTIDAD_MINIMA_TURNOS_INMOVIL = 0;
	
	protected int vida;
	protected Movimiento movimiento;
	protected Posicion posicion;
	protected int distanciaDeAtaque;
	protected int ataque;
	protected int velocidad;
	protected int modo;
	protected int turnosInmovil = CANTIDAD_MINIMA_TURNOS_INMOVIL;
	protected Tablero tablero;


	public Algoformer(Posicion posicion, Tablero tablero) {
		this.posicion = posicion;
		this.tablero = tablero;
		this.modo = MODO_HUMANOIDE;
	}
	
	public abstract void transformarHumanoide(); //redefinida en cada Algoformer
	
	public abstract void transformarAlterno(); //redefinida en cada Algoformer

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
	
	public int getAtaque() {
		return this.ataque;
	}
	
	public int getDistanciaDeAtaque() {
		return this.distanciaDeAtaque;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	private void recibirAtaque(int ataque) {
		int vidaAux = this.getVida() - ataque;
		if (vidaAux < 0) vidaAux = 0;
		this.setVida(vidaAux);
	}
	
	public void atacar(Algoformer algoformerObjetivo) {
		this.validarAtaque(algoformerObjetivo);
		algoformerObjetivo.recibirAtaque(this.getAtaque());
	}
	
	private void validarAtaque(Algoformer algoformerObjetivo) {
		Posicion posicionOrigen = this.getPosicion();
		Posicion posicionDestino = algoformerObjetivo.getPosicion();
		
		this.validarQueSePuedeAtacar(algoformerObjetivo);
		if (this.getDistanciaDeAtaque() < posicionOrigen.getDistancia(posicionDestino)) {
			throw new AtaqueInvalidoDistanciaInsuficienteExcepcion();
        }
	}	
	
	public void validarQueNoSoyHumanoide() {
		if(this.modo == MODO_HUMANOIDE)
			throw new TransformacionIncorresctaYaEsHumanoideExcepcion();
	}
	
	public void validarQueNoSoyAlterno() {
		if(this.modo == MODO_ALTERNO)
			throw new TransformacionIncorresctaYaEsAlternoExcepcion();
	}
	
	public void validarQueNoEstaInmovilizado() {
		if (turnosInmovil > CANTIDAD_MINIMA_TURNOS_INMOVIL) {
			throw new AlgoformerInmovilizadoExcepcion();
		}
	}

	public void mover(Posicion posicionDestino) {
		this.movimiento.mover(this, this.tablero, posicionDestino);
	}

	public void establecerTurnosAtrapado(int turnosAtrapado) {
		this.turnosInmovil = turnosAtrapado;
	}

}
