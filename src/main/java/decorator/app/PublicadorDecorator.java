package decorator.app;

public abstract class PublicadorDecorator implements Publicador {

    private Publicador publicador;

    public PublicadorDecorator(Publicador publicador) {
        this.publicador = publicador;
    }

    public Publicador getPublicador() {
        return publicador;
    }

    public void setPublicador(Publicador publicador) {
        this.publicador = publicador;
    }

    public abstract String getComplemento(String autor, String texto);

    public String publicar(String autor, String texto) {
        String resultado = this.publicador.publicar(autor, texto);
        String complemento = this.getComplemento(autor, texto);
        if (complemento.isEmpty()) {
            return resultado;
        }
        return resultado + " " + complemento;
    }
}
