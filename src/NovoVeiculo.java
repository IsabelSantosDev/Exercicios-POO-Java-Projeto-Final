public class NovoVeiculo extends Veiculo {
    private boolean eletrico;

    public NovoVeiculo(String modelo, int ano, double preco, boolean eletrico) {
        super(modelo, ano, preco);
        this.eletrico = eletrico;
    }

    @Override
    public void imprimirInformacoes() {
        System.out.println("Novo Veículo: " + modelo + " | Ano: " + ano + " | Elétrico: " + eletrico + " | Preço: R$" + preco);
    }
}