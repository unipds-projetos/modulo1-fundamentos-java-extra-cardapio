package mx.florinda.cardapio;


import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        ItemCardapio item = database.itemCardapioPorId(1L).orElseThrow(); // 2.99

        database.alteraPrecoItemCardapio(1L, new BigDecimal("3.99")); // 2.99 => 3.99
        ItemCardapio item1 = database.itemCardapioPorId(1L).orElseThrow(); // 3.99

        database.alteraPrecoItemCardapio(1L, new BigDecimal("2.99")); // 3.99 => 2.99
        ItemCardapio item2 = database.itemCardapioPorId(1L).orElseThrow(); // 2.99

        database.alteraPrecoItemCardapio(1L, new BigDecimal("4.99")); // 2.99 => 4.99
        ItemCardapio item3 = database.itemCardapioPorId(1L).orElseThrow(); // 4.99

        System.out.println("== " + (item == item2));
        System.out.println("equals() " + (item.equals(item2)));
        System.out.println("hashCode() " + (item.hashCode() == item2.hashCode()));

        database.rastroAuditoriaPrecos();
    }

}
