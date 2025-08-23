package mx.florinda.cardapio;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

import static mx.florinda.cardapio.ItemCardapio.CategoriaCardapio.*;

public class Database {
    
    private final Map<Long, ItemCardapio> itensPorId = new ConcurrentSkipListMap<>();
    private final Map<ItemCardapio, BigDecimal> auditoriaPrecos = new IdentityHashMap<>();
    
    public Database() {
//        var refrescoDoChaves = new ItemCardapio(1L, "Refresco do Chaves",
//                "Suco de limão que parece de tamarindo e tem gosto de groselha.",
//                BEBIDAS, new BigDecimal("2.99"), null);
//        itensPorId.put(refrescoDoChaves.id(), refrescoDoChaves);
//
//        var sanduicheDoChaves = new ItemCardapio(2L, "Sanduíche de Presunto do Chaves",
//                "Sanduíche de presunto simples, mas feito com muito amor.",
//                PRATOS_PRINCIPAIS, new BigDecimal("3.50"), new BigDecimal("2.99"));
//        itensPorId.put(sanduicheDoChaves.id(), sanduicheDoChaves);
//
//        var tortaDaDonaFlorinda = new ItemCardapio(5L, "Torta de Frango da Dona Florinda",
//                "Torta de frango com recheio cremoso e massa crocante.",
//                PRATOS_PRINCIPAIS, new BigDecimal("12.99"), new BigDecimal("10.99"));
//        itensPorId.put(tortaDaDonaFlorinda.id(), tortaDaDonaFlorinda);
//
//        var pipocaDoQuico = new ItemCardapio(6L, "Pipoca do Quico",
//                "Balde de pipoca preparado com carinho pelo Quico.",
//                PRATOS_PRINCIPAIS, new BigDecimal("4.99"), new BigDecimal("3.99"));
//        itensPorId.put(pipocaDoQuico.id(), pipocaDoQuico);
//
//        var aguaDeJamaica = new ItemCardapio(7L, "Água de Jamaica",
//                "Água aromatizada com hibisco e toque de açúcar.",
//                BEBIDAS, new BigDecimal("2.50"), new BigDecimal("2.00"));
//        itensPorId.put(aguaDeJamaica.id(), aguaDeJamaica);
//
//        var churrosDoChaves = new ItemCardapio(9L, "Churros do Chaves",
//                "Churros recheados com doce de leite, clássicos e irresistíveis.",
//                SOBREMESA, new BigDecimal("4.99"), new BigDecimal("3.99"));
//        itensPorId.put(churrosDoChaves.id(), churrosDoChaves);
    }

    public List<ItemCardapio> listaItensCardapio() {
        return new LinkedList<>(itensPorId.values());
    }

    public Optional<ItemCardapio> itemCardapioPorId(Long id) {
        return Optional.ofNullable(itensPorId.get(id));
    }

    public boolean removeItemCardapio(Long id) {
        ItemCardapio removido = itensPorId.remove(id);
        return removido != null;
    }

    public boolean alteraPrecoItemCardapio(Long id, BigDecimal novoPreco) {
        ItemCardapio item = itensPorId.get(id);
        if (item == null ) return false;
        ItemCardapio itemPrecoAlterado = item.alteraPreco(novoPreco);
        itensPorId.put(id, itemPrecoAlterado);
        auditoriaPrecos.put(item, novoPreco);
        return true;
    }

    public void rastroAuditoriaPrecos() {
        System.out.println("\nAuditoria de preços:");
        auditoriaPrecos.forEach((item, preco) ->
                System.out.printf(" - %s: %s => %s\n", item.nome(), item.preco(), preco));
        System.out.println();
    }

    public int totalItensCardapio() {
        return itensPorId.size();
    }

    public void adicionaItemCardapio(ItemCardapio item) {
        itensPorId.put(item.id(), item);
    }
}
