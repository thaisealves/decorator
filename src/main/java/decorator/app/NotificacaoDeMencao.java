package decorator.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificacaoDeMencao extends PublicadorDecorator {

    private static final Pattern MENCAO = Pattern.compile("@(\\p{L}+)");

    public NotificacaoDeMencao(Publicador publicador) {
        super(publicador);
    }

    public String getComplemento(String autor, String texto) {
        List<String> mencionados = new ArrayList<>();
        Matcher matcher = MENCAO.matcher(texto);
        while (matcher.find()) {
            String nome = matcher.group(1);
            if (!nome.equals(autor) && !mencionados.contains(nome)) {
                mencionados.add(nome);
            }
        }
        if (mencionados.isEmpty()) {
            return "";
        }
        return "Notificado: " + String.join(", ", mencionados) + ".";
    }
}
