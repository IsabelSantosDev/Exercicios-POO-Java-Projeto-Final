import java.util.ArrayList;
import java.util.List;

public class Concessionaria {
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo v) {
        veiculos.add(v);
    }

    public void cadastrarCliente(Cliente c) {
        clientes.add(c);
    }

    public void exibirVeiculos() {
        System.out.println("\n=== VEÍCULOS CADASTRADOS ===");
        for (Veiculo v : veiculos) {
            v.imprimirInformacoes();
        }
    }

    public void venderVeiculo(String modelo, String nomeCliente, double precoCompra, double precoVenda)
            throws VeiculoNaoEncontradoException, ClienteNaoEncontradoException, PrecoInvalidoException {
        Veiculo veiculoEncontrado = null;
        for (Veiculo v : veiculos) {
            if (v.getModelo().equalsIgnoreCase(modelo)) {
                veiculoEncontrado = v;
                break;
            }
        }
        if (veiculoEncontrado == null) {
            throw new VeiculoNaoEncontradoException("Veículo " + modelo + " não encontrado!");
        }

        Cliente clienteEncontrado = null;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                clienteEncontrado = c;
                break;
            }
        }

        if (clienteEncontrado == null) {
            throw new ClienteNaoEncontradoException("Cliente " + nomeCliente + " não encontrado!");
        }

        if (precoCompra <= 0 || precoVenda <= 0) {
            throw new PrecoInvalidoException("Preços de compra e venda devem ser maiores que zero!");
        }

        double lucro = precoVenda - precoCompra;

        System.out.println("\n✅ Venda realizada com sucesso!");
        System.out.println("Veículo: " + veiculoEncontrado.getModelo() + " (" + veiculoEncontrado.getAno() + ")");
        System.out.println("Cliente: " + clienteEncontrado.getNome());
        System.out.println("Preço de compra: R$" + precoCompra);
        System.out.println("Preço de venda: R$" + precoVenda);
        System.out.println("Resultado financeiro: " + (lucro >= 0 ? "Lucro de R$" + lucro : "Prejuízo de R$" + lucro));

        vendas.add(new Venda(veiculoEncontrado, clienteEncontrado, precoCompra, precoVenda));
        
        veiculos.remove(veiculoEncontrado);

        System.out.println("Venda realizada com sucesso!");
    }

    public void exibirClientes() {
        System.out.println("\n=== CLIENTES CADASTRADOS ===");
        for (Cliente c : clientes) {
            c.imprimirInformacoes();
        }
    }

    public void gerarRelatorioVendas() {
        System.out.println("\n===== RELATÓRIO =====");
        System.out.println("Clientes cadastrados:");
        for (Cliente c : clientes) {
            System.out.println("- " + c.getNome() + " (" + c.getBiotipo() + ")");
        }
        System.out.println("\nVeículos cadastrados:");
        for (Veiculo v : veiculos) {
            System.out.println("- " + v.getModelo() + " (" + v.getAno() + ") - R$" + v.getPreco());
        }

        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada ainda.");
        } else {
            for (Venda v : vendas) {
                System.out.println("Veículo: " + v.getVeiculo().getModelo() +
                                   " | Cliente: " + v.getCliente().getNome() +
                                   " | Compra: R$" + v.getPrecoCompra() +
                                   " | Venda: R$" + v.getPrecoVenda() +
                                   " | Resultado: " + 
                                   (v.getLucro() >= 0 ? "Lucro R$" + v.getLucro() : "Prejuízo R$" + v.getLucro()));
            }
        }

        System.out.println("=================================");
    }

    public void sugerirVeiculo(String nomeCliente) {
        Cliente cliente = buscarCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("\nSugestão de veículos para " + cliente.getNome() + " (biotipo: " + cliente.getBiotipo() + "):");

        for (Veiculo v : veiculos) {
            if (cliente.getBiotipo().equalsIgnoreCase("alto") && v.getAno() >= 2020) {
                System.out.println("- " + v.getModelo() + " (" + v.getAno() + ")");
            } else if (cliente.getBiotipo().equalsIgnoreCase("baixo") && v.getPreco() <= 100000) {
                System.out.println("- " + v.getModelo() + " (" + v.getAno() + ")");
            }
        }
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public Cliente buscarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
} 