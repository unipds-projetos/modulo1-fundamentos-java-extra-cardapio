package mx.florinda.cardapio;

import com.google.gson.Gson;

import java.math.BigDecimal;

import static mx.florinda.cardapio.ItemCardapio.CategoriaCardapio.*;

public class Main {
    public static void main(String[] args) {
        ItemCardapio refrescoDoChaves = new ItemCardapio(1L, "Refresco do Chaves", """
                Suco de limão que parece tamarindo e tem gosto de groselha
                """, BEBIDAS,
                new BigDecimal("2.99"), null);

        Gson gson = new Gson();
        String json = gson.toJson(refrescoDoChaves);

        System.out.println(json);
    }
}
