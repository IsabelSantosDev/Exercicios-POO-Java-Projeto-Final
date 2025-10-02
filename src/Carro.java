class Carro extends Veiculo {
    private int portas;

    public Carro(String modelo, int ano, double preco, int portas) {
        super(modelo, ano, preco);
        this.portas = portas;
    }

    @Override
    public void imprimirInformacoes() {
        System.out.println("Carro: " + modelo + " | Ano: " + ano + " | Portas: " + portas + " | Preço: R$" + preco);
    }
}