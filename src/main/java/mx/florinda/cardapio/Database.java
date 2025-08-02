package mx.florinda.cardapio;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static mx.florinda.cardapio.ItemCardapio.CategoriaCardapio.*;

public class Database {

    public List<ItemCardapio> listaItensCardapio() {
        List<ItemCardapio> itens = new LinkedList<>();

        var refrescoDoChaves = new ItemCardapio(1L, "Refresco do Chaves",
                "Suco de limão que parece de tamarindo e tem gosto de groselha.",
                BEBIDAS, new BigDecimal("2.99"), null);
        itens.add(refrescoDoChaves);

        var sanduicheDoChaves = new ItemCardapio(2L, "Sanduíche de Presunto do Chaves",
                "Sanduíche de presunto simples, mas feito com muito amor.",
                PRATOS_PRINCIPAIS, new BigDecimal("3.50"), new BigDecimal("2.99"));
        itens.add(sanduicheDoChaves);

        var tortaDaDonaFlorinda = new ItemCardapio(5L, "Torta de Frango da Dona Florinda",
                "Torta de frango com recheio cremoso e massa crocante.",
                PRATOS_PRINCIPAIS, new BigDecimal("12.99"), new BigDecimal("10.99"));
        itens.add(tortaDaDonaFlorinda);

        var pipocaDoQuico = new ItemCardapio(6L, "Pipoca do Quico",
                "Balde de pipoca preparado com carinho pelo Quico.",
                PRATOS_PRINCIPAIS, new BigDecimal("4.99"), new BigDecimal("3.99"));
        itens.add(pipocaDoQuico);

        var aguaDeJamaica = new ItemCardapio(7L, "Água de Jamaica",
                "Água aromatizada com hibisco e toque de açúcar.",
                BEBIDAS, new BigDecimal("2.50"), new BigDecimal("2.00"));
        itens.add(aguaDeJamaica);

        var cafeDaDonaFlorinda = new ItemCardapio(8L, "Café da Dona Florinda",
                "Café forte para começar o dia com energia.",
                BEBIDAS, new BigDecimal("1.99"), new BigDecimal("1.50"));
        itens.add(cafeDaDonaFlorinda);

        var churrosDoChaves = new ItemCardapio(9L, "Churros do Chaves",
                "Churros recheados com doce de leite, clássicos e irresistíveis.",
                SOBREMESA, new BigDecimal("4.99"), new BigDecimal("3.99"));
        itens.add(churrosDoChaves);

        var gelatinaDoNhonho = new ItemCardapio(10L, "Gelatina Colorida do Nhonho",
                "Gelatina de várias cores, a sobremesa favorita do Nhonho.",
                SOBREMESA, new BigDecimal("3.50"), new BigDecimal("2.99"));
        itens.add(gelatinaDoNhonho);

        var boloDaDonaClotilde = new ItemCardapio(11L, "Bolo de Chocolate da Dona Clotilde",
                "Bolo de chocolate com cobertura de brigadeiro.",
                SOBREMESA, new BigDecimal("5.99"), new BigDecimal("4.99"));
        itens.add(boloDaDonaClotilde);

        return itens;
    }

}
