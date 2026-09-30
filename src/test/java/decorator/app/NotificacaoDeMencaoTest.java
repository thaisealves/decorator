package decorator.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificacaoDeMencaoTest {

    @Test
    void deveNotificarMencionadosUmaUnicaVez() {
        Publicador publicador = new NotificacaoDeMencao(new PublicadorComentario());
        assertEquals("Comentário publicado. Notificado: Hugo, Carla.",
                publicador.publicar("Thai", "@Hugo e @Carla, olha isso! @Hugo"));
    }

    @Test
    void naoDeveNotificarOProprioAutor() {
        Publicador publicador = new NotificacaoDeMencao(new PublicadorComentario());
        assertEquals("Comentário publicado.", publicador.publicar("Thai", "Nota pra mim, @Thai"));
    }

    @Test
    void naoDeveNotificarSemMencao() {
        Publicador publicador = new NotificacaoDeMencao(new PublicadorComentario());
        assertEquals("Comentário publicado.", publicador.publicar("Thai", "Que capítulo!"));
    }
}
