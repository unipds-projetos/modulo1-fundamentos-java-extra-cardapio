package mx.florinda.cardapio;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static mx.florinda.cardapio.ItemCardapio.CategoriaCardapio.BEBIDAS;

public class Main {
    public static void main(String[] args) {
        ItemCardapio refrescoDoChaves = new ItemCardapio(1L, "Refresco do Chaves", """
                Suco de limão que parece tamarindo e tem gosto de groselha
                """, BEBIDAS,
                new BigDecimal("2.99"), null);

        Gson gson = new Gson();
        String json = gson.toJson(refrescoDoChaves);
        System.out.println(json);

        Database database = new Database();
        List<ItemCardapio> itens = database.listaItensCardapio();

        Comparator<ItemCardapio.CategoriaCardapio> categoriaComparator = Comparator.comparing(ItemCardapio.CategoriaCardapio::name);

        Set<ItemCardapio.CategoriaCardapio> categoriasUnicas = new TreeSet<>();
        for (ItemCardapio item : itens) {
            categoriasUnicas.add(item.categoria());
        }
        for (ItemCardapio.CategoriaCardapio categoria : categoriasUnicas) {
            System.out.println(categoria);
        }

        System.out.println("------------");

        itens.stream()
                .map(ItemCardapio::categoria)
                .collect(Collectors.toCollection(() -> new TreeSet<>(categoriaComparator)))
                .forEach(System.out::println);

        System.out.println("============");

        Map<ItemCardapio.CategoriaCardapio, Integer> itensPorCategoria = new TreeMap<>();
        for (ItemCardapio item : itens) {
            int quantidade;
            if (itensPorCategoria.containsKey(item.categoria())) {
                quantidade = itensPorCategoria.get(item.categoria()) + 1;
            } else {
                quantidade = 1;
            }
            itensPorCategoria.put(item.categoria(), quantidade);
        }
        for (ItemCardapio.CategoriaCardapio categoria : itensPorCategoria.keySet()) {
            Integer quantidade = itensPorCategoria.get(categoria);
            System.out.printf("%s: %d\n", categoria, quantidade);
        }

        System.out.println("------------");

        itens.stream()
                .collect(Collectors.groupingBy(
                        ItemCardapio::categoria,
                        TreeMap::new,
                        Collectors.counting()
                ))
                .forEach((categoria, quantidade) ->
                        System.out.printf("%s: %d\n", categoria, quantidade));

        System.out.println("============");

        Long id = 1L;

        Optional<ItemCardapio> optionalItemCardapio = database.itemCardapioPorId(id);
        if (optionalItemCardapio.isPresent()) {
            ItemCardapio itemCardapio = optionalItemCardapio.get();
            System.out.println(itemCardapio);
        } else {
            System.out.printf("Item de id %d não encontrado%n", id);
        }

        System.out.println("------------");

        String mensagem = database.itemCardapioPorId(id)
                .map(ItemCardapio::toString)
                .orElse("Item de id %d não encontrado".formatted(id));
        System.out.println(mensagem);
    }
}
