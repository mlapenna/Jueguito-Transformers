package fiuba.algo3.vistas;


import fiuba.algo3.controladores.AlertHandler;
import fiuba.algo3.modelos.excepciones.RuntimeExceptionConMensajes;

public class MostrarAlUsuarioError {

    public MostrarAlUsuarioError(RuntimeExceptionConMensajes excepcion) {
        new AlertHandler(
            excepcion.getExcepcionTitulo(),
            excepcion.getExcepcionHeader(),
            excepcion.getExcepcionContent()
        );
    }
}
