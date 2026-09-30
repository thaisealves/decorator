package decorator.app;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PublicadorComentarioTest {

    @Test
    void devePublicarComentarioSemDecorator() {
        PublicadorComentario publicador = new PublicadorComentario();
        assertEquals("Comentário publicado.", publicador.publicar("Thai", "Que capítulo!"));
        assertEquals(List.of("Thai: Que capítulo!"), publicador.getComentarios());
    }
}
