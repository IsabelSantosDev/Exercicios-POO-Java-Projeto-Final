class Veiculo {
    protected String modelo;
    protected int ano;
    protected double preco;

    public Veiculo(String modelo, int ano, double preco) {
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public void imprimirInformacoes() {
        System.out.println("Modelo: " + modelo + " | Ano: " + ano + " | Preço: R$" + preco);
    }

    public double getPreco() {
        return preco;
    }

     public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }
}