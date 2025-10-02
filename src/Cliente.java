class Cliente {
    private String nome;
    private String biotipo;

    public Cliente(String nome, String biotipo) {
        this.nome = nome;
        this.biotipo = biotipo;
    }

    public void imprimirInformacoes() {
        System.out.println("Nome: " + nome + " | Biotipo: " + biotipo);
    }

    public String getBiotipo() {
        return biotipo;
    }
    
    public String getNome() {
        return nome; 
    }
}