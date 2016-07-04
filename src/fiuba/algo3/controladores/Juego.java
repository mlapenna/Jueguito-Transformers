package fiuba.algo3.controladores;


import fiuba.algo3.vistas.JuegoVista;


public class Juego {
	
    public static void main(String[] args) throws Exception {

        JuegoVista juegoVista = new JuegoVista();

        // Paso parámetros a la vista... no es fácil, por extender de Application
        String[] params = new String[3];
        params[JuegoVista.PARAM_MAPA] = "mapas/mapaParaJugar.json";
        params[JuegoVista.PARAM_JUGADOR1] = "Nacho";
        params[JuegoVista.PARAM_JUGADOR2] = "Mariano";

        juegoVista.main(params);
    }

}
