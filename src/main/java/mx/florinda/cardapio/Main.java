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
        itens.stream()
                .map(ItemCardapio::categoria)
                .collect(Collectors.toCollection(() -> new TreeSet<>()))
                .forEach(System.out::println);

        System.out.println("------------");

        Map<ItemCardapio.CategoriaCardapio, Integer> itensPorCategoria = new HashMap<>();
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
                        HashMap::new,
                        Collectors.counting()
                ))
                .forEach((categoria, quantidade) ->
                        System.out.printf("%s: %d\n", categoria, quantidade));


    }
}
