package mx.florinda.cardapio;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
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
                .collect(Collectors.toCollection(() -> new TreeSet<>(categoriaComparator)))
                .forEach(System.out::println);



    }
}
