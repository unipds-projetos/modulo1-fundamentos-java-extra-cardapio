package mx.florinda.cardapio;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Database database = new Database();

        HistoricoVisualizacao historico = new HistoricoVisualizacao(database);
        historico.registrarVisualizacao(1L); // refresco
        historico.registrarVisualizacao(2L); // sanduiche
        historico.registrarVisualizacao(6L); // pipoca
        historico.registrarVisualizacao(1L); // refresco (de novo)

        historico.listaVisualizacoes();
        historico.totalItensVisualizados();

        long idParaRemover = 1L;
        boolean removido = database.removeItemCardapio(idParaRemover);
        System.out.printf("Item %d %s\n", idParaRemover, (removido ? "removido" : "não encontrado"));
        database.listaItensCardapio().forEach(System.out::println);

        System.out.println("\nSolicitando GC...");
        System.gc();
        Thread.sleep(500); // tempo para o GC agir

        historico.listaVisualizacoes();
        historico.totalItensVisualizados();
    }

}
