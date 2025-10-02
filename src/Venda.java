public class Venda {
    private Veiculo veiculo;
    private Cliente cliente;
    private double precoCompra;
    private double precoVenda;
    
    public Venda(Veiculo veiculo, Cliente cliente, double precoCompra, double precoVenda) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public double getLucro() {
        return precoVenda - precoCompra;
    }
}
