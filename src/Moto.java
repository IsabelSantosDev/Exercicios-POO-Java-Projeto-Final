class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String modelo, int ano, double preco, int cilindradas) {
        super(modelo, ano, preco);
        this.cilindradas = cilindradas;
    }

    @Override
    public void imprimirInformacoes() {
        System.out.println("Moto: " + modelo + " | Ano: " + ano + " | Cilindradas: " + cilindradas + "cc | Preço: R$" + preco);
    }
}