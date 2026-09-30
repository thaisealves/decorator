package decorator.app;

public class CompartilhamentoMundoAberto extends PublicadorDecorator {

    public CompartilhamentoMundoAberto(Publicador publicador) {
        super(publicador);
    }

    public String getComplemento(String autor, String texto) {
        return "Compartilhado no mundo aberto.";
    }
}
