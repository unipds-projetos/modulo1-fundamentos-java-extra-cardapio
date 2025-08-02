# Cardápio

Este é um projeto simples em Java que demonstra como utilizar a biblioteca Gson para converter um objeto que representa um item de cardápio em uma string JSON.

## Tecnologias Utilizadas

*   **Java:** Linguagem de programação principal.
*   **Gradle:** Ferramenta de automação de compilação.
*   **Gson:** Biblioteca do Google para trabalhar com JSON em Java.

## Como Executar

Você pode construir e executar o projeto utilizando o Gradle Wrapper fornecido.

**Linux/macOS:**
```bash
./gradlew run
```

**Windows:**
```bash
.\gradlew.bat run
```

## Exemplo de Saída

Ao executar a classe `Main`, a seguinte string JSON será impressa no console:

```json
{
  "id": 1,
  "nome": "Refresco do Chaves",
  "descricao": "Suco de limão que parece tamarindo e tem gosto de groselha",
  "categoria": "BEBIDAS",
  "preco": 2.99
}
```
