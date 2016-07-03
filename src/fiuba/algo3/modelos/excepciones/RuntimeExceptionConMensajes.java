package fiuba.algo3.modelos.excepciones;


public abstract class RuntimeExceptionConMensajes extends RuntimeException  {
    protected String title;
    protected String header;
    protected String content;

    public String getExcepcionTitulo() {
        return this.title;
    }

    public String getExcepcionHeader() {
        return this.header;
    }

    public String getExcepcionContent() {
        return this.content;
    }
}
