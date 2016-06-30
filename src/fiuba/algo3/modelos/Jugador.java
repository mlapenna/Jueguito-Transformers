package fiuba.algo3.modelos;

import fiuba.algo3.modelos.algoformers.*;
import fiuba.algo3.modelos.excepciones.AlgoformersNoAlineadosException;
import fiuba.algo3.modelos.excepciones.CantidadDeAlgoformersInsuficienteException;
import fiuba.algo3.modelos.excepciones.NoEsElTurnoDelJugadorExcepcion;

import java.util.ArrayList;
import java.util.Iterator;


public class Jugador {

    private String nombre;
    private ArrayList<Algoformer> misAlgoformers;
    private int modo;
    private Juego juego;

    public Jugador(String nombre, int modo, Turno turno, Juego juego) {
        this.nombre = nombre;
        this.misAlgoformers = new ArrayList<Algoformer>();
        this.modo = modo;
        this.juego = juego;
        this.agregarAlgoformersAlTablero(modo, turno);
    }


    private void agregarAlgoformersAlTablero(int modo, Turno turno) {
        Posicion posicion1;
        Posicion posicion2;
        Posicion posicion3;

        switch (modo) {
            case Algoformer.MODO_AUTOBOT:
                // Esquina superior izquierda
                posicion1 = new Posicion(0, 0);
                posicion2 = new Posicion(0, 2);
                posicion3 = new Posicion(0, 4);

                Optimus optimus = new Optimus(posicion1, this.juego.getTablero(), turno);
                BumbleBee bumbleBee = new BumbleBee(posicion2, this.juego.getTablero(), turno);
                Ratchet ratchet = new Ratchet(posicion3, this.juego.getTablero(), turno);

                this.misAlgoformers.add(optimus);
                this.misAlgoformers.add(bumbleBee);
                this.misAlgoformers.add(ratchet);

                break;
            case Algoformer.MODO_DECEPTICON:
                // Esquina inferior derecha
                posicion1 = new Posicion(this.juego.getTablero().getDimensionX() - 1, this.juego.getTablero().getDimensionY() - 5);
                posicion2 = new Posicion(this.juego.getTablero().getDimensionX() - 1, this.juego.getTablero().getDimensionY() - 3);
                posicion3 = new Posicion(this.juego.getTablero().getDimensionX() - 1, this.juego.getTablero().getDimensionY() - 1);

                Megatron megatron = new Megatron(posicion1, this.juego.getTablero(), turno);
                Bonecrusher bonecrusher = new Bonecrusher(posicion2 ,this.juego.getTablero(), turno);
                Frenzy frenzy = new Frenzy(posicion3, this.juego.getTablero(), turno);

                this.misAlgoformers.add(megatron);
                this.misAlgoformers.add(bonecrusher);
                this.misAlgoformers.add(frenzy);

                break;
        }

    }


    public Iterator<Algoformer> getAlgoformersIterator() {
        return this.misAlgoformers.iterator();
    }
    
    public ArrayList<Algoformer> getAlgoformers(){
    	return this.misAlgoformers;
    }


    public boolean algoformerEsMio(Algoformer algoformer) {
        boolean esMio = false;

        Iterator<Algoformer> misAlgoformers = this.misAlgoformers.iterator();

        while (misAlgoformers.hasNext() && !esMio) {
            esMio = misAlgoformers.next() == algoformer;
        }

        return esMio;
    }
    
    public void combinarAlgoformers(Turno turno) throws AlgoformersNoAlineadosException, CantidadDeAlgoformersInsuficienteException {
    	    	
    	if(this.misAlgoformers.size()<3)
    		throw new CantidadDeAlgoformersInsuficienteException();
    	
    	if(this.misAlgoformers.get(0).getTurno().getJugadorDelQueEsElTurno() != this)
    		throw new NoEsElTurnoDelJugadorExcepcion(); //ESTE IF VA ARRIBA Y ESTA MAL; LO PONGO ACA POR SI NO ESTA EL GET(0)
    	
    	ArrayList<Posicion> posicion = new ArrayList<Posicion>();
    	for (int i=0; i<this.misAlgoformers.size(); i++)
    		posicion.add(this.misAlgoformers.get(i).getPosicion());
    	if(!posicion.get(0).sePuedenCombinar(posicion.get(1),posicion.get(2)))
    		throw new AlgoformersNoAlineadosException();

    	Posicion posicionDelMedio = posicion.get(0).posicionDelMedioVertical(posicion.get(1),posicion.get(2));
    	int contadorDeVida = 0;
    	
    	Iterator<Algoformer> algoformers = this.getAlgoformersIterator();
    	while(algoformers.hasNext()){
    		Algoformer actual = algoformers.next();
    		contadorDeVida = contadorDeVida + actual.getVida();
    		actual.eliminar();
    	}
    	this.misAlgoformers.clear();
    	
    	switch(this.modo){
    		case(Algoformer.MODO_AUTOBOT):
    			this.misAlgoformers.add(new Superion(posicionDelMedio,this.juego.getTablero(),turno));break;
    		case(Algoformer.MODO_DECEPTICON):
    			this.misAlgoformers.add(new Menasor(posicionDelMedio,this.juego.getTablero(),turno));break;
    	}
    	this.misAlgoformers.get(0).afectarVida(contadorDeVida); //HARDCODE
    	this.misAlgoformers.get(0).siguienteTurno();
    }
    
	public boolean noLeQuedanAlgoformers() {
		Iterator<Algoformer> algoformers = this.getAlgoformersIterator();
		boolean perdio = true;
		while(algoformers.hasNext())
			if(algoformers.next().estaVivo())
				perdio = false;
		return perdio;
	}

    public boolean chequearJuegoTerminado(Jugador otroJugador) {
        if (otroJugador.noLeQuedanAlgoformers()){
        	this.juego.gano(this);
        	return true;
        }
    	Iterator<Algoformer> algoformers = this.getAlgoformersIterator();
        while (algoformers.hasNext()) 
        	if (algoformers.next().tieneLaChispa()){
        		this.juego.gano(this);
        		return true;
        	}
        return false;
	}

	public String nombre() {
		return this.nombre;
	}
	

	public void eliminar() {
		/*Iterator<Algoformer> misAlgoformers = this.getAlgoformersIterator();
		while(misAlgoformers.hasNext())
			misAlgoformers.next().eliminar();*/    //ESTA PARTE BORRA A LOS ALGOFORMERS; PERO LOS QUE MURIERON YA ESTAN BORRADOS Y HAY NULL POINTER

		this.misAlgoformers = null;
		this.juego = null;
	}
}