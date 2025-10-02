import java.util.List;

public class RelatorioVendas {
    public static void gerarRelatorio(List<Veiculo> veiculosVendidos, List<Double> precosCompra) {
        double lucroTotal = 0;
        System.out.println("\n=== RELATÓRIO DE VENDAS ===");
        for (int i = 0; i < veiculosVendidos.size(); i++) {
            Veiculo v = veiculosVendidos.get(i);
            double compra = precosCompra.get(i);
            double lucro = v.getPreco() - compra;
            lucroTotal += lucro;
            System.out.println("Veículo: " + v.modelo + " | Preço Venda: R$" + v.getPreco() + " | Preço Compra: R$" + compra + " | Lucro: R$" + lucro);
        }
        System.out.println("Lucro Total: R$" + lucroTotal);
    }
}