package mx.florinda.cardapio;


import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        ItemCardapio item = database.itemCardapioPorId(1L).orElseThrow();
        System.out.printf("'%s': R$ %.2f\n", item.nome(), item.preco());

        boolean alterado1 = database.alteraPrecoItemCardapio(1L, new BigDecimal("3.99"));
        System.out.printf("%s\n", alterado1 ? "Preço alterado 1" : "Não encontrado.");

        boolean alterado2 = database.alteraPrecoItemCardapio(1L, new BigDecimal("2.99"));
        System.out.printf("%s\n", alterado2 ? "Preço alterado 2" : "Não encontrado.");

        boolean alterado3 = database.alteraPrecoItemCardapio(1L, new BigDecimal("4.99"));
        System.out.printf("%s\n", alterado3 ? "Preço alterado 3" : "Não encontrado.");

        database.rastroAuditoriaPrecos();
    }

}
