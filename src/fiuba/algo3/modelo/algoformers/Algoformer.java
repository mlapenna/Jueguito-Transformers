package fiuba.algo3.modelo.algoformers;

import fiuba.algo3.modelo.movimientos.Movimiento;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsAlternoExcepcion;
import fiuba.algo3.modelo.excepciones.TransformacionIncorresctaYaEsHumanoideExcepcion;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.modelo.excepciones.AlgoformerNoEstaHabilitadoParaMoverseExcepcion;
import fiuba.algo3.modelo.Contenido;

public abstract class Algoformer extends Contenido {
	static final String MODO_HUMANOIDE = "humanoide";
	static final String MODO_ALTERNO = "alterno";
	static public final int MODO_AUTOBOT = 0;
	static public final int MODO_DECEPTICON = 1;
	static final int CANTIDAD_MINIMA_TURNOS_INMOVIL = 0;
	
	protected int vida;
	protected Movimiento movimiento;
	protected Posicion posicion;
	protected int distanciaDeAtaque;
	protected int ataque;
	protected int velocidad;
	protected String modo;
	protected int turnosInmovil = CANTIDAD_MINIMA_TURNOS_INMOVIL;
	protected Tablero tablero;


	
	public abstract void transformarHumanoide(); //redefinida en cada Algoformer
	
	public abstract void transformarAlterno(); //redefinida en cada Algoformer

	public abstract boolean puedeAtacarA(Algoformer otroAlgoformer);

	public boolean esDecepticon() {
		return false;
	};

	public boolean esAutobot() {
		return false;
	};


	public Posicion getPosicion(){  
		return this.posicion;		
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
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

	public boolean estaAlAlcance(Posicion posicionFinal) {
		return (this.velocidad >= this.posicion.getDistancia(posicionFinal));
	}

	public void recibirAtaque(Algoformer algoformerQueAtaca) {
		int vidaAux = this.getVida() - algoformerQueAtaca.getAtaque();
		if (vidaAux < 0) vidaAux = 0;
		this.setVida(vidaAux);
	}
	
	public void validarQueNoSoyHumanoide() {
		if(this.modo == MODO_HUMANOIDE)
			throw new TransformacionIncorresctaYaEsHumanoideExcepcion();
	}
	
	public void validarQueNoSoyAlterno() {
		if(this.modo == MODO_ALTERNO)
			throw new TransformacionIncorresctaYaEsAlternoExcepcion();
	}
	
	public boolean validarQuePuedeMoverse() {
		return (turnosInmovil == CANTIDAD_MINIMA_TURNOS_INMOVIL);
	}
	
	public void moverAlgoformer(Posicion posicionDestino) {
		if (!this.validarQuePuedeMoverse())
			throw new AlgoformerNoEstaHabilitadoParaMoverseExcepcion();
		this.tablero.moverAlgoformer(this, posicionDestino);
	}

	public void establecerTurnosAtrapado(int turnosAtrapado) {
		this.turnosInmovil = turnosAtrapado;
	}
}
