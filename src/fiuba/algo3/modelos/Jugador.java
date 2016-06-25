package fiuba.algo3.modelos;

import fiuba.algo3.modelos.algoformers.*;
import fiuba.algo3.modelos.excepciones.AlgoformersNoAlineadosException;
import fiuba.algo3.modelos.excepciones.CantidadDeAlgoformersInsuficienteException;

import java.util.ArrayList;
import java.util.Iterator;


public class Jugador {

    private String nombre;
    private ArrayList<Algoformer> misAlgoformers;
    private Tablero tablero;
    private int modo;

    public Jugador(String nombre, int modo, Tablero tablero, Turno turno) {
        this.nombre = nombre;
        this.tablero = tablero;
        this.misAlgoformers = new ArrayList<Algoformer>();
        this.modo = modo;
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

                Optimus optimus = new Optimus(posicion1, tablero, turno);
                BumbleBee bumbleBee = new BumbleBee(posicion2, tablero, turno);
                Ratchet ratchet = new Ratchet(posicion3, tablero, turno);

                this.misAlgoformers.add(optimus);
                this.misAlgoformers.add(bumbleBee);
                this.misAlgoformers.add(ratchet);

                break;
            case Algoformer.MODO_DECEPTICON:
                // Esquina inferior derecha
                posicion1 = new Posicion(this.tablero.getDimensionX() - 1, this.tablero.getDimensionY() - 5);
                posicion2 = new Posicion(this.tablero.getDimensionX() - 1, this.tablero.getDimensionY() - 3);
                posicion3 = new Posicion(this.tablero.getDimensionX() - 1, this.tablero.getDimensionY() - 1);

                Megatron megatron = new Megatron(posicion1, tablero, turno);
                Bonecrusher bonecrusher = new Bonecrusher(posicion2 ,tablero, turno);
                Frenzy frenzy = new Frenzy(posicion3, tablero, turno);

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
    	
    	if(misAlgoformers.size()<3)
    		throw new CantidadDeAlgoformersInsuficienteException();
    	
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
    			this.misAlgoformers.add(new Superion(posicionDelMedio,this.tablero,turno));break;
    		case(Algoformer.MODO_DECEPTICON):
    			this.misAlgoformers.add(new Menasor(posicionDelMedio,this.tablero,turno));break;
    	}
    	this.misAlgoformers.get(0).afectarVida(contadorDeVida); //HARDCODE
    }
    
    public Tablero tablero(){ //es para un test en integracion, se puede eliminar y cambiar el test
    	return this.tablero;
    }


	public boolean noLeQuedanAlgoformers() {
		return (this.getAlgoformers().size() == 0);
	}


	public void gano() {
		
	}

    public void chequearJuegoTerminado(Jugador otroJugador) {
        if (this.noLeQuedanAlgoformers())
        	otroJugador.gano();
        
    	Iterator<Algoformer> algoformers = this.getAlgoformersIterator();
        while (algoformers.hasNext()) 
        	if (algoformers.next().tieneLaChispa())
        		this.gano();
	}
}