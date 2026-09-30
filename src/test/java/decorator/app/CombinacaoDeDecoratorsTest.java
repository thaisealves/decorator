package decorator.app;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinacaoDeDecoratorsTest {

    @Test
    void deveEmpilharTodosOsDecoratorsNoComentarioDeTextoDoClube() {
        PublicadorComentario base = new PublicadorComentario();
        Publicador publicador = new NotificacaoDeMencao(
                new CompartilhamentoMundoAberto(base));
        assertEquals("Comentário publicado. Compartilhado no mundo aberto. Notificado: Hugo.",
                publicador.publicar("Thai", "@Hugo, que final!"));
        assertEquals(List.of("Thai: @Hugo, que final!"), base.getComentarios());
    }

    @Test
    void deveMontarSoOsDecoratorsNecessariosParaComentarioDeAudio() {
        Publicador publicador = new NotificacaoDeMencao(
                new CompartilhamentoMundoAberto(
                        new PublicadorComentario()));
        assertEquals("Comentário publicado. Compartilhado no mundo aberto.",
                publicador.publicar("Thai", "[áudio de 42s]"));
    }

    @Test
    void deveMudarOResultadoConformeAOrdemDosDecorators() {
        Publicador publicador = new CompartilhamentoMundoAberto(
                new NotificacaoDeMencao(
                        new PublicadorComentario()));
        assertEquals("Comentário publicado. Notificado: Hugo. Compartilhado no mundo aberto.",
                publicador.publicar("Thai", "@Hugo, que final!"));
    }
}
