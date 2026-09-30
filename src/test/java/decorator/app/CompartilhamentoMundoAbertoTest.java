package decorator.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompartilhamentoMundoAbertoTest {

    @Test
    void deveCompartilharNoMundoAbertoDepoisDePublicar() {
        Publicador publicador = new CompartilhamentoMundoAberto(new PublicadorComentario());
        assertEquals("Comentário publicado. Compartilhado no mundo aberto.", publicador.publicar("Thai", "Que capítulo!"));
    }
}
