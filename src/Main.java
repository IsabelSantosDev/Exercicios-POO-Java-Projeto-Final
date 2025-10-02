import java.util.Scanner;

public class Main {
    // helpers para leitura segura
    private static int lerInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido (ex: 120000.00).");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concessionaria cons = new Concessionaria();

        // Cadastro inicial — mantém conforme você queria
        cons.cadastrarVeiculo(new Carro("Toyota Corolla", 2021, 120000, 4));
        cons.cadastrarVeiculo(new Moto("Honda CB500", 2022, 30000, 500));
        cons.cadastrarVeiculo(new NovoVeiculo("Tesla Model 3", 2023, 250000, true));

        cons.cadastrarCliente(new Cliente("Ana", "alto"));
        cons.cadastrarCliente(new Cliente("Bruno", "baixo"));

        int opcao;
        do {
            System.out.println("\n===== MENU CONCESSIONÁRIA =====");
            System.out.println("1 - Cadastrar novo veículo");
            System.out.println("2 - Cadastrar novo cliente");
            System.out.println("3 - Exibir veículos");
            System.out.println("4 - Exibir clientes");
            System.out.println("5 - Sugestão de veículos por biotipo");
            System.out.println("6 - Vender veículo");
            System.out.println("7 - Relatório");
            System.out.println("0 - Sair");
            opcao = lerInt(sc, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    int ano = lerInt(sc, "Ano: ");
                    double preco = lerDouble(sc, "Preço de venda: ");
                    System.out.println("Tipo: 1-Carro  2-Moto");
                    int tipo = lerInt(sc, "Escolha tipo: ");
                    if (tipo == 1) {
                        int portas = lerInt(sc, "Número de portas: ");
                        cons.cadastrarVeiculo(new Carro(modelo, ano, preco, portas));
                    } else if (tipo == 2) {
                        int cil = lerInt(sc, "Cilindradas: ");
                        cons.cadastrarVeiculo(new Moto(modelo, ano, preco, cil));
                    } else if (tipo == 3) {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("Biotipo (alto/baixo/eletrico/outro): ");
                    String biotipo = sc.nextLine();
                    cons.cadastrarCliente(new Cliente(nome, biotipo));
                    break;

                case 3:
                    cons.exibirVeiculos();
                    break;

                case 4:
                    cons.exibirClientes();
                    break;

                case 5:
                    System.out.print("Nome do cliente para sugestão: ");
                    String busca = sc.nextLine();
                    cons.sugerirVeiculo(busca);
                    break;

                case 6:
                    System.out.print("Modelo do veículo a vender: ");
                    String modeloVenda = sc.nextLine();
                    System.out.print("Nome do cliente comprador: ");
                    String nomeCliente = sc.nextLine();
                    double precoCompra = lerDouble(sc, "Preço de compra (custo): ");
                    double precoVenda = lerDouble(sc, "Preço de venda (valor negociado): ");
                    try {
                        cons.venderVeiculo(modeloVenda, nomeCliente, precoCompra, precoVenda);
                    } catch (VeiculoNaoEncontradoException | ClienteNaoEncontradoException | PrecoInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 7:
                    cons.gerarRelatorioVendas();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
