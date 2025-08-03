package mx.florinda.cardapio;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoricoVisualizacao {

    private Map<ItemCardapio, LocalDateTime> visualizacoes = new HashMap<>();
    private final Database database;

    public HistoricoVisualizacao(Database database) {
        this.database = database;
    }

    public void registrarVisualizacao(Long itemId) {
        Optional<ItemCardapio> optionalItem = database.itemCardapioPorId(itemId);
        if (optionalItem.isEmpty()) {
            System.out.printf("Item não encontrado: %d", itemId);
            return;
        }
        ItemCardapio itemCardapio = optionalItem.get();
        LocalDateTime agora = LocalDateTime.now();
        visualizacoes.put(itemCardapio, agora);
        System.out.printf("'%s' visualizado em '%s'\n", itemCardapio.nome(), agora);
    }

    public void listaVisualizacoes() {
        if (visualizacoes.isEmpty()) {
            System.out.println("Nenhum item visualizado ainda.");
            return;
        }
        System.out.println("\nHistórico de visualizações:");
        visualizacoes.forEach((item, hora) ->
                System.out.printf(" - '%s' (id %d) em '%s'\n", item.nome(), item.id(), hora));
        System.out.println();
    }

    public void totalItensVisualizados() {
        System.out.printf("Total de itens únicos visualidos: %d\n", visualizacoes.size());
    }

}
