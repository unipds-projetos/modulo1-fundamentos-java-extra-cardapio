package mx.florinda.cardapio;


import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        ItemCardapio item = database.itemCardapioPorId(1L).orElseThrow();
        System.out.printf("'%s': R$ %.2f\n", item.nome(), item.preco());

        boolean alterado = database.alteraPrecoItemCardapio(1L, new BigDecimal("3.99"));
        System.out.printf("%s\n", alterado ? "Preço alterado." : "Não encontrado.");

        ItemCardapio itemAlterado = database.itemCardapioPorId(1L).orElseThrow();
        System.out.printf("'%s': R$ %.2f\n", itemAlterado.nome(), itemAlterado.preco());
    }

}
