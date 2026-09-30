package decorator.app;

import java.util.ArrayList;
import java.util.List;

public class PublicadorComentario implements Publicador {

    private List<String> comentarios = new ArrayList<>();

    public List<String> getComentarios() {
        return this.comentarios;
    }

    public String publicar(String autor, String texto) {
        this.comentarios.add(autor + ": " + texto);
        return "Comentário publicado.";
    }
}
