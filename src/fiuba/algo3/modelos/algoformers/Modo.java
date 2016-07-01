package fiuba.algo3.modelos.algoformers;


import fiuba.algo3.modelos.Posicion;
import fiuba.algo3.modelos.Tablero;
import fiuba.algo3.modelos.movimientos.Movimiento;
import fiuba.algo3.modelos.movimientos.MovimientoHumanoide;


public abstract class Modo {
    protected final Tablero tablero;
    protected Algoformer algoformer;
    protected Movimiento movimiento;
    protected int ataque;

    public Modo(Algoformer algoformer, Tablero tablero) {
        this.algoformer = algoformer;
        this.movimiento = new MovimientoHumanoide(tablero);
        this.tablero = tablero;
        this.ataque = this.getAtaqueInicial();
    }

    public boolean esHumanoide() {
        return false;
    }

    public boolean esAlterno() {
        return false;
    }

    public abstract int getAtaqueInicial();
    public abstract int getDistanciaAtaque();
    public abstract int getVelocidad();
    public abstract int getVida();
    
    public void mover(Posicion posicion) {
        this.movimiento.mover(this.algoformer, posicion);
    }

	public int getAtaque() {
		return this.ataque;
	}

	public void afectarAtaque(int nuevoAtaque) {
		this.ataque = nuevoAtaque;
	}

	public void eliminar(Algoformer algoformer) {
		this.tablero.quitarContenido(algoformer.getPosicion());
		this.movimiento = null;
	}

	public Tablero getTablero() {
		return this.tablero;
	}
}
