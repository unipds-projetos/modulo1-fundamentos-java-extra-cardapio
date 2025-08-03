package mx.florinda.cardapio;

import java.math.BigDecimal;

public record ItemCardapio(Long id, String nome, String descricao, CategoriaCardapio categoria,
                           BigDecimal preco, BigDecimal precoPromocional) {

    public enum CategoriaCardapio {
        ENTRADAS, PRATOS_PRINCIPAIS, BEBIDAS, SOBREMESA;
    }

    public ItemCardapio alteraPreco(BigDecimal novoPreco) {
        return new ItemCardapio(id, nome, descricao, categoria, novoPreco, precoPromocional);
    }

}
